package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2580 {
	// BOJ / 2580번 / 스도쿠 / 백 트래킹 / 골드4
	static final int n = 9;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer stk;
		
		int a[][] = new int[n][n];
		boolean c[][][] = new boolean[3][n][10];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if(a[i][j] != 0) {
					c[0][i][a[i][j]] = true; // i번행에 a[i][j]값이 있다. 
					c[1][j][a[i][j]] = true; // j번열에 a[i][j]값이 있다. 
					c[2][square(i,j)][a[i][j]] = true; // square(i,j)번 사각형에 a[i][j]가 있다.
				}
			}
		}
		
		go(a,c,0);
	}
	
	public static int square(int i, int j) {
		return (i/3)*3 + (j/3); 
	}
	public static boolean go(int[][] a, boolean[][][]c, int z) {
		
		if(z == 81) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
			// 다 찾으면 true return
			return true;
		}
		
		int y = z / n;
		int x = z % n;
		if(a[y][x] != 0) {
			return go(a,c,z+1);
		}
		
		else {
			for(int i=1; i<=9; i++) {
				if(!c[0][y][i] && !c[1][x][i] && !c[2][square(y,x)][i]) {
					c[0][y][i] = c[1][x][i] = c[2][square(y,x)][i] = true;
					a[y][x] = i;
					if(go(a,c,z+1)) {
						// 찾았으면 true return
						return true;
					}
					// 못찾았으면 원래대로 
					a[y][x] = 0;
					c[0][y][i] = c[1][x][i] = c[2][square(y,x)][i] = false;
				}
			}
		}
		// 못찾음
		return false;
	}
}
