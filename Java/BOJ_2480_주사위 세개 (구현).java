package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480 {
	// BOJ / 10804번 / 카드 역배치 / 구현 / 브론즈2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int num[] = new int[6];
		
		for(int i=0; i<3; i++) {
			int n = Integer.parseInt(stk.nextToken());
			num[n-1]++;
		}
		
		int same = 1;
		int n = 0;
		
		for(int i=0; i<num.length; i++) {
			if(same < num[i]) {
				same = num[i];
				n = i+1;
			}
			else if(same == num[i]) {
				if(n < i+1) {
					n = i+1;
				}
			}
		}
		
		if(same == 3) {
			System.out.println(10000 + (n * 1000));
		} else if(same == 2) {
			System.out.println(1000 + (n  * 100));
		} else {
			System.out.println(100 * n);
		}
	}
}
