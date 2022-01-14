package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1058 {
	// BOJ / 1058번 / 친구 / 그래프, 플로이드와샬 / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int g[][] = new int[n][n];
		
		for(int i=0; i<g.length; i++) {
			String input = br.readLine();
			for(int j=0; j<input.length(); j++) {
				if(i != j) g[i][j] =  987654321;
				else g[i][j] = 0;
				if(input.charAt(j) == 'Y') {
					g[i][j] = 1;
				}
			}
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				if(i == k) continue;
				for(int j=0; j<n; j++) {
					if(i == j || k == j) continue;
					if(g[i][j] > g[i][k] + g[k][j]) {
						g[i][j] = g[i][k] + g[k][j];
					}
				}
			}
		}
		int max = 0;
		for(int i=0; i<n; i++) {
			int count = 0;
			for(int j=0; j<n; j++) {
				if(g[i][j] <= 2 && g[i][j] > 0) {
					count++;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
