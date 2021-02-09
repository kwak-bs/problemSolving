package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743 {
	// BOJ / 1743번 / 음식물 피하기 / DFS / 실버1
	
	static int map [][];
	static boolean visit[][];
	
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static int n,m,k, count;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
	
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		
		map = new int [n][m];
		visit = new boolean[n][m];
		int answer = 0;
		for(int i=0; i<k; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			
			map[y-1][x-1] = 1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				count = 1;
				if(map[i][j] == 1) {
					answer = Math.max(answer, dfs(i,j));
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static int dfs(int yy, int xx) {
		visit[yy][xx] = true;
		
		for(int i=0; i<dx.length; i++) {
			int ny =  yy + dy[i];
			int nx =  xx + dx[i];
			
			if(ny >= 0 && ny < n && nx >= 0 && nx < m ) {
				if(!visit[ny][nx] && map[ny][nx] == 1) {
					dfs(ny, nx);
					count++;
				}
			}
		}
		
		return count;
	}
}
