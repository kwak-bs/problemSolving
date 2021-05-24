package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
	// BOJ / 1916번 / 최소비용 구하기 / 다익스트라  / 골드5 
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer stk ;
		ArrayList<Edge> graph [] = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			graph[a-1].add(new Edge(b-1, c));
		}
		stk = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(stk.nextToken());
		int e = Integer.parseInt(stk.nextToken());
		int dist[] = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s-1] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		}); 
		pq.add(new Edge(s-1, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.w > dist[now.v]) continue;
			
			for(int i=0; i<graph[now.v].size(); i++) {
				Edge next = graph[now.v].get(i);
				
				if(dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		System.out.println(dist[e-1]);
	}
	
	private static class Edge {
		int v,w;
		public Edge(int v, int w ) {
			this.v = v;
			this.w = w;
		}
}

}