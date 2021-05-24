package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {
	// BOJ / 1504번 / 특정한 최단 경로 / 다익스트라  / 골드4 
	static final int INF = 10000000;
	static ArrayList<Edge> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int e = Integer.parseInt(stk.nextToken());
		graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			graph[a-1].add(new Edge(b-1,c));
			graph[b-1].add(new Edge(a-1,c));
		}
		stk = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(stk.nextToken())-1;
		int v2 = Integer.parseInt(stk.nextToken())-1;

		int answer = compare(v1 , v2, n);
		System.out.println(answer);
	}
	// 두 경로 가중치 구하고 최솟값 비교
	public static int compare(int v1 , int v2, int n) {
		int result1 = 0;
		int result2 = 0;
		// 0 -> v1 -> v2 -> n-1
		result1 += dijkstra(0, v1,n);
		result1 += dijkstra(v1, v2,n);
		result1 += dijkstra(v2, n-1,n);
		
		// 0 -> v2 -> v1 -> n-1
		result2 += dijkstra(0, v2,n);
		result2 += dijkstra(v2, v1,n);
		result2 += dijkstra(v1, n-1,n);
		
		if(result1 > INF || result2 > INF) {
			return -1;
		}
		else return Math.min(result1, result2);
		
	}
	// 다익스트라 
	public static int dijkstra(int start, int end, int n) {
		int dist[] = new int[n];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override 
			public int compare(Edge o1, Edge o2) {	
				return o1.w - o2.w;
			}
		});
		
		pq.add(new Edge(start, 0));

		while(!pq.isEmpty()) {
			Edge now = pq.poll();

			if(now.w > dist[now.v]) continue;
			for(int i =0; i<graph[now.v].size(); i++) {
				Edge next = graph[now.v].get(i);
				
				if(dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return dist[end];
	}
	
	private static class Edge {
		int v,w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}
