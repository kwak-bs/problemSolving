package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {
	//BOJ / 2231번 / 분해 합 / 브루트포스 알고리즘 / 브2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		int ans = 0; 
		
		// 입력 전까지 전 구간을 다 돈다.(브르투포스)
		for(int i = 0; i < input; i++) {
			int num = i;
			int sum = 0;
			
			// num이  0이상이면
			while(num > 0) {
				sum += num % 10; // 각 자리수의 합을 sum에 더해준다.
				num /= 10; // 현재 숫자 (i)도 똑같이 나눠준다.
			}
			
			if( sum + i == input) { // 각 자리수의 합(sum)과 현재 수(i)의 합이 input과 같으면
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
