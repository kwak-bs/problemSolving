package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_16234 {
	// BOJ / 16234번 / 인구 이동 / bfs / 골드5
	
	static int n,l,r;
	static int map[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		l = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int ans = 0;
		while(true) {
			if(bfs()) {
				ans++;
			}
			else {
				break;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean bfs() {
		boolean c[][] = new boolean[n][n];
		boolean union = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!c[i][j]) {
					Queue<info> q = new LinkedList<>();
					Stack<info> st = new Stack<>();
					q.add(new info(i,j));
					st.add(new info(i,j));
					c[i][j] = true;
					
					int sum = map[i][j];
					while(!q.isEmpty()) {
						info now = q.poll();
						
						for(int d=0; d<4; d++) {
							int ny = now.y + dy[d];
							int nx = now.x + dx[d];
							
							if(ny >=0 &&  ny <n && nx >=0 && nx < n) {
								if(c[ny][nx]) continue;
								int diff = Math.abs(map[now.y][now.x] -map[ny][nx]);
								if(diff>= l && diff<=r) {
									q.offer(new info(ny,nx));
									st.add(new info(ny,nx));
									c[ny][nx] = true;
									sum += map[ny][nx];
									if(!union) union = true;
								}
							}
						}
					}
					int p = sum / (st.size());
					while(!st.isEmpty()) {
						info now = st.pop();
						
						map[now.y][now.x] = p;
					}
				}
			}
		}
		
		return union; 
	}
	static class info {
		int y;
		int x;
		
		public info(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
