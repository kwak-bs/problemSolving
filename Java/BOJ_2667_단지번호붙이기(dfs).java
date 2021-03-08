package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2667 {
	// BOJ / 2667번 / 단지번호붙이기 / 그래프 / 실버1
	static int n,count,temp;
	static int map[][];
	static boolean visit[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	static StringBuffer sb;
	static ArrayList<Integer> al;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new boolean[n][n];
		sb = new StringBuffer();
		al = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visit[i][j] || map[i][j] == 0) continue;
				temp = 0;
				dfs(i,j);
				count++;
				al.add(temp);
			}
		}
		
		sb.append(count).append("\n");
		Collections.sort(al);
		for(int i=0; i<al.size(); i++) {
			sb.append(al.get(i)).append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int y, int x) {
		temp++;
		visit[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny >=0 && ny <n && nx >=0 && nx <n ) {
				if(!visit[ny][nx] && map[ny][nx] == 1) {
					dfs(ny,nx);					
				}
			}
		}
	}
}
