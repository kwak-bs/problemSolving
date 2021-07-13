package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
	// BOJ / 2206번 / 벽 부수고 이동하기 / BFS / 골드4
	static int n,m, arr[][];
	static boolean v[][][];
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		arr = new int[n][m];
		v = new boolean[2][n][m]; // 부수기 전,후 방문여부 
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}
		
		System.out.println(bfs(0,0));
	}
	
	public static int bfs(int r, int c) {
		
		Queue<int[]> q = new LinkedList<>();
		
		v[0][r][c] = true;
		q.add(new int[] {r,c,1,0});
		
		while(!q.isEmpty()) {
			
			int[] now = q.poll();
			
			int rr = now[0];
			int cc = now[1];
			int count = now[2];
			int stone = now[3];
			
			if(rr == n-1 && cc == m-1) {
				return count;
			}
			for(int i=0; i<4; i++) {
				int nr = dr[i] + rr;
				int nc = dc[i] + cc;
				
				if(!(nr >=0 && nc>=0 && nr <n && nc <m)) continue;

				// 벽
				if(arr[nr][nc] == 1 ) {
					if(stone == 0 && !v[1][nr][nc]) {
						v[1][nr][nc]  = true;
						q.add(new int[] {nr,nc,count+1, stone+1});
					}
					
				}
				// 빈칸 
				// 현재 벽을 부순 횟수(stone)에 맞춰서 방문 배열 검사
				else {
					if(!v[stone][nr][nc]) {
						v[stone][nr][nc] = true;
						q.add(new int[] {nr,nc,count+1, stone});						
					}
				}
			}
		}
		
		return -1;
	}
}
