package problemSolve4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PM_12978 {

	public static void main(String[] args) {
		int N= 6;
		int road[][] = {
				{1,2,1},
				{1,3,2},
				{2,3,2},
				{3,4,3},
				{3,5,2},
				{3,5,3},
				{5,6,1},
		};
		int K = 4;
		solution(N, road, K);
	}

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        ArrayList<Edge>[] graph = new ArrayList[N];
        
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for(int i=0; i<road.length; i++) {  
            graph[road[i][0]-1].add(new Edge(road[i][1]-1, road[i][2]));
            graph[road[i][1]-1].add(new Edge(road[i][0]-1, road[i][2]));
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {
            @Override 
            public int compare(Edge o1, Edge o2) {
                if(o1.w < o2.w) return -1;
                else if (o1.w == o2.w) return 0;
                else return 1;
            }
        });
        
        pq.offer(new Edge(0,0));
        
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
        for(int i : dist) {
            if( i <= K) answer++;
        }
        return answer;
    }
}
