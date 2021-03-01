package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14002 {
	// BOJ / 14002번 / 가장 긴 증가하는 부분 수열4 / Dp / 골4
	
	static int rev[], num[];
	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		num = new int[n];
		int dp [] = new int[n];
		rev = new int [n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		dp[0] = 1;
		rev[0] = -1;
		for(int i=1; i<n; i++) {
			dp[i] = 1;
			rev[i] = -1; // 초기화 필수 if문에 안들어갈 수도 있으니
			for(int j=0; j<i; j++) {
				if(num[i] > num[j] && dp[j] >=dp[i]) {
					dp[i] = dp[j] +1;
					rev[i] = j;
				}
			}
		}
		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<n; i++) {
			if(max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		sb.append(max).append("\n");

		go(maxIdx);
		System.out.println(sb);
	}
	// maxIdx를 기준으로 역탐색
	public static void go(int idx) {

		if(idx == -1) {
			return;
		}
		
		go(rev[idx]);
		sb.append(num[idx]).append(" ");
	}
}
