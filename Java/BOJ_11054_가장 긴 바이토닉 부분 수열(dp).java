package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11054 {
	// BOJ / 11054번 / 가장 긴 바이토닉 부분 수열 / dp / 골드3
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int num[] = new int[n];
		int dp[][] = new int[n][2];

		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		//LIS (최장 증가 수열)
		for(int i=0; i<n; i++) {
			dp[i][0] = 1;
			
			for(int j=0; j<i; j++) {
				
				if(num[i] > num[j]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0]+1);
				}
			}
		}
		
		//LDS (최장 감소 수열)
		for(int i=n-1; i>=0; i--) {
			dp[i][1] = 1;
			
			for(int j=n-1; j>i; j--) {
				if(num[i] > num[j]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
				}
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if(max < dp[i][0] + dp[i][1]) {
				max = dp[i][0] + dp[i][1];
			}
		}
		
		System.out.println(max-1);
	}

}
