package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	// BOJ / 9095번 / 1, 2, 3 더하기  / DP / 실3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int t = Integer.parseInt(br.readLine());
		int dp[] = new int[11];
		
		dp[1]=1; dp[2]=2; dp[3]=4;
		
		for(int i=4; i<dp.length; i++) {
			dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
		}
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}
