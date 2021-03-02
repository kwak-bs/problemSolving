package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932 {
	// BOJ / 1932번 / 정수 삼각형 / dp / 실버1
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int tri [][] = new int[n][n];
		int dp [][] = new int[n][n];
		StringTokenizer stk;
		// 입력
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<=i; j++) {
				tri[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 초기화
		dp[0][0] = tri[0][0];
		
		// dp 점화식 
		for(int i=1; i<n; i++) {
			dp[i][0] = dp[i-1][0] + tri[i][0];
			for(int j=1; j<=i; j++) {
				dp[i][j] = Math.max(dp[i-1][j]+tri[i][j], 
						dp[i-1][j-1]+tri[i][j]);
				
				if(j == i) {
					dp[i][j] = dp[i-1][j-1] + tri[i][j];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		// 마지막 행에서 최댓값 추출
		for(int i=0; i<n; i++) {
			if(dp[n-1][i] > max) {
				max = dp[n-1][i];
			}
		}
		System.out.println(max);
	}
}
