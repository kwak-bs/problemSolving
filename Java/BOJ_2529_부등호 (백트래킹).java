package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2529 {
	// BOJ / 2529번 / 부등호 / 브루트포스 / 실2
	static int n; 
	static long max,min;
	static String maxStr,minStr;
	static int print[];
	static boolean visit[];
	static String sign[];
	static StringBuffer sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		sign = new String[n];
		print = new int[n+1];
		visit = new boolean[10];
		sb = new StringBuffer();
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			sign[i] = stk.nextToken();
		}
		
		recursion(0);
		
		sb.append(maxStr).append("\n").append(minStr);
		System.out.println(sb);
	}
	public static void recursion(int depth) {
		
		if(depth == n+1) {
			// 주어진 부등호와 선택된 숫자가 관계를 만족하면

			String s = "";
				
			for(int value : print) {
				s += value;
			}
			long temp = Long.parseLong(s);
				
			// 첫 자리에 0이 존재하는 경우가 있으므로 String에 저장해준다.
			if(temp > max) {
				max = temp;
				maxStr = s;
			}
			if(temp < min) {
				min = temp;
				minStr = s;
			}
	
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(visit[i]) {
				continue;
			}
			if(depth == 0 || good((char)(print[depth-1]), (char)(i),sign[depth-1])) {
				visit[i] = true;
				print[depth] = i; 
				recursion(depth + 1);
				visit[i] = false;
			}
		}
	}
	// 미리 검사한다.
	public static boolean good(char x, char y, String op) {
		if(op.equals("<")) {
			if(x > y) return false;
		}
		if(op.equals(">")) {
			if(x < y) return false;
		}
		return true;
	}
	
}
