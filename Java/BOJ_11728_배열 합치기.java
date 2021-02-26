package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {
	// BOJ / 11728번 / 배열 합치기 / 투 포인터 / 실5
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		
		int ans [] = new int [a+b];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<a; i++) {
			ans[i] = Integer.parseInt(stk.nextToken());
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=a; i<a+b; i++) {
			ans[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(ans);
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<ans.length; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		System.out.println(sb);
	}
}
