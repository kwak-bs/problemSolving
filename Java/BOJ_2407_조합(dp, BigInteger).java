package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407 {
	// BOJ / 2407번 / 조합 /  / 실버2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		long ans = 1;
		
		BigInteger[][] dp = new BigInteger[101][101];
		dp[1][0] = dp[1][1] = BigInteger.ONE;
		
		for(int i=2; i<=100; i++) {
			for(int j=0; j<=i; j++) {
				if(j == 0 || i == j) dp[i][j] = BigInteger.ONE;
				else dp[i][j] = dp[i-1][j].add(dp[i-1][j-1]);
			}
		}
		
		System.out.println(dp[n][m]);
	}
}
