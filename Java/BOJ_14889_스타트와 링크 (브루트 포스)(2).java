package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {
	// BOJ / 14889번 / 스타트와 링크 / 브루트 포스 / 실버3
	static int n, min;
	static int map[][];
	static boolean v[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		map = new int[n][n];
		v = new boolean[n];

		StringTokenizer stk;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		go(0,0);
		System.out.println(min);
	}
	
	public static void go(int depth, int start) {
		
		if(depth == n/2) {
			min = Math.min(min, cal());
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!v[i]) {
				v[i] = true;
				go(depth+1, i+1);
				v[i] = false;
			}
		}
	}
	
	public static int cal() {
		
		int start = 0;
		int link = 0;
		
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				// 방문한 팀은 start
				if(v[i] && v[j]) {
					start += map[i][j] +map[j][i];
				}
				// 방문 안한 팀은 link
				else if(!v[i] && !v[j]) {
					link += map[i][j] + map[j][i];
				}
			}
		}
		return Math.abs(start - link);
	}
}
