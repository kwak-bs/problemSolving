package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {
	// BOJ / 11055번 / 가장 큰 증가 부분 수열 / dp / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int num[] = new int[n];
		int dp[] = new int[n];

		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		dp[0] = num[0];
		for(int i=1; i<n; i++) {
			dp[i] = num[i];
			for(int j=0; j<i; j++) {
				if(num[i] > num[j]) {
					dp[i] = Math.max(dp[j]+num[i], dp[i]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
}
