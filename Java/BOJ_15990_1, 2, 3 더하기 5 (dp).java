package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15990 {
	// BOJ / 15990번 / 1,2,3 더하기 5 / DP / 실3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		long dp[][] = new long[100001][4];
		long ans[] = new long[100001];
		dp[1][1] = 1; dp[2][2] = 1; dp[3][3] = 1; 
		
		for(int i=1; i<dp.length; i++) {
			if(i>1)dp[i][1] = (dp[i-1][2] + dp[i-1][3])%1000000009;
			if(i>2)dp[i][2] = (dp[i-2][1] + dp[i-2][3])%1000000009;
			if(i>3)dp[i][3] = (dp[i-3][1] + dp[i-3][2])%1000000009;
			
			ans[i] = (dp[i][1] + dp[i][2] + dp[i][3])%1000000009;
		}
		
		
		StringBuffer sb = new StringBuffer();
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(ans[n]).append("\n");
		}
		System.out.println(sb);
	}
}
