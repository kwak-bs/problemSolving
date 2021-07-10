package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
	// BOJ / 9251번 / LCS / DP / 골드5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char a[] = br.readLine().toCharArray();
		char b[] = br.readLine().toCharArray();
		
		int dp[][] = new int[a.length+1][b.length+1];
		
		
		for(int i=1; i<=a.length; i++) {
			for(int j=1; j<=b.length; j++) {
				// 현재 문자(i)가 같으면 직전 문자열[i-1][j-1]의 LCS + 1
				// 왜? 만약 i가 A이고, 직전 문자가 {A,C} , {C}이면 
				// {A,C} + A , {C} + A 한 것이기 때문.
				if(a[i-1] == b[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				// 다르면 
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println(dp[a.length][b.length]);
	}
}
