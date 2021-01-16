package problemSolve;

import java.util.Scanner;

public class BOJ_11727 {
	//BOJ / 11727번 /  2 x N 타일링2 / dp / 실3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long dp [] = new long[n];
		
		dp[0] = 1; // n이 1일때			
		
		if(n > 1) { // n이 1 이상일 때 
			dp[1] = 3; //n이 2일때
		}
		
		for(int i=2; i<n; i++) {
			dp[i] = dp[i-1] + (dp[i-2] * 2);
			dp[i] %= 10007;   // 여기서 계산 해줘야함 21번째 줄에서 한번에 계산할라고 하니까 오류 씨게남
		}
		System.out.println(dp[n-1]);
	}
}
