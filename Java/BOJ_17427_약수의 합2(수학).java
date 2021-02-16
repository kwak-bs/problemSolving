package problemSolve2;

import java.util.Scanner;

public class BOJ_17427 {
	// BOJ / 17427번 / 약수의 합 2  / 수학 / 실3
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long gsum = 0;
		
		// n이하 수들의 모든 약수의 합은 
		// 1부터 n까지의 수를 i라 가정하면 
		// n으로 나눈 몫을 i에 곱해주고 더해주면 된다. 
		for(int i=1; i<=n; i++) {
			
			int tmp = n / i;
			
			gsum += (tmp * i);
		}
		System.out.println(gsum);
	}
}
