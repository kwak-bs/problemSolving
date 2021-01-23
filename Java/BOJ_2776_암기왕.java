package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2776 {
	// BOJ / 2776번 / 암기왕 / 해시 / 실3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		while ( t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			stk  = new StringTokenizer(br.readLine(), " ");
			
			int memo1[] = new int[n];
			for(int i=0; i<n; i++) {
				memo1[i] = Integer.parseInt(stk.nextToken());
			}
			Arrays.sort(memo1);
			
			int m = Integer.parseInt(br.readLine());
			stk  = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<m; i++) {
				int num = Integer.parseInt(stk.nextToken());
				
				int start = 0;
				int end = n;
				// 이분 탐색 정렬 
				while(start < end) {
					int mid = (start + end) / 2;
				
					if(num > memo1[mid]) {
						start = mid + 1;
					}
					else {
						end = mid;
					}
				}
				//System.out.println(end);
				if(end < n && memo1[end] == num) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		// 하 출력을 마지막에 써줘야지 하ㅡㅡ while문 안에 써주면 어쩌자는거냐 하 ㅡ ㅡ 
		System.out.println(sb.toString());
	}
}
