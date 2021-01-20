package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2225 {
	//BOJ / 2225번 / 합분해 / DP / 골5
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		// dp[k][n] = n을 만들기 위해서 k개를 가지고 만들 수 있는 경우의 수 
		long dp[][] = new long[k+1][n+1];
		
		// k=1인 경우는 무조건 dp 값은 1이다.
		if(k > 0) {
			for(int i=0; i<=n; i++) {
				dp[1][i] = 1;
			}
		}
		// k=2인 경우는 무조건 dp 값은 n+1이다.
		if(k > 1) {
			for(int i=0; i<=n; i++) {
				dp[2][i] = i+1;
			}
		}
		
		// 점화식 
		// 한 숫자를 지정한 후 남은 갯수로 만들 수 있는 경우의 수 들을 더한다.
		for(int i=3; i<=k; i++) {
			for(int j=0; j<=n; j++) {
				for(int x=0; x<=j; x++)  {
					dp[i][j] += dp[i-1][x] % 1000000000;
				}
			}
		}
		System.out.println(dp[k][n]% 1000000000);
	}
}
