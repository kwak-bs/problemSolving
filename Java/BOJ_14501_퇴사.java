package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501 {
	//BOJ / 14501번 / 퇴사 / 브루트 포스, dp / 실4
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t [] = new int[n+10]; //소요 일수
		int p [] = new int[n+10]; //수당 
		int dp [] = new int[n+10]; // i일 부터 받을 수 있는 최대 금액.

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=n-1; i>=0; i--) {
			int day = i + t[i]; // i번째 날에 상담 시작후 끝나는 날짜  
			
			if(day <= n) { // 일이 끝나는 날까지는 상담가능
				dp[i] = Math.max(p[i]+dp[day], dp[i+1]);
			}
			
			else { // 상담일 초과
				dp[i] = dp[i+1];
			}
		}
			System.out.println(dp[0]);
	}
}
