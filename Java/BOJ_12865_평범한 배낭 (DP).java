package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
	// BOJ / 12865번 / 평범한 배낭 / dp / 골드5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int dp[][] = new int[n+1][k+1];
		int w[] = new int[n+1];
		int v[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			w[i] = Integer.parseInt(stk.nextToken());
			v[i] = Integer.parseInt(stk.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				// 기본적으로 전 아이템 가치를 저장한다. 
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					// 자신의 가치와  
					// 현재 무게에서 자신의 무게를 뺏을 때 남는 무게의 가치 + 자신의 가치 중 비교한다.
					dp[i][j] = Math.max(dp[i][j], v[i] + dp[i-1][j-w[i]]);
				}
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
