package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	//BOJ / 2146번 / 다리 만들기 / 그래프 / 골3
	
	static int n, area, min;
	static int map[][], copy[][];
	static boolean visit[][];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
	
    static class dot {
		int y,x,count;
		
		public dot (int y, int x, int count) {
			this.y = y;
			this.x = x;
			this.count = count;
		}
	}
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());

		map = new int[n][n];
		copy = new int[n][n];
		visit = new boolean[n][n];
		area = 1;
		min = 99999;
		
		//입력
    	for(int i=0; i<n; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<n; j++) {
    			map[i][j] = Integer.parseInt(stk.nextToken());
    		}
    	}
    	
    	//육지별로 라벨링을 해준다. dfs 하기 위해 방문처리함.
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(map[i][j] == 1 && !visit[i][j]) {
    				area++;
    				dfs(i,j);
    			}
    		}
    	}
    	// 브루트 포스로 모든 구간을 다 돌거기 때문에 copy map이 필요함
    	copyMap();

    	// 라벨링이 2 이상부터 되어 있기 때문에 육지는 전부다 bfs 돌아준다.
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			if(copy[i][j] >= 2) {
    		    	bfs(i, j);
    		    	copyMap();
    			}
    		}
    	}

		
    	System.out.println(min);
	}
    
    public static void bfs(int startY, int startX) {
    	Queue<dot> q = new LinkedList<>();

    	q.offer(new dot(startY,startX, 0));
    	
    	while(!q.isEmpty()) {
    		
    			dot now = q.poll();
    			
    			for(int i=0; i<4; i++) {
    				int ny = now.y + dy[i];
    				int nx = now.x + dx[i];
    				int nc = now.count + 1;
    				if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
    					// 다음 위치가 시작 지점의 육지와 같다면 continue
    					if(copy[ny][nx] == copy[startY][startX]) {
    						continue;
    					}
    					// 다음 위치가 이미 세워진 다리라면 continue
    					if(copy[ny][nx] == -1) {
    						continue;
    					}
    					// 위에서 예외 처리를 해줬기 때문에 여기선 무조건 다음 섬일 수 밖에 없다. 
    					// 모든 경우를 돌면서 다음 섬을 만나기 직전의 값을 비교해서 최솟값으로 지정.
    					if(copy[ny][nx] != 0) {
    						min = Math.min(min, nc-1);
    						return;
    					}
    					// 다리를 놓을 때는 방문 처리를 위하여 -1로 해준다.
    					if(copy[ny][nx] == 0 ) {
    						copy[ny][nx] = -1;
    						q.offer(new dot(ny,nx,nc));
    					}
    				}	
    			}
    	}
    }
    
    // dfs로 섬마다 라벨링을 해준다. 
    public static void dfs(int y, int x) {
		map[y][x] = area;
    	
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny >= 0 && ny < n && nx >= 0 && nx < n) {
				if(map[ny][nx] == 1 && !visit[ny][nx]) {
					dfs(ny,nx);
				}
			}	
		}
    	
    }
    
    public static void copyMap() {
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			copy[i][j] = map[i][j];
    		}
    	}
    }
    
    public static void print(int[][] test) {

    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(test[i][j]);
    		}
    		System.out.println();
    	}
    }	
}
