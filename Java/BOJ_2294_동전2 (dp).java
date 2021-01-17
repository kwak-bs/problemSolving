package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294 {
	// BOJ / 2294번 / 동전 2 / DP / 실1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int money[] = new int[n];
		int dp[] = new int[k+1];
		// 동전의 최대 합은 10001임.
		Arrays.fill(dp, 10001);
		
		// 입력 
		for(int i=0; i<n; i++) {
			money[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = 0;
		
		// 각 동전의 가치별로 dp를 구한다. 현재 최소 갯수는 그 전 동전 기준의 갯수와 
		// 현재 동전 기준의 갯수를 비교하면 된다. 
		for(int i=0; i<money.length; i++) {
			for(int j=money[i]; j<dp.length; j++) {
				dp[j] = Math.min(dp[j], dp[j-money[i]] + 1);
			}
		}
		
		System.out.println(dp[k] == 10001 ? -1 : dp[k]);
	} 
}
