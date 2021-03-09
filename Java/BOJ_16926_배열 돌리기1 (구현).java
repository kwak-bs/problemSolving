package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	// BOJ / 16926번 / 배열 돌리기 1 / 구현 / 실버3
	static int y,x,r;
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		int map [][] = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		while(r-- > 0) {
			map = rotation(map);
		}
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static int[][] rotation(int map[][]) {
		
		// 회전 그룹 갯수
		int rotGroup = Math.min(y, x) / 2;
		for(int i=0; i<rotGroup; i++) {
			
			int yy = i;
			int xx = i;
			
			// 훗날 넣어주기 위한 값.
			int later = map[yy][xx];
			
			//방향 (우 상 좌 하)
			int d = 0;
			
			while(d < 4) {
				int ny = yy + dy[d];
				int nx = xx + dx[d];
				
				if(ny >= i && nx >= i && ny < y-i && nx < x-i) {
					map[yy][xx] = map[ny][nx];
					yy = ny;
					xx = nx;
				}
				else {
					d++;
				}
			}
			map[i+1][i] = later;
		}
		return map;
	}
}
