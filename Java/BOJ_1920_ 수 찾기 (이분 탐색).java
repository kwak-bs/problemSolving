package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
	// BOJ / 1920번 / 수 찾기 / 이분 탐색 / 실버2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		long a[] = new long[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			long input= Long.parseLong(stk.nextToken());
			a[i] = input;
		}
		Arrays.sort(a);
		
		int m = Integer.parseInt(br.readLine());
		long b[] = new long[m];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			long input = Long.parseLong(stk.nextToken());
			b[i] = input;
		}
		
		for(int i=0; i<m; i++) {
			long num = b[i];
			
			int st = 0;
			int end = a.length-1;
			boolean find = false;
			while(st <= end) {
				int mid = (st + end) / 2;
				
				if(a[mid] > num) {
					end = mid-1;
				}
				else if(a[mid] < num) st = mid+1;
				else {
					sb.append(1).append("\n");
					find = true;
					break;
				}
			}
			
			if(!find) sb.append(0).append("\n");
		}
		
		System.out.println(sb);
	}
}
