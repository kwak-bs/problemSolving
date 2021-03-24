package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1182 {
	// BOJ / 1182번 / 부분수열의 합 / 재귀 / 실버2
	static int count, num[], n ,s;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");	
		
		n = Integer.parseInt(stk.nextToken());
		s = Integer.parseInt(stk.nextToken());
		num = new int[n];
		stk = new StringTokenizer(br.readLine(), " ");	
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}

		go(0, 0);
		
		if(s == 0) {
			count--;
		}
		System.out.println(count);
	}
	
	public static void go(int sum, int index) {
		
		if(index == n) {
			if(sum == s) {
				count++;
				return;
			}
			else {
				return;
			}
		}
		
		// 포함
		go(sum + num[index], index+1);
		// 미포함
		go(sum, index+1);
	}
}
