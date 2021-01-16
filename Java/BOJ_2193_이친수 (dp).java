package problemSolve;

import java.util.Scanner;

public class BOJ_2193 {
	//BOJ / 2193번 / 이친수  / dp  / 실3
	static int n;
	static long dp[];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new long[n];
		
		// n이 1일 경우.
		if(n > 0) {
			dp[0] = 1;
		}
		
		// n이 2 이상일 경우
		if(n > 1) {
			dp[1] = 1;
			// 점화식 세워보니 피보나치 
			for(int i=2; i<n; i++) {
				dp[i] = dp[i-2] + dp[i-1];
			}

		}
		System.out.println(dp[n-1]);
	}
	
}
