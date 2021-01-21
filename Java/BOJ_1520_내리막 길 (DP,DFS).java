package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {
	//BOJ / 1520번 / 내리막 길 / DP / 골4
	static int [] dy = {1,-1,0,0}; // 상하
	static int [] dx = {0,0,1,-1}; // 좌우
	static int y,x;
	static int [][] map, dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		map = new int[y][x];
		dp = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				dp[i][j] = -1; // 방문 처리를 위해 -1로함
			}
		}
		


		System.out.println(dfs(0,0));
//		for(int i=0; i<y; i++) {
//			for(int j=0; j<x; j++) {
//				System.out.print(dp[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	
	public static int dfs(int yy, int xx ) {
		
		// 도착지점에 도달했으면 1을 리턴.
		if(yy == y-1 && xx == x-1) {
			return 1;
		}
		
		// 이미 방문한 곳이라면 방문한 곳의 값을 리턴.
		if(dp[yy][xx] != -1) {
			return dp[yy][xx];
		}
		
		// 방문처리
		dp[yy][xx] = 0;
		
		for(int i=0; i<4; i++) {
			int ny = yy + dy[i];
			int nx = xx + dx[i];
			
			if(ny>=0 && ny <y && nx >=0 && nx <x ) {
				// 다음 지점의 높이가 낮으면 걍 다 넣어주고 반환값을 더해준다. 
				if(map[yy][xx] > map[ny][nx] ) {
					dp[yy][xx] += dfs(ny,nx);
				}
			}
		}
		// 백트래킹 된 곳들을 다시 더해주기 위함.
		return dp[yy][xx];
	}
}
