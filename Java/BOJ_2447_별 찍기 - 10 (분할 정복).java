package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
	// BOJ / 2447번 / 별 찍기-10 / 분할 정복 / 실버1
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		makeStar(0,0,n,false);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void makeStar(int r, int c, int n, boolean blank) {
		
		// 5번째 칸은 사이즈만큼 공백을 출력한다.
		if(blank) {
			for(int i=r; i<r+n; i++) {
				for(int j=c; j<c+n; j++) {
					map[i][j]= ' ';
				}
			}
			return;
		}
		
		// 최소 단위의 블럭이면 별을 채운다.
		if(n == 1) {
			map[r][c] = '*';
			return;
		}
		
		// 한 블럭의 사이즈
		int size = n / 3;
		// 별의 누적 갯수
		int star = 0;
		
		for(int i=r; i<r+n; i+=size) {
			for(int j=c; j<c+n; j+=size) {
				star++;
				if(star == 5) {
					makeStar(i,j,size, true);
				}else {
					makeStar(i,j,size,false);
				}
			}
		}
	}
}
