package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14500 {
	// BOJ / 14500번 / 테트로미노  / 브르투 포스 / 골5
	static int n,m, result;
	static int board[][];
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,1,-1};
	static boolean visit[][];
	
	// ㅗ, ㅏ, ㅜ, ㅓ 순  
	static int fy[][] = {{0,0,0,-1},{0,1,2,1},{0,0,0,1},{0,1,2,1}};
	static int fx[][] = {{0,1,2,1},{0,0,0,1},{0,1,2,1},{0,0,0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		board = new int[n][m];
		visit = new boolean[n][m];
		result = 0;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				visit[i][j] = true;
				// 4가지 모양 검사
				dfs(i,j,board[i][j], 1);
				
				visit[i][j] = false;
				
				//ㅗ 검사, 되돌아 갈일이 없어서 visit ㄴㄴ 
				fu(i,j);
			}
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int yy , int xx, int sum, int length) {
		
		if(length == 4 ) {
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = yy + dy[i];
			int nx = xx + dx[i];
			
			if(ny >=0 && ny < n && nx >= 0 & nx < m) {
				if(!visit[ny][nx]) {
					visit[ny][nx] = true;
					dfs(ny,nx,sum + board[ny][nx], length + 1);
					visit[ny][nx] = false;
				}
			}
		}
	}
	
	public static void fu(int yy, int xx) {
		// ㅗ, ㅏ, ㅜ, ㅓ 순  
		
		for(int i=0; i<4; i++) {
			int sum = 0;
			boolean out = false;
			
			for(int j=0; j<4; j++) {
				int ny = yy + fy[i][j];
				int nx = xx + fx[i][j];
				
				if(!(ny>=0 && ny <n && nx >=0 && nx <m)) {
					out = true;
					break;
				}

				sum += board[ny][nx];					
			}
			if(!out) {
				result = Math.max(result, sum);
			}
		}
	}
}
