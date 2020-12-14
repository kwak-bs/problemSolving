package problemSolve;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//BOJ / 1260번 /  DFS와 BFS / dfs, bfs, 그래프 / 실2
public class BOJ_1260 {
	static int n;
	static int m;
	static int v;
	static boolean visit[];
	static int map[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		sc.nextLine(); // 개행문자 삭제
		
		// visit, map 초기화
		visit = new boolean[n+1];
		map = new int[n+1][n+1];	
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				map[i][j] = 0;
			}
		}	
		Arrays.fill(visit, false);
		
		//간선 입력 및 그래프에 간선 이어주기 
		for(int i=0; i<m; i++) {
			String edge = sc.nextLine();
			String [] temp = edge.split(" ");
			int [] tmp = new int[temp.length];
			
			for(int j=0; j<tmp.length; j++) {
				tmp[j] = Integer.parseInt(temp[j]);
			}
			int a = tmp[0];
			int b = tmp[1];
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfs(v);
		Arrays.fill(visit, false);
		System.out.println();
		dfs(v);
		
	}
	// bfs, q사용
	public static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int j=1; j<n+1; j++) {
				if(map[temp][j] == 1 && visit[j] == false) {
					q.offer(j);
					visit[j] = true;
				}
			}
		}
	} 
	
	// dfs, 재귀
	public static void dfs(int i) {
		visit[i] = true;
		System.out.print(i + " ");
		
		for(int j=1; j<n+1; j++) {
			if(map[i][j] == 1 && visit[j] == false) {
				dfs(j);
			}
		}
	}
}
