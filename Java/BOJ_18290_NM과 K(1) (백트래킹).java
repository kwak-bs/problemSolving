package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
	// BOJ / 15649번 / NM과 K (1) / 백트래킹 / 실1
	
	static int n,m,k,max;
	static int list [][];
	static int visit[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		
		list = new int [n][m];
		visit = new int[n][m];
		max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				list[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		dfs(0, 0);
		
		System.out.println(max);
	}
	
	public static void dfs(int depth, int plus) {
		
		if(depth == k) {
			max = Math.max(plus, max);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visit[i][j] == 0) {
					check(i,j);
					dfs(depth + 1, plus + list[i][j]);
					back(i,j);		
				}
			}
		}
	}
	
	public static void check (int y, int x) {
		visit[y][x]++;
		
	      if (y-1 >= 0) {
	          //위가 존재할때
	          visit[y-1][x]++;
	       }
	       if (x-1 >= 0) {
	          //왼쪽이 존재할때
	          visit[y][x-1]++;
	       }
	       if (y+1 < n) {
	          //아래가 존재할때
	          visit[y+1][x]++;
	       }
	       if (x+1 < m) {
	          //오른쪽이 존재할때
	          visit[y][x+1]++;
	       }
	}
	public static void back (int y, int x) {
		visit[y][x]--;
		
	      if (y-1 >= 0) {
	          visit[y-1][x]--;
	       }
	       if (x-1 >= 0) {
	          visit[y][x-1]--;
	       }
	       if (y+1 < n) {
	          visit[y+1][x]--;
	       }
	       if (x+1 < m) {
	          visit[y][x+1]--;
	       }
	}
}
