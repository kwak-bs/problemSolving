package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_1261 {
	// BOJ / 1261¹ø / ¾Ë°í½ºÆÌ / ±×·¡ÇÁ / °ñµå4
	static int y,x, map[][], ans;
	static boolean visit[][];
	static int dy[] = {1,0,-1,0};
	static int dx[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		x = Integer.parseInt(stk.nextToken());
		y = Integer.parseInt(stk.nextToken());
		
		map = new int[y+1][x+1];
		visit = new boolean[y+1][x+1];
		ans = 0;
		for(int i=1; i<y+1; i++) {
			String s = br.readLine();
			for(int j=1; j<x+1; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		bfs(1,1,0);
		
		System.out.println(ans);
	}
	
	public static void bfs(int yy, int xx, int cost) {
		ArrayDeque<dot> dq = new ArrayDeque<>();
		dq.offer(new dot(yy, xx, cost));
		visit[yy][xx] = true;

		while(!dq.isEmpty()) {
			
			dot now = dq.poll();

			if(now.y == y && now.x == x) {
				ans = now.cost;
				break;
			}
			
			for(int i=0; i<dy.length; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				
				if(ny >0 && ny <= y && nx > 0 && nx <=x) {

					if(!visit[ny][nx] && map[ny][nx] == 0) {
						visit[ny][nx] = true;
						dq.addFirst(new dot(ny,nx, now.cost));
					}
					else if(!visit[ny][nx] && map[ny][nx] == 1) {
						visit[ny][nx] = true;
						dq.addLast(new dot(ny,nx,now.cost+1));
					}
				}
			}
		}
		
	}
	
	private static class dot {
		int y,x, cost;
		
		public dot (int y, int x, int cost) {
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
	}
}
