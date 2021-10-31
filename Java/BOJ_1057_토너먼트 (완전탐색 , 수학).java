package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057 {
	// BOJ / 1057번 / 토너먼트 / 완전탐색, 수학 / 실버3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken()); // 김지민
		int l = Integer.parseInt(stk.nextToken()); // 임한수 

		int round = 0;
		while(k != l) {
			
			k = k / 2 + k % 2;
			l = l / 2 + l % 2;
			round++;
		}
		
		System.out.println(round);
	}

}
