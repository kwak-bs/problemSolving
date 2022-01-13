package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
	// BOJ / 1024번 / 수열의 합 / ? / 실버2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // 배열 요소의 합
		int l = Integer.parseInt(stk.nextToken()); // 배열 최소 길이
		StringBuilder sb = new StringBuilder();
		boolean brk = false;
		
		while(l <= 100) {
			// 짝수면 1을 더 빼주고, 홀수면 안빼줌 
			int temp = l % 2 == 0 ? 1 : 0;
			// 초깃값 
			int value = (n / l) - (l/2) + temp;
			if(value < 0) {
				l++; 
				continue;
			}
			int sum = 0;
			int arr[] =  new int[l];
			
			for(int i=0; i<l; i++) {
				sum += value;
				arr[i] = value;
				value++;
			}
			if(sum == n) {
				for(int v : arr) {
					sb.append(v).append(" ");
				}
				brk = true;
				break;
			}
			l++;
		}
		if(brk) {
			System.out.println(sb);			
		}
		else {
			System.out.println(-1);
		}
	}
}
