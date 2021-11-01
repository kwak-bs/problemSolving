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
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
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
		// 1.각 좌표마다 꽃을 만들수 있는지 판단.
		// 2. 꽃을 만들수 있으면 방문 체크 
		// 3. dfs 탐색 
		// 4. 탐색 후에는 롤백
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(makeFlower(i,j) && !v[i][j]) {
					checkFlower(i, j);
					go(i,j,1);
					rollbackFlower(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void go(int r, int c, int count) {
		if(count == 3) {
			int currentWeight = getWeight();
			answer = Math.min(answer, currentWeight);
			return;
		}
		// i랑 j도 0 부터 시작해야함 
		// r c로 시작하니까 틀림
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(makeFlower(i,j) && !v[i][j]) {
					checkFlower(i,j);
					go(i,j,count+1);
					rollbackFlower(i,j);
				}
			}
		}
	}
	// 백트래킹
	public static void rollbackFlower(int r, int c) {
		v[r][c] = false;
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = false;
		}
	}
	// 비용 구하기 
	public static int getWeight() {
		int weight = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(v[i][j]) {
					weight += map[i][j];
				}
			}
		}
		
		return weight;
	}
	// 꽃을 만든 곳은 체크 
	public static void checkFlower(int r, int c) {
		v[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = true;
		}
	}
	// 꽃을 만들수있는지 판단.
	public static boolean makeFlower(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
				return false;
			}	
			else if(v[nr][nc]) return false;
		}
		return true;
	}
}
