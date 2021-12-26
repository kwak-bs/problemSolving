package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1913 {
	// BOJ / 1913번 / 달팽이 / 구현 / 실버5
	
	static int[] dr = {1, 0, -1, 0}; // 하, 우, 상, 좌
	static int [] dc = {0, 1, 0, -1};
	static int map[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		int kr = 0;
		int kc = 0;
		makeMap(n);
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				sb.append(map[i][j]).append(" ");
				if(map[i][j] == k) {
					kr = i;
					kc = j;
				}
			}
			sb.append("\n");
		}
		sb.append(kr+1).append(" ").append(kc+1);
		System.out.println(sb);
	}
	
	// 거꾸로 삽입
	public static void makeMap(int n) {
		
		int r = 0;
		int c = 0;
		
		int count = n*n; 
		int d = 0;
		
		while(true) {
			if(count == 0) {
				break;
			}
			map[r][c] = count--;
			int nr = r + dr[d];
			int nc = c + dc[d];
			int nd = setDirection(d,n,nr,nc);
			if(nd != d) {
				r = r + dr[nd];
				c = c + dc[nd];
				d = nd;
			}
			else {
				r = nr;
				c = nc;
			}
		}
	}
	
	public static int setDirection(int d, int n, int nr, int nc) {
		
		// 범위를 벗어났거나
		if(nr >= n || nc >= n || nr < 0 || nc<0) {
			d = (d+1) % 4; 
		}
		// 이후 있을 자리가 이미 값이 있거나
		else if(map[nr][nc] != 0) {
			d = (d+1) %4;
		}
		
		return d;
	}
}
