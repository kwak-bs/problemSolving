package problemSolve6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PM_72413_difkstra {
	// PM / 72413번 / 합승 택시 요금 / 다익스트라  / Level3 / 2021 KAKAO BLIND
	public static void main(String[] args) {

		solution(6,4,6,2,new int[][] {
			{4,1,10},
			{3,5,24},
			{5,6,2},
			{3,1,41},
			{5,1,24},
			{4,6,50},
			{2,4,66},
			{2,3,22},
			{1,6,25},
		});
	}
	static final int INF = 99999999;
	static ArrayList<Edge> graph[];
	
    public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = INF;
		
		graph = new ArrayList[n+1];
		
		for(int i=0; i<graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<fares.length; i++) {
			graph[fares[i][0]].add(new Edge(fares[i][1], fares[i][2]));
			graph[fares[i][1]].add(new Edge(fares[i][0], fares[i][2]));
		}
		int fromStart[] = new int[n+1];
		int fromA[] = new int[n+1];
		int fromB[] = new int[n+1];
		
		fromStart = dijkstra(s, fromStart);
		fromA = dijkstra(a, fromA);
		fromB = dijkstra(b, fromB);
		
		for(int i=1; i<=n; i++) {
			answer = Math.min(answer, fromStart[i] + fromA[i] + fromB[i]);
		}
		return answer; 
    }
    
    public static int[] dijkstra(int s, int dist[]) {
    	
    	PriorityQueue<Edge> pq = new PriorityQueue<>( new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.w - o2.w;
			}
    	});
    	Arrays.fill(dist, INF);
    	dist[s] = 0;
    	
    	pq.add(new Edge(s, 0));
    	
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
    	
    	
    	return dist;
    }
}

class Edge{
	int v,w;
	public Edge(int v,int w) {
		this.v = v;
		this.w = w;
	}
}