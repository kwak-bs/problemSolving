package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	// BOJ / 11052번 / 카드 구매하기 / DP / 실1
	
	static int p[];
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		p = new int[n+1];
		dp = new int[n+1];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<p.length; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		dp[1] = p[1]; 
		System.out.println(recursion(n));
	}
	
	public static int recursion(int n) {
		int max = 0;
		if(n == 1) return p[1];
		if(dp[n] > 0) return dp[n];
		
		// 절반만 탐색하면 됨.
		for(int i=1; i<=n/2; i++) {
			int temp = recursion(n-i) + recursion(i);
			if(max > temp) {
				continue;
			}
			// 처음 이후부터는 temp가 더 크면 temp를 넣음
			if(i > 1)dp[n] = temp;
			// 처음엔 p[n]과 비교
			if(i == 1)dp[n] = Math.max(p[n], temp);
			// 여기까지 오면 이미 temp가 더 큰 상황임 
			max = dp[n]; 
		}
		return dp[n];
	}
}
