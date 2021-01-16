package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294 {
	// BOJ / 2294번 / 동전 1 / DP / 실1
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int coin[] = new int[n];
		int dp[] = new int[k+1];
		dp[0] = 1;
		
		
 		// 주어진 각 동전의 가짓수를 각각 구한 다음 더하는 식으로 점화식을 구한다. 
 		for(int i=0; i<coin.length; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for(int j=coin[i]; j<=k; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
 		
		System.out.println(dp[k]);
		
	}
}
