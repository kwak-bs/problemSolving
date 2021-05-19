package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {
	// BOJ / 11653번 / 소인수분해 / 수학 / 실버4
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		int n = Integer.parseInt(br.readLine());
		// 소수를 구할땐 제곱근 까지만 구해줘도된다.
		for(int i =2; i<=Math.sqrt(n); i++) {
			while(n % i == 0) {
				sb.append(i).append("\n");
				n /= i;
			}			
		}
		if(n != 1) {
			sb.append(n);
		}
		System.out.println(sb);
	}

}
