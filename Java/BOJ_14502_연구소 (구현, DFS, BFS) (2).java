package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	// BOJ / 14502번 / 연구소 / 구현, dfs, bfs / 골드5
	static int map[][], temp[][], n,m;
	static int answer=Integer.MIN_VALUE;
	static int dr [] = {1,-1,0,0};
	static int dc [] = {0,0,1,-1};
	static Queue<int[]> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		q = new LinkedList<>();
		map= new int[n][m];
		temp =new int[n][m];

		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		dfs(0);
		System.out.println(answer);
	}
	public static void dfs(int depth) {
		
		if(depth == 3) {
			copy();
			spreadVirus();
			answer =Math.max(answer,checkSafeZone());
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static int checkSafeZone() {
		
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(temp[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void spreadVirus() {

		while(!q.isEmpty()) {
			int now[] = q.poll();
			int r = now[0];
			int c = now[1];
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr >= 0 && nc >=0 && nr <n && nc < m) {
					if(temp[nr][nc] == 0) {
						temp[nr][nc] = 2;
						q.add(new int[] {nr,nc});
					}
				}
			}
		}
	}
	
	public static void copy() {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				temp[i][j] = map[i][j];
				if(map[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
	}
}
