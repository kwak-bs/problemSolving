package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
	// BOJ / 14888번 / 연산자 끼워넣기 / 브루트포스, 백트래킹 / 실1
	static int n, max, min;
	static int[] num, exp;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		exp = new int[4];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		
		// 숫자 입력
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 수식 입력
		// 덧셈 뺄셈 곱셈 나눗셈
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<4; i++) {
			exp[i] = Integer.parseInt(stk.nextToken());
		}
		
		dfs(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	
	// 백트래킹 이용 
	public static void dfs(int number, int next) {
		
		if(next == n) {
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		
		// 브르투 포스 
		for(int i=0; i<4; i++) {
			// 연산자 갯수가 1개 이상이면
			if(exp[i] > 0) {
				// 해당 연산자 1 감소
				exp[i] --;
				
				switch(i) {
				
				case 0 : dfs(number + num[next], next+1);
					break;
				case 1 : dfs(number - num[next], next+1);
					break;
				case 2 : dfs(number * num[next], next+1);
					break;
				case 3 : dfs(number / num[next], next+1);
					break;
				}
				// 재귀호출이 종료되면 백트래킹을 통해 해당 연산자 갯수 복구.
				exp[i]++;
			}
		}
	}
}







