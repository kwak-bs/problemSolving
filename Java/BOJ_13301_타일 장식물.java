package problemSolve;

import java.util.Scanner;

public class BOJ_13301 {
	//BOJ / 13301번 /  타일 장식물 / DP / 브1
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// n은 1부터 입력
		int n = sc.nextInt();
		
		long dpRound[] = new long[n]; // 둘레 저장
		
		dpRound[0] = 4;
		
		if(n > 1 ) { // n이 1 이상일 때 
			dpRound[1] = 6;
		}
		
		for(int i=2; i<n; i++) { // dp
			dpRound[i] = dpRound[i-2] + dpRound[i-1];
		}
		
		System.out.println(dpRound[n-1]);
	}
}
