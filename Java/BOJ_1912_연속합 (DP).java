package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912 {
	// BOJ / 1912번 / 연속합 / dp / 실2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		int num[] = new int[n];
		int dp[] = new int[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		dp[0] = num[0];
		int max = Integer.MIN_VALUE;
		
		if( dp[0] > max) {
			max = dp[0];
		}
		
		// 처음에 이중 루프로 풀었다가 시간초과남. 
		// 생각해보니 굳이 이중루프를 사용할 필요가 없는 문제였음. 시간제한이 1초면 이중루프 ㄴㄴ. 2초여도 안됨.
		for(int i=1; i<n; i++) {	
			dp[i] = Math.max(num[i], dp[i-1] + num[i]);	
			if(dp[i]> max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
}
