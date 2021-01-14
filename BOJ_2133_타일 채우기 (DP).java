package problemSolve;

import java.util.Scanner;

public class BOJ_2133 {
	// BOJ / 1912번 / 타일 채우기 / dp / 실2
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		

		int dp[] = new int[n+1];


		if(n % 2 == 0) {
			dp[2] = 3;
			// dp[4]인 경우 dp[0]을 참조하기 때문에 dp[0]도 설정해줘야함
			// 또한, 마지막 특수 케이스 2가지를 더해주는 역할도 함.
			dp[0] = 1;  

			for(int i=4; i<=n; i+=2) {
				dp[i] = dp[i-2] * 3;
				for(int j=0; j<i-2; j+=2) {
					dp[i] += dp[j] * 2; 					
				}
			}
			

		}	
		System.out.println(dp[n]);

	}
}
