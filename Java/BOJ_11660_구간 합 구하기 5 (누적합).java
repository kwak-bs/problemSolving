package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11660 {
	// BOJ / 11660번 / 구간 합 구하기5 / 누적합, dp / 실버1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int map[][] = new int[n+1][n+1];
		int dp[][] = new int[n+1][n+1];
		for(int i=1; i<n+1; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<n+1; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
			}
		}
		
		while(m-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int r1 = Integer.parseInt(stk.nextToken());
			int c1 = Integer.parseInt(stk.nextToken());
			int r2 = Integer.parseInt(stk.nextToken());
			int c2 = Integer.parseInt(stk.nextToken());
			
			int sum = dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1] ;
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
