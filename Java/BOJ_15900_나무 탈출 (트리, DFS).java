package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15900 {
	// BOJ / 15900번 / 나무 탈출 / 트리 / 실1
	static int n, answer;
	static ArrayList<Integer> list[];
	static Queue<Integer> mal;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		list = (ArrayList<Integer> []) new ArrayList[n+1]; // 1 ~ n
		visit = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 양방향 인접리스트
		for(int i=1; i<n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		answer = 0;
		
		dfs(1, 0, visit);
		
		// 루트 노드에 모든 리프 노드 깊이 합이 홀수면 승 아니면 패이다. 
		if(answer % 2 == 1) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
	}
	
	public static void dfs(int node, int count, boolean[] visit) {
		visit[node] = true;
		
		for(int next : list[node]) {
			if(!visit[next]) {
				dfs(next, count+1, visit);
			}
		}
		
		if(node != 1 && list[node].size() == 1) {
			answer += count;
		}
		
		
	}
}
