package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
	// BOJ / 15649번 / NM과 K (1) / 백트래킹 / 실1
	
	static int n,m,k,max;
	static int list [][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		
		list = new int [n][m];
		visit = new boolean[n][m];
		max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				list[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int depth, int plus) {
		
		if(depth == k) {
			max = Math.max(plus, max);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visit[i][j]) {
					boolean ok = true;
					
					for(int k=0; k<4; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];
						
						if(ny>=0 && ny <n && nx >=0 && nx <m) {
							if(visit[ny][nx]) ok = false;
						}
					}	
					if(ok) {
						visit[i][j] = true;
						dfs(depth+1, plus + list[i][j]);
						visit[i][j] = false;
					}
				}
			}
		}
	}

}
