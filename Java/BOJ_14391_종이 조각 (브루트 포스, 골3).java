package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14391 {
	// BOJ / 14391번 / 종이 조각 / 브루트포스 / 골드3
	
	static int y,x,ans;
	static int board[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk= new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		board = new int[y][x];
		visit = new boolean[y][x];
		
		for(int i=0; i<y; i++) {
			String s = br.readLine();
			for(int j=0; j<x; j++) {
				board[i][j] = s.charAt(j) - '0';
			}
		}
		
		recursion(0,0);
		
		System.out.println(ans);
	}
	
	public static void recursion(int yy, int xx) {
		
		//검사를 다 했으면 check
		if(yy >= y) {
			check();
			return;
		}
		// 한 열을 다 검사했으면, 다음 행으로
 		if(xx >= x) {
			recursion(yy+1, 0);
			return;
		}
		
		//해당 좌표 선택
		visit[yy][xx] = true;
		recursion(yy, xx+1);
		//해당 좌표 미선택
		visit[yy][xx] = false;
		recursion(yy,xx+1);
	}
	
	// true = 가로, false = 세로
	public static void check() {
		
		int sum = 0;
		// 가로 
		for(int i=0; i<y; i++) {
			int temp = 0;
			for(int j=0; j<x; j++) {
				if(visit[i][j]) {
					temp *= 10; // 연속될 경우 자릿수 곱해줌
					temp += board[i][j];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			// 한 행이 가로가 될 경우 결과값 저장
			sum += temp;
		}
		
		//세로 
		for(int i=0; i<x; i++) {
			int temp = 0;
			for(int j=0; j<y; j++) {
				if(!visit[j][i]) {
					temp *= 10;
					temp += board[j][i];
				}
				else {
					sum += temp;
					temp = 0;
				}
			}
			// 한 열이 세로가 될 경우 결과값 저장.
			sum+= temp;
		}
		
		ans = Math.max(sum, ans);
	}
}
