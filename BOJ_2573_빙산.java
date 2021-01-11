package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
	// BOJ / 2573번 / 빙산 / 그래프 / 골4
	static int y, x, year;
	static int map[][], copy[][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0}; // 상하좌우
	static int dx[] = {0,0,-1,1};
	
	static class dot {
		int y;
		int x;
		
		public dot(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken()); 
		x = Integer.parseInt(stk.nextToken());
		
		map = new int[y][x];
		visit = new boolean[y][x];
		copy = new int[y][x];
		
		// map 입력
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// copy배열(int) 과 visit배열(boolean)에 복사
		copyMap();
		
		// 애초에 두 덩이 인경우 0을 출력
		if(check() > 1) {
			System.out.println(0);
		}
		else {
			//check 진행하면서 몇몇이 false로 바꼈을테니 재복사.
			copyMap();
			bfs();		
			System.out.println(year);
		}
	}
	
	// bfs진행하면서 빙산을 녹인다. 
	// 매 년 마다 dfs돌면서 check를 해준다.
	public static void bfs() {
		Queue<dot> q = new LinkedList<>();
		
		int separated = 0;
		
		// 초기에 0이 아닌 곳은 q에 다 넣어줌.
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] != 0) {
					q.offer(new dot(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			// qSize가 year가 될것임.
			while(qSize-- > 0 ) {
				dot now = q.poll();
				
				for(int i=0; i<4; i++) {
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];
					
					if(ny>=0 && ny<y && nx>=0 && nx<x ) {
						//copy배열은 수정 전 배열이므로 copy배열을 기준으로  map 배열을 수정한다.
						if(copy[ny][nx] == 0) {
							
							// map 배열은 앞으로 바뀔(1년 뒤) 배열.
							if(map[now.y][now.x] > 0) {
								map[now.y][now.x]--;
							}
						}
					}
				}	
				
				// 주변 0의 영향으로 0이 됐으면 visit[][] = false;
				if(map[now.y][now.x] == 0) {
					visit[now.y][now.x] = false;
				} else {
					// 아직 0이 되지 않았으면 큐에 넣는다.
					q.offer(new dot(now.y, now.x));		
				}
			}
			year++;

			// map이 1년 뒤 버전으로 수정됐으므로, copy배열과 visit배열을 최신화한다.
			copyMap();
			
			// 최신화된 visit 배열을 기준으로 분리된 빙산의 영역 갯수를 구한다.
			// 영역 갯수를 구하는 방법은 dfs다.
			separated = check();

			// 분리된 빙산의 갯수가 2개 이상이면은 return한다.
			if(separated == 2) {
				return;
			}
		}
		// 빙산이 다 녹을 때까지 분리되지 않으면 0을 출력한다. 
		if(separated < 2) {
			year = 0;
		}
	}
	
	// 분리된 빙산을 dfs 탐색한다. 
	public static void dfs(int yy, int xx) {

	     for (int i = 0; i < 4; i++) {
	            int ny = yy + dy[i];
	            int nx = xx + dx[i];

	      if (0 <= ny && ny < y && 0 <= nx && nx < x) {
	               if (visit[ny][nx]) {
	                    visit[ny][nx] = false;
	                    dfs(ny, nx);
	                }
	            }
	     }
	}
	
	// 말 그대로 배열을 복사하고 값이 있는 인덱스는 true로 visit 배열에 설정해준다.
	public static void copyMap() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
				if(copy[i][j] != 0) {
					visit[i][j] = true;
				}
			}
		}
	}
	
	// 분리된 빙산의 영역 갯수를 구한다. 
	public static int check() {
		int count = 0;
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(visit[i][j]) {
					
					// 분리된 빙산의 영역이 2를 넘어가면 바로 return한다. 
					if(count >= 2) {
						return count;
					}
					
					visit[i][j] = false;
					dfs(i,j);
					count++;
				}
			}
		}
		
		return count;
	}
}
