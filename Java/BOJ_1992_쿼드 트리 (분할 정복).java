package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992 {
	// BOJ / 1992번 / 쿼드트리 / 분할 정복 / 실버1
	static StringBuilder sb = new StringBuilder();
	static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
	
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		go(0,0,n);
		System.out.println(sb);
	}
	
	public static void go(int r, int c, int size) {
		
		if(check(r, c, size)) {
			if(map[r][c] == 0) {
				sb.append(map[r][c]);
			}
			else {
				sb.append(map[r][c]);
			}
			
			return;
		}
		int newSize = size / 2;
		// 상단 좌측, 우측
		// 시작할때 괄호 열어준다
		sb.append("(");
		go(r, c , newSize);
		go(r, c+newSize, newSize);

		// 하단 좌측, 우측
		go(r+newSize, c, newSize);
		go(r+newSize, c+newSize, newSize);
		// 끝날때 괄호 닫아줌
		sb.append(")");
	}
	
	public static boolean check(int r, int c, int size) {
		
		int color = map[r][c];
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != color) return false;
			}
		}
		return true;
	}
}
