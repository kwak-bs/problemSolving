package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {
	// BOJ / 10972번 / 다음 순열 / 브루트포스 / 실3
	static int n;
	static int num[];
	static int print[];
	static boolean visit[];
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		num = new int [n];
		visit = new boolean[n];
		print = new int[n];
		sb = new StringBuffer();
		boolean possible = false;
		int mark = 0;
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=num.length-1; i>=1; i--) {
			
			if(num[i] > num[i-1]) {
				possible = true;
				mark = i;
				break;
			}
		}
		
		if(possible) {
			solution(mark);
		}
		else {
			sb.append(-1);
		}
		
		System.out.println(sb);
	}
	
	public static void solution(int mark) {
		
		for(int i=num.length-1; i>=mark; i--) {
			// swap
			if(num[mark-1] < num[i]) {
				int temp = num[i];
				num[i] = num[mark-1];
				num[mark-1] = temp;
				break;
			}
		}
		// 우측 영역 오름차순 정렬
		Arrays.sort(num, mark, num.length);
		
		for(int i=0; i<num.length; i++) {
			sb.append(num[i]).append(" ");
		}
	}
}
