package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17425 {
	// BOJ / 17425번 / 약수의 합  / 수학 / 골5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int t = Integer.parseInt(br.readLine());
		
		long arr [] = new long[1000001];
		long dp [] = new long[1000001];
		
		// 모든 수들은 기본적으로 1을 약수로 갖는다.
		Arrays.fill(arr, 1);
		
		// 백만 이하의 수들의 각자의 약수의 합 저장.
		for(int i=2; i<=1000000; i++) {
			for(int j=1; i*j <= 1000000; j++ ) {
				arr[i*j] += i;
			}
		}
		
		// g(x) 저장
		for(int i=1; i<=1000000; i++) {
			dp[i] = dp[i-1] + arr[i];
		}
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			
			
			sb.append(arr[n]).append("\n");
		}
		System.out.println(sb);
	}
}
