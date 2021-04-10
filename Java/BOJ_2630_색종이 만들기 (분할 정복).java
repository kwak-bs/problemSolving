package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
	// BOJ / 2630번 / 색종이 만들기 / 분할 정복 / 실버1
	static int n, map[][], white, blue;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		go(n,0,0);
		System.out.println(white);
		System.out.println(blue);
	}
	public static void go(int num, int r, int c) {
		int color = map[r][c];
		boolean flag = true;
		
		loop : 
		for(int i=r; i<num+r; i++) {
			for(int j=c; j<num+c; j++) {
				if(color != map[i][j]) {
					flag = false;
					break loop;
				}
			}
		}
		
		if(flag) {
			if(color == 1) {
				blue++;
			}
			else white++;
			return;
		}
		
		go(num/2 , r,c);
		go(num/2 , r,c+num/2);
		go(num/2 , r+num/2,c);
		go(num/2 , r+num/2,c+num/2);
	}
}
