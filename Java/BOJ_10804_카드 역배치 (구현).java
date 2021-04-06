package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10804 {
	// BOJ / 10804번 / 카드 역배치 / 구현 / 브론즈2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num[] = new int[20];
		
		for(int i=0; i<20; i++) {
			num[i] = i+1;
		}
		int t = 10;
		StringTokenizer stk;
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken())-1;
			int b = Integer.parseInt(stk.nextToken())-1;
			
			while(a < b) {
				int temp = num[a];
				num[a] = num[b];
				num[b] = temp;
				a++;
				b--;
			}
		}
		
		for(int i=0; i<20; i++) {
			System.out.print(num[i] + " ");
		}
	}
}
