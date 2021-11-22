package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1225 {
	// BOJ / 1225번 / 이상한 곱셈 / 구현 / 브론즈2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		String a = stk.nextToken();
		String b = stk.nextToken();
		
		long answer = 0;
		
		for(int i=0; i<a.length(); i++) {
			int aNum = Integer.parseInt(a.charAt(i)+"");
			for(int j=0; j<b.length(); j++) {
				int bNum = Integer.parseInt(b.charAt(j)+"");
				answer += aNum*bNum;
			}
		}
		System.out.println(answer);
	}
}
