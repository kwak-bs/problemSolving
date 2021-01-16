package problemSolve;

import java.util.Scanner;

public class BOJ_1699 {
	//BOJ / 1699번 / 제곱수의 합 / dp, 수학 / 실3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		int dp [] = new int[n+1];
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = i; // dp[i]를 i로 초기화. 
			
			// dp[11] = dp[7]+1 or dp[2]+1 중에 최소값이다.
			// 이  관계를 점화식으로 찾아서 풀면됨.
			for(int j=1; j*j<=i; j++) { 
				dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
