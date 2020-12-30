package problemSolve;

import java.util.Scanner;

public class BOJ_5554 {
	// BOJ / 5554번 / 심부름 가는 길 / 수학, 사칙연산, 구현 / 브5
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0; i<4; i++) {
			int seconds = sc.nextInt();
			sum += seconds;
		}
		
		System.out.println(sum / 60);
		System.out.println(sum % 60);
	}
}
