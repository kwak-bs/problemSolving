package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4375 {
	// BOJ / 4375번 / 1 / 수학 / 실3
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		int n;
		
		while((input = br.readLine()) != null) {

			n = Integer.parseInt(input);
			
			int count = 1;
			int one = 1;
			
			while(true) {
				
				if(one % n == 0) {
					break;
				}
				// one이 나눠지지 않으면 런타임 에러 (NumberFormat)방지를 위해
				// 미리 다음 11,111,1111,의 나머지를 가져온다.
				else {
					one = (one * 10) % n + 1;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
