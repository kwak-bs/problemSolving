package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461 {
	// BOJ / 9461번 / 파도반 수열 / 자료구조 / 실버3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			long dp[] = new long[n+1];
			dp[0] = 0;
			dp[1] = 1;
			if(n > 1) dp[2] = 1;
			if(n > 2) dp[3] = 1;
			for(int i=4; i<=n; i++) {
				dp[i] = dp[i-3] + dp[i-2];
			}
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}
