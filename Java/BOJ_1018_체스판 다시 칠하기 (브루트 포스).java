package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018 {
	// BOJ / 1018번 / 체스판 다시 칠하기 / 브루트 포스 / 실버5
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		char board[][] = new char[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;

		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(i+7 <n && j + 7 <m) {
					
					// 0,0 기준 
					min = Math.min(min, go(board, i, j));
				}
			}
		}
		
		System.out.println(min);
	}
	
	public static int go(char[][] board, int y, int x) {
		
		char temp[][] = new char[8][8];
		int cnt = 0; 
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				temp[i][j] = board[i+y][j+x]; 
			}
		}	
		// 첫 열 
		for(int i=0; i<7; i++) {	
			
			if(temp[i][0] != temp[i+1][0]) {
				continue;
			}
			
			if(temp[i][0] == 'B') temp[i+1][0] = 'W';
			else temp[i+1][0] = 'B';
			cnt++;
		}
		
		// 첫 행 
		for(int i=0; i<7; i++) {	
			if(temp[0][i] != temp[0][i+1]) {
				continue;
			}
			
			if(temp[0][i] == 'B') temp[0][i+1] = 'W';
			else temp[0][i+1] = 'B';
			cnt++;
		}
		
		for(int i=1; i<8; i++) {
			for(int j=1; j<8; j++) {
				
				if(temp[i][j] != temp[i][j-1]) {
					continue;
				}
				if(temp[i][j-1] == 'B') temp[i][j] = 'W';
				else temp[i][j] = 'B';
				cnt++;
			}
		}
		// 위의 코드는 첫번째 칸의 색을 기준으로 구한 숫자. 
		// 밑의 최소값은 첫번째 칸의 반대되는 색을 기준으로 구한 숫자와 비교후 return 해준다.
		cnt = Math.min(cnt,64-cnt);
		return cnt;
	}
}
