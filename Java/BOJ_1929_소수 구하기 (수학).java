package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
	// BOJ / 1929번 / 소수 구하기  / 수학 / 실2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int min = Integer.parseInt(stk.nextToken());
		int max = Integer.parseInt(stk.nextToken());
		
		boolean flag = true;
		
		for(int i=min; i<=max; i++) {
			if(i == 1) {
				flag = false;
			}
			
			int mmax = (int)Math.sqrt(i)+1;
			for(int j=2; j<mmax; j++) {
				if(i % j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(i);
			}
			flag = true;
		}
	}
}
