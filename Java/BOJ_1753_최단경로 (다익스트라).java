package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
	// BOJ / 1753번 / 최단 경로 / 다익스트라  / 골드5 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(stk.nextToken()); // 정점 갯수
		int e = Integer.parseInt(stk.nextToken()); // 간선 갯수
		
		int k = Integer.parseInt(br.readLine()); // 시작 번호
		
		ArrayList<Edge> graph[] = new ArrayList[v];
		
		for(int i=0; i<v; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i=0; i<e; i++) {
			stk = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(stk.nextToken()); // a -> b = c
			int b = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			
			graph[a-1].add(new Edge(b-1,c));
		}
		
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k-1] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.w - o2.w;
			}
		});
		pq.add(new Edge(k-1, 0));
		
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
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i<dist.length; i++) {
			if(dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
			else sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}
}

class Edge {
	int v, w;
	public Edge(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
