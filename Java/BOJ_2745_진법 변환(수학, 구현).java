package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {
	// BOJ / 2745번 / 진법 변환 / 구현 / 브론즈2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		String n = stk.nextToken();
		int b = Integer.parseInt(stk.nextToken());

		int result = 0;
		for(int i=0; i<n.length(); i++) {
			char num = n.charAt(i);
			if(num >= 'A') {
				result = result * b + (num - 'A' + 10);
			}
			else {
				result = result * b + (num - '0');
			}
		}
		System.out.println(result);
	}
}
