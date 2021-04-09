package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {
	// BOJ / 11050번 / 이항 계수 1 / 수학, 조합 / 브론즈 1
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
 
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][k+1];
		// 파스칼의 법칙을 사용한다. 
		// n = (n-1) + (n-1) 
		// k = (k-1) + (k)
		System.out.println(BC(n,k));
	}
	
	public static int BC(int n, int k) {
		// 기존에 사용한 값이면 계산하기 말고 그대로 사용
		if(dp[n][k] > 0) {
			return dp[n][k];
		}
		// 0이거나 두 값이 같으면 무조건 1 
		if(k == 0 || n == k) {
			return dp[n][k] = 1;
		}
		// 파스칼의 법칙 
		return dp[n][k] = BC(n-1,k-1) + BC(n-1, k);
	}
}
