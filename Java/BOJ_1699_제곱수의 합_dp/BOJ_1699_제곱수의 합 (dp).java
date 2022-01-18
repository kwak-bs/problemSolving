package problemSolve;

import java.util.Scanner;

public class BOJ_1699 {
	//BOJ / 1699�� / �������� �� / dp, ���� / ��3
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		int dp [] = new int[n+1];
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			dp[i] = i; // dp[i]�� i�� �ʱ�ȭ. 
			
			// dp[11] = dp[7]+1 or dp[2]+1 �߿� �ּҰ��̴�.
			// ��  ���踦 ��ȭ������ ã�Ƽ� Ǯ���.
			for(int j=1; j*j<=i; j++) { 
				dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
