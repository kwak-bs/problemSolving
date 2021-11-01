package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
	// BOJ / 14620번 / 꽃길 / 완전탐색 / 실버2
	static int map[][],n;
	static boolean v[][];
	static int answer = Integer.MAX_VALUE;
	static int dr[] = {1,-1,0,0,0};
	static int dc[] = {0,0,-1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		StringTokenizer stk;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 1. 각 좌표마다 꽃을 만들수 있는지 판단.
		// 2. 꽃을 만들수 있으면 방문 체크 및 값 구함
		// 3. dfs 탐색 
		// 4. 탐색 후에는 롤백
		go(1, 1, 0, 0);
		System.out.println(answer);
	}
	
	public static void go(int r, int c, int count, int sum) {
		if(count == 3) {
			answer = Math.min(answer, sum);
			return;
		}
		// i는 r부터 시작하는게 최적화에 좋다.
		// r c로 시작하니까 틀림
		for(int i=r; i<n-1; i++) {
			for(int j=1; j<n-1; j++) {
				if( !v[i][j] && makeFlower(i,j)) {
					int s = checkFlower(i,j);
					go(i,j,count+1, sum+s);
					rollbackFlower(i,j);
				}
			}
		}
	}
	// 백트래킹
	public static void rollbackFlower(int r, int c) {
		for(int i=0; i<5; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = false;
		}
	}

	// 꽃을 만든 곳은 체크 
	public static int checkFlower(int r, int c) {
		int sum = 0;
		for(int i=0; i<5; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = true;
			sum += map[nr][nc];
		}
		return sum;
	}
	// 꽃을 만들수있는지 판단.
	public static boolean makeFlower(int r, int c) {
		for(int i=0; i<5; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			if(v[nr][nc]) return false;
		}
		return true;
	}
}
