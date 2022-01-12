package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
	// BOJ / 1010번 / 다리 놓기 / 구현 / 실버5
	static int dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		
		dp = new int[30][30];
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(stk.nextToken()); // 강 서쪽 사이트
			int m = Integer.parseInt(stk.nextToken()); // 강 동쪽 사이트
			
			int answer = combination(m,n);
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	// nCr
	public static int combination(int n, int r) {
		
		// 이미 탐색했으면 바로 반환.
		if(dp[n][r] != 0) return dp[n][r];
		
		if( r == n || r==0) return dp[n][r] = 1;
		
		return dp[n][r] = (combination(n-1, r-1) + combination(n-1, r));
	}
}
