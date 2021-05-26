package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
	// BOJ / 1238번 / 파티 / 다익스트라  / 골드3
	static final int INF = 987654321;
	static int n,m,x;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken()); // 학생
		m = Integer.parseInt(stk.nextToken()); // 도로
		x = Integer.parseInt(stk.nextToken())-1; // 목적지 , 0부터 시작할거임
		
		ArrayList<Edge> []graph = new ArrayList[n];
		ArrayList<Edge> []reverse_graph = new ArrayList[n];
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
			reverse_graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken()) - 1;
			int b = Integer.parseInt(stk.nextToken()) - 1;
			int c = Integer.parseInt(stk.nextToken());
			
			graph[a].add(new Edge(b,c)); // 주어진 입력 
			reverse_graph[b].add(new Edge(a,c)); // 주어진 입력 반대로 
		}
		// 단방향으로 입력이 주어지기 때문에 왕복을 해결하는 문제에서는 단방향 그래프를 역방향으로도 저장한 후 
		// 목적지를 기준으로 각 노드의 값을 더해주면 최소 왕복 거리를 구할 수 있다. 
		
		int dist1[] = dijkstra(graph); // x에서 다른 점들 최단거리
		int dist2[] = dijkstra(reverse_graph); // 다른 점들에서 x까지 최단 거리
		int answer = 0;
		for(int i=0; i<dist1.length; i++) {
			answer = Math.max(answer, dist1[i] + dist2[i]);
		}
		System.out.println(answer);
	}	
	public static int[] dijkstra(ArrayList<Edge> town[]) {
		
		int dist[] = new int[n];
		Arrays.fill(dist, INF);
		dist[x] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		pq.add(new Edge(x, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			for(int i=0; i<town[now.v].size(); i++) {
				Edge next = town[now.v].get(i);
				
				if(dist[next.v] > dist[now.v] + next.w) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}
		return dist;
	}
	private static class Edge {
		int v,w;
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}