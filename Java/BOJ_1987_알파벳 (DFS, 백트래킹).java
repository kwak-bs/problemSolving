package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
	// BOJ / 1987¹ø / ¾ËÆÄºª / DFS, ¹éÆ®·¡Å· / °ñµå4
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	static int r,c, answer;
	static char map[][];
	static boolean v[][], alp[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		map = new char[r][c];
		v = new boolean[r][c];
		alp = new boolean[26];
		
		for(int i=0; i<r; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}
		alp[map[0][0]-65] = true;
		dfs(0,0,1);
		
		System.out.println(answer);
	}
	
	public static void dfs(int y, int x, int count) {
		
		answer = Math.max(answer, count);
		
		for(int i=0; i<4; i++) {
			int nr = y + dr[i];
			int nc = x + dc[i];
			if(nr >=0 && nr < r && nc >=0 && nc < c) {
				if(!alp[map[nr][nc]-65]) {
					alp[map[nr][nc]-65] = true;
					dfs(nr,nc, count+1);
					alp[map[nr][nc]-65] = false;
				}
			}
		}
	}
}
