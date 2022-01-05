package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
	// BOJ / 2447�� / �� ���-10 / ���� ���� / �ǹ�1
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
		
		// 5��° ĭ�� �����ŭ ������ ����Ѵ�.
		if(blank) {
			for(int i=r; i<r+n; i++) {
				for(int j=c; j<c+n; j++) {
					map[i][j]= ' ';
				}
			}
			return;
		}
		
		// �ּ� ������ ���̸� ���� ä���.
		if(n == 1) {
			map[r][c] = '*';
			return;
		}
		
		// �� ���� ������
		int size = n / 3;
		// ���� ���� ����
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
