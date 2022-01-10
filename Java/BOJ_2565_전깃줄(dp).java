package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {
	// BOJ / 2565¹ø / Àü±êÁÙ / DP / °ñµå 5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		int [][] wire = new int[n][2];
		int[] dp = new int[n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			wire[i][0] = a;
			wire[i][1] = b;
		}
		Arrays.sort(wire, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		// LIS
		for(int i=0; i<dp.length; i++) {
			dp[i] = 1;
			for(int j =0; j<i; j++) {
				if(wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j]+1); 
				}
			}
		}
		int max = 0;
		for(int i=0; i<dp.length; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(n - max);
	}
}
