package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4101 {
	// BOJ / 4101번 / 크냐? / 구현  / 브론즈3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk;
		while(true) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			if(a == 0 && b == 0) {
				break;
			}
			
			if(a > b) {
				sb.append("Yes");
			}
			else sb.append("No");
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
