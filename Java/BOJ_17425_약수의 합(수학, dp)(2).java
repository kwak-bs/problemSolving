package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17425 {
	// BOJ / 17425번 / 약수의 합 / 수학  / 골드5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		long f[] = new long[1000001];
		Arrays.fill(f, 1);
		long dp[] = new long[1000001];
		for(int i=2; i<f.length; i++) {
			for(int j=1; j*i<f.length; j++) {
				f[j*i] += i;
			}
		}

		dp[1] = f[1];
		for(int i=2; i<dp.length; i++) {
			dp[i] = dp[i-1] +f[i];
		}
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}
}
