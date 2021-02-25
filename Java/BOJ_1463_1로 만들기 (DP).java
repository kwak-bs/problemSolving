package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1463 {
	// BOJ / 1463번 / 1로 만들기  / DP / 실3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1000001];
		
		dp[1] = 0; dp[2] = 1; dp[3] = 1;
		
		for(int i=4; i<dp.length; i++) {
			dp[i] = dp[i-1] +1 ;
			
			if(i % 3 == 0 && dp[i/3] + 1 < dp[i]) {
				dp[i] = dp[i/3] +1;
			}
			if(i % 2 == 0 && dp[i/2] + 1 <dp[i] ) {
				dp[i] = dp[i/2] + 1;
			}
		}
		
		System.out.println(dp[n]);
	}
}
