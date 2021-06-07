package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15683 {
	// BOJ / 15683번 / 감시 / 구현, 시뮬레이션 / 골드5
	static int n,m;
	static int[][] map;
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dfs(0,-1);
		System.out.println(min);
	}
	public static void dfs(int idx, int cnt) {
		
		// 배열 끝에 도착하면 비교.
		if(idx == n*m) {
			min = Math.min(min, count());
			return;
		}
		int r = idx / m;
		int c = idx % m;
		// 0,1,2,3
		if(map[r][c] == 1) {
			for(int i=0; i<4; i++) {
				monitor(idx,i,0,cnt);
				dfs(idx+1, cnt-1);
				monitor(idx, i,cnt,0);
			}
		} 
		else if(map[r][c] == 2) { // 01, 23
			for(int i=0; i<4; i+=2) {
				monitor(idx, i, 0, cnt);
				monitor(idx, i+1, 0, cnt);
				dfs(idx+1, cnt-1);
				monitor(idx, i, cnt, 0);
				monitor(idx, i+1, cnt, 0);
			}
		}
		else if(map[r][c] == 3) { // 02, 03, 12,13
			for(int i=0; i<2; i++) {
				monitor(idx,i,0,cnt);
				for(int j=2; j<4; j++) {
					monitor(idx, j,0,cnt);
					dfs(idx+1, cnt-1);
					monitor(idx, j, cnt, 0);
				}
				monitor(idx,i,cnt,0);
			}
		}
		else if(map[r][c] == 4) { // 012, 013, 023,123
			for(int i=3; i>=0; i--) {
				for(int j=0; j<4; j++) {
					if(i == j) continue;
					monitor(idx,j,0,cnt);
				}
				dfs(idx+1,cnt-1);
				for(int j=0; j<4; j++) {
					if(i == j) continue;
					monitor(idx, j, cnt, 0);
				}
			}
		}
		else if(map[r][c] == 5) {
			for(int i=0; i<4; i++) {
				monitor(idx, i, 0, cnt);
			}
			dfs(idx+1, cnt-1);
			for(int i=0; i<4; i++) {
				monitor(idx,i,cnt,0);
			}
		}
		else dfs(idx+1, cnt-1);  // 1~5까지 수가 아닐 때 다음 수 호출
	}
	
	public static void monitor(int idx, int dir, int original, int change) {
		// 한 가지 방향만 채운다. 
		int r = idx / m;
		int c = idx % m;
		
		while(true) {
			r += dr[dir];
			c += dc[dir];
			if(r >= 0 && r <n && c>=0 && c<m) {
				if(map[r][c] == 6) break;
				if(map[r][c] == original) map[r][c] = change;
			}
			else break;
		}
	}
	
	public static int count() {
		int cnt = 0;
		
		for(int[] temp : map) {
			for(int v: temp) {
				if(v == 0) cnt++;
			}
		}
		return cnt;
	}
}
