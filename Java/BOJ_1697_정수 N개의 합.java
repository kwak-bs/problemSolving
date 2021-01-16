package problemSolve;

public class Test {
	//BOJ / 1697번 / 정수 N개의 합 / 사칙연산, 구현, 수학 / 브2
	public static long sum(int[] a) {
		long answer = 0; 
		
		for(int i =0; i<a.length; i++) {
			answer += a[i];
		}
		
		return answer; 
	}
}
