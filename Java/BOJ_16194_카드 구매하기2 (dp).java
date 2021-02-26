package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {
	// BOJ / 16194번 / 카드 구매하기 2 / dp / 실버1
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		
		int p[] = new int[n+1];
		int dp[] = new int[n+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i=1;i<p.length; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		if(n > 0) {
			dp[1] = p[1];
		}
		for(int i=2; i<=n; i++) {
			dp[i] = p[i];
			for(int j=1; j<i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + p[j]);
			}
		}
		
		System.out.println(dp[n]);
	}
}
