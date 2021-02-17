package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3085 {
	// BOJ / 3085번 / 사탕 게임  / 브르투 포스 / 실4
	
	static char board[][], copy[][];
	static int n;
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		board = new char[n][n];
		copy = new char[n][n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine());
			board[i] = stk.nextToken().toCharArray();
		}
		// copy 배열로 코드 진행
		copy();
		
		// 첫 배열 최장 길이 구하기
		int max = countLength();
		
		
		// 브루트포스로 각 배열 위치 바꿔주기 
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, swap(i,j));
			}
		}
		
		System.out.println(max);
	}
	
	public static int swap(int yy, int xx) {
		
		int mmax = 0;

		
		for(int i=0; i<4; i++) {
			int ny = yy + dy[i];
			int nx = xx + dx[i];
			
			//swap
			if(ny>=0 && ny <n && nx >= 0 && nx <n ) {
				char temp= copy[yy][xx];
				copy[yy][xx] = copy[ny][nx];
				copy[ny][nx] = temp;
				
				// 바뀐 배열 최장 길이 구하기
				mmax = Math.max(mmax, countLength());
				
				copy();
			}
			
		}
		
		return mmax;
	}
	
	public static int countLength() {
		
		int ylength = 1;
		int xlength = 1;
		int ymax = 1;
		int xmax = 1;
		int max = 0;
		
		for(int i=0; i<n; i++) {
			// x축 최장 길이 구하기
			for(int j=0; j<n; j++) {
				if(j == 0) {
					xlength = 1;
				}
				if(j > 0) {
					if(copy[i][j] == copy[i][j-1]) {
						xlength++;
					}
					else {
						xlength = 1;
					}
				}
				xmax = Math.max(xmax, xlength);
			}
			
			// y축 최장길이 구하기
			for(int k=0; k<n; k++) {
				if(k == 0) {
					ylength = 1;
				}
				if(k > 0) {
					if(copy[k][i] == copy[k-1][i]) {
						ylength++;
					}
					else {
						ylength = 1;
					}
				}	
				ymax = Math.max(ymax, ylength);
			}

			max = Math.max(ymax, xmax);
		}
		return max;
	}
	
	public static void copy() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				copy[i][j] = board[i][j];
			}
		}
	}
}
