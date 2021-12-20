package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5086 {
	// BOJ / 5086번 / 배수와 약수 / 구현 / 브론즈3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			if(a == 0 && b == 0) {
				break;
			}
			
			if(isFactor(a, b)) {
				sb.append("factor");
			}
			else if(isMultiple(a,b)) {
				sb.append("multiple");
			}
			else {
				sb.append("neither");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static boolean isFactor(int a, int b) {
		
		if(b % a == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isMultiple(int a, int b) {
		
		if(a % b == 0) {
			return true;
		}
		return false;
	}
}
