package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int dp[] = new int[k+1];
		int arr[] = new int[n+1];
		dp[0] = 1;
		// 동전 별 가짓수를 저장한다. 
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			for(int j=arr[i]; j<=k; j++) {
				dp[j] += dp[j - arr[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
