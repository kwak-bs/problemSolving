package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971 {
	// BOJ / 10971번 / 외판원 순회 2 / 브루트포스 / 실2
	
	static int board[][];
	static boolean visit[];
	static int n, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		board = new int[n][n];
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		// 각 점에 대하여 완전 탐색.
		for(int i=0; i<n; i++) {
			recursion(i,i, 0,0 );
		}
		
		System.out.println(min);
	}
	
	public static void recursion(int start, int x, int depth,int sum) {
		
		// 합이 최솟값을 넘는 경우 백트래킹
		if(sum > min) {
			return;
		}
		// 모든 점을 다 돌고 첫 점에 도착했을 경우
		if(depth == n && x == start) {
			if(min > sum) {
				min = sum;
			}
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(board[x][i] == 0) continue;
			if(visit[i])  continue;
			
			visit[i] = true;
			recursion(start, i, depth+1, sum + board[x][i]);
			visit[i] = false;
		}
	}
}
