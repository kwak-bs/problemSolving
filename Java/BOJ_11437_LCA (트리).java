package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11437 {
	// BOJ / 11437번 / LCA / 트리 / 골드3
	static int n, m, answer;
	static ArrayList<Integer>[] list, tree ; 
	static int parent[], depth[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine()); // 노드 개수
		parent = new int [n+1];
		depth = new int [n+1];
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
			
		for (int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=1; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			// 양방향 그래프
			list[a].add(b);
			list[b].add(a);
		}
		
		makeTree(1, -1, 1);
		

		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int n1 = Integer.parseInt(stk.nextToken());
			int n2 = Integer.parseInt(stk.nextToken());
			
			findSameParent(n1, n2);
			
			System.out.println(findSameParent(n1,n2));
		}
	}
	
	// 양방향 그래프를 바탕으로 트리 구성
	public static void makeTree(int curNode, int p, int dep) {
		
		for(int node : list[curNode]) {
			// 부모를 제외한 자식들을 넣어준다. 
			if(node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				depth[node] = dep;
				makeTree(node, curNode, dep+1);
			}
		}
	}
	
	public static int findSameParent(int node1, int node2) {
		
		// 같은 층으로 만든다. a가 더 밑에 있을 경우
		while(depth[node1] > depth[node2]) {
			node1 = parent[node1];
		}
		
		// b가 더 밑에 있을 경우
		while(depth[node2] > depth[node1]) {
			node2 = parent[node2];
		}
		
		// 같은 층인데 같지 않을 경우 (부모가 다르다면) 부모 찾을 때까지 반복.
		while(node1 != node2) {
			node1 = parent[node1];
			node2 = parent[node2];
		}
			
		return node1;
	}
}
