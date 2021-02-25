package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	
	// BOJ / 9095번 / 1, 2, 3 더하기 / DP / 실3
	
	static int dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		dp = new int[11];
		dp[10]=recursion(10);
		dp[1] = 1; 	dp[2] = 2; dp[0] = 1;
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
	
	public static int recursion(int n) {
		
		if(n == 1 || n == 0) return 1;
		if(n == 2) return 2;
		if(dp[n] > 0) return dp[n];
		
		dp[n] = recursion(n-3) + recursion(n-2) + recursion(n-1);
		
		
		return dp[n];
	}
}
