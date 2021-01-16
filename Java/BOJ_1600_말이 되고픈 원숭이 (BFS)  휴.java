package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
	//BOJ / 1600번 / 말이 되고픈 원숭이 / 그래프 / 골5
	static int [][] map;
	static boolean [][][] visit;
	static int y,x, result, limit;
	static int [] dy = {1, -1, 0, 0};
	static int [] dx = {0, 0, 1, -1};
	static int [] hy = {-2, -2, 2, 2, 1, -1, 1, -1};
	static int [] hx = {1, -1, 1, -1, 2, 2, -2, -2};
	static dot start, end;
	
	static class dot {
		int y,x, jump;
		
		public dot(int y, int x, int jump) {
			this.y = y;
			this.x = x;
			this.jump = jump;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		limit = Integer.parseInt(br.readLine());
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(stk.nextToken());
		y = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		// visit 배열을 3차원으로 선언해준다. 맨 앞에 동작 제한 횟수 + 1 한값을 저장한다.
		// 기준은 말 동작 남은 횟수이다.
		visit = new boolean[limit+1][y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		start = new dot(0,0,0);
		end = new dot(y-1,x-1, 0);
		visit[0][0][0] = true;
		bfs(start);
	}
	
	public static void bfs(dot dot) {
		Queue<dot> q = new LinkedList<>();
		q.offer(dot);

		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) {
				dot now = q.poll();
				//System.out.println(now.y + " " + now.x+ " " + now.jump);
				
				if(now.x == end.x && now.y == end.y) {
					System.out.println(result);
					return;
				}
				
				// 사면 탐색 
		        for (int i = 0; i < 4; i++) {
		            int ny = now.y + dy[i];
		            int nx = now.x + dx[i];
		           
		            if (0 <= ny && ny < y && 0 <= nx && nx < x ) {
		            	if(map[ny][nx] == 0 &&
			            		!visit[now.jump][ny][nx]) {
		            		// 걸었을 경우 현재 남은 말 동작 횟수 visit 배열에 체크해준다.
		            		visit[now.jump][ny][nx] = true;
		            		q.offer(new dot (ny,nx, now.jump));	
		            	}
		            }
		        }
		        
		        // 말 점프 탐색
		        if(now.jump < limit) {
		        	for (int i = 0; i < 8; i++) {
		        		int ny = now.y + hy[i];
		        		int nx = now.x + hx[i];

		        		if (0 <= ny && ny < y && 0 <= nx && nx < x ) {
		        			if(map[ny][nx] == 0 && 
			        				!visit[now.jump+1][ny][nx]) {
		        				// 점프를 했을 경우에는 현재 값에 +1 값을 체크해준다.
		        				visit[now.jump+1][ny][nx] = true;
		        				q.offer(new dot (ny,nx,now.jump+1));	
		        			}
		        		}
		        	}
		        }
			}
			result++;
		}
		System.out.println(-1);
		return;
	}
}
