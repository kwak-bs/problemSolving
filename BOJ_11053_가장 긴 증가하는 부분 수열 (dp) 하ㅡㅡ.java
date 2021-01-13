package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11053 {
	//BOJ / 11053번 / 가장 긴 증가하는 부분 수열 / dp / 실2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		int [] dp = new int[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		// 입력은 1 이상부터
		dp[0] = 1;
		int temp = num[0];
		int max = 0;
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				// 점화식 구하기 빡셌다. 주석으로 설명하기 힘듦 .
				// 나중에 다시 꼭 풀어볼것.
				// 대충 적어보자면 i인덱스의 숫자를 기준으로 그 전 인덱스들의 숫자 중에서 
				// 가장 큰 숫자의 dp + 1 하면 된다.
				if(num[i] > num[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
				
			}
		}
		
		for(int i=0; i<n; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		
		System.out.println(max);
	}
}
