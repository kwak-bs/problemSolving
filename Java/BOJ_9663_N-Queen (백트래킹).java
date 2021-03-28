package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {
	// BOJ / 9663번 / N-Queen / 백 트래킹 / 골드5
	static int n, ans=0;
	static boolean[][] a = new boolean[15][15];
	static boolean[] check_col = new boolean[15];
	static boolean[] check_dig = new boolean[31];
	static boolean[] check_dig2 = new boolean[31];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		n = Integer.parseInt(br.readLine());
		
		go(0);
		System.out.println(ans);
	}
	
	public static void go(int row) {
		
		if(row == n) {
			ans++;
		}
		
		for(int col=0; col<n; col++) {
			if(check(row, col)) {
				check_dig[row +col] = true;
				check_dig2[row-col+n] = true;
				check_col[col] = true;
				a[row][col] = true;
				go(row+1);
				check_dig[row +col] = false;
				check_dig2[row-col+n] = false;
				check_col[col] = false;
				a[row][col] = false;
				
			}
			a[row][col] = false;
		}
	}
	
	public static boolean check(int r, int c) {
		
		// |
		if(check_col[c]) return false;
		
		// /
		if(check_dig[r+c]) return false;
		
		// \
		if(check_dig2[r-c+n]) return false;
		return true;
	}
}
