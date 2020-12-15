package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724 {
	//BOJ / 11724번 /  연결 요소의 개수 / dfs, bfs, 그래프 / 실2
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[1001];
		map = new int[1001][1001];
		int cnt = 0;
		
		for(int i =0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			makeGraph(u,v);
		}
		
		//dfs 탐색
		for(int i=1; i<=N; i++) {
			if(visit[i] == false) {
				dfs(i);
				cnt++;				
			}
		}
		System.out.println(cnt);
	}
	
	public static void makeGraph(int u, int v) {
		map[u][v] = map [v][u] = 1;
	}
	
	public static void dfs(int i) {
		if(visit[i] == true) {
			return;
		}
		else { // visit[i] = false
			visit[i] = true;
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1 ) {
					dfs(j);
				}
			}	
		}
	}
}
