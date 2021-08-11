package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15681 {
	// BOJ / 15681번 / 트리와 쿼리 / 트리  / 골드5
	static ArrayList<Integer>[] list, tree;
	static int[] parent, size;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		int q = Integer.parseInt(stk.nextToken());
		
		parent = new int [n+1];
		size = new int[n+1];
		list = new ArrayList[n+1];
		tree = new ArrayList[n+1];
		
		for(int i=0; i<list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n-1; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			
			list[u].add(v);
			list[v].add(u);
		}
		// list로 tree를 만든다. 부모 노드는 부모가 없기 때문에 -1 넣어줌
		makeTree(r,-1);
		countSubtreeNodes(r);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<q; i++) {
			int t = Integer.parseInt(br.readLine());
			sb.append(size[t]).append("\n");
		}
		System.out.println(sb);
	}
	// makeTree
	public static void makeTree(int curNode,int p) {
		
		for(int node : list[curNode]) {
			if(node != p) {
				tree[curNode].add(node);
				parent[node] = curNode;
				makeTree(node, curNode);
			}
		}
	}
	
	public static void countSubtreeNodes(int curNode) {
		size[curNode] = 1;
		
		for(int node : tree[curNode]) {
			countSubtreeNodes(node);
			size[curNode] += size[node];
		}
	} 
}
