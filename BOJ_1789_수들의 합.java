package problemSolve;

import java.util.Scanner;

public class BOJ_1789 {
	// BOJ / 1789번 / 수들의 합 / 이분 탐색 / 실5
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong(); // n이란 서로 다른 n개의 자연수의 갯수를 의미한다. 즉, 합에 사용되는 자연수의 최대 갯수이다.
		long sum = 0;
		long num = 0;
		
		while(sum <= n) { // n을 넘기면 break;
			num++;
			sum += num;
		}
		
		System.out.println(num-1);
	}
}
