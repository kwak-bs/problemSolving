package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18352 {
	// BOJ / 18352번 / 특정 거리의 도시 찾기 / 다익스트라  / 실버2
	static ArrayList<Edge> graph[];
	static StringBuffer sb;
	static final int INF = 987654321;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken()); // 특정 거리
		int x = Integer.parseInt(stk.nextToken())-1; // 출발 
		
		graph = new ArrayList[n];
		
		for(int i=0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken())-1;
			int b = Integer.parseInt(stk.nextToken())-1;
			graph[a].add(new Edge(b,1));
		}
		
		sb = new StringBuffer();
		dijkstra(n,x,k);
		
		if(flag) {
			System.out.println(sb);			
		}
		else {
			System.out.println(-1);
		}
	}
	
	public static void dijkstra(int n, int start, int target ) {
		int [] dist = new int[n];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		boolean visit[] = new boolean[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			if(now.w> dist[now.v] || visit[now.v]) continue;
			visit[now.v] = true;
			for(int i=0; i<graph[now.v].size(); i++) {
				Edge next = graph[now.v].get(i);

				if(dist[next.v] > dist[now.v] + next.w && !visit[next.v]) {
					dist[next.v] = dist[now.v] + next.w;
					pq.add(new Edge(next.v, dist[next.v]));
				}
			}
		}

		for(int i=0; i<dist.length; i++) {
			if(dist[i] == target) {
				flag = true;
				sb.append(i+1).append("\n");
			}
		}
	}
	private static class Edge {
		int v,w;
		
		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
}

