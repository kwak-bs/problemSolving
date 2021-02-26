package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {
	// BOJ / 10844번 / 쉬운 계단 수 / DP / 실1
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long dp[][] = new long[101][10];
		long ans = 0;
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		for(int i=2; i<dp.length; i++) {
			for(int j=0; j<=9; j++) {
				if(j == 9) {
					dp[i][j] = (dp[i-1][j-1]);
					continue;
				}
				else if(j == 0) {
					dp[i][j] = (dp[i-1][j+1]);
					continue;
				}
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;					
 			}
		}
		
		for(int i=0; i<=9; i++) {
			ans += dp[n][i];
		}
		System.out.println(ans%1000000000);
	}
}
