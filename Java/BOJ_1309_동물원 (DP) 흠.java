package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1309 {
	//BOJ / 1309번 / 동물원 / dp / 실1
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int map[][] = new int[n][2];
		int dp[] = new int[n+1];
		dp[0] = 1;
	
		if(n >= 1) {
			dp[1] = 3;
		}
		// 1) X X => dp[n-1]
		// 2) X 0 | ? ?, 0 X | ? ? -> 2*dp[n-1] 
		// 3) X 0 | X 0, 0 X | 0 X -> dp[n-1] - dp[n-2]
		// 즉, 1) + 2) - 3) => 2*DP[n-1] + DP[n-2] 
		// 3)은 위의 두 칸을 하나로 합친 뒤 배열하되, 첫 줄에 하나는 있게 하는 배열의 가짓수이기 때문에
		// 전체 DP[n-1]에서 하나를 제외한 DP[n-2]를 빼준다.
		for(int i=2; i<=n; i++) {
			dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
		}
		System.out.println(dp[n]);
	}
}
