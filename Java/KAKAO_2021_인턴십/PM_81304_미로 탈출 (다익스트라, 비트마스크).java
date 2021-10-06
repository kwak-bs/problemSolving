package problemSolve6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;


public class PM_81304 {
	// PM / 81304번 / 2021 카카오 채용형 인턴 / 다익스트라, 비트마스킹 / 미로 탈출
	public static void main(String[] args) {
		
		solution(4,1,4, new int[][] {
			{1,2,1},
			{3,2,1},
			{2,4,1}
		}, new int[] {2,3});
	}
	
    static ArrayList<Edge> graph[];
    static int dist[][], answer = 0, INF = 29970000;
    static HashMap<Integer, Integer> trap = new HashMap<>();
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        
        graph = new ArrayList[n+1];
        dist = new int[n+1][1<<10];
        
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<roads.length; i++) {
            // 정상 = 0
            graph[roads[i][0]].add(new Edge(roads[i][1], roads[i][2], 0));
            // 거꾸로 = 1
            graph[roads[i][1]].add(new Edge(roads[i][0], roads[i][2], 1));
        }
        // 비트 마스킹에 필요한 trap 저장.
        for(int i=0; i<traps.length; i++) {
            trap.put(traps[i], i);
        }
        
        for(int i=0; i<dist.length; i++) {
            Arrays.fill(dist[i], INF);
        }
        
        dijkstra(start, end);
        
        return answer;
    }
    
    public static void dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<>(){
            @Override 
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;
            }
        });
        
        pq.add(new Edge(start, 0, 0));
        dist[start][0] = 0;
        
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            int now_v = now.v;
            int now_w = now.w;
            int now_s = now.s;

            if(now_v == end) {
                answer = now_w;
                break;
            }
            if(dist[now_v][now_s] < now_w) continue;

            for(Edge next : graph[now_v]) {
                int next_v = next.v; 
                int next_w = next.w; 
                int isReverse = next.s;
                
                // 현재 정점의 상태와 일치하는 그래프 선택 ( 0 or 1)
                if(isReverse != (checkReverse(now_v, next_v, now_s) ? 1 : 0)) continue;

                int next_s = getNextState(now_s, next_v);
                next_w += now_w;
                
                if(next_w >= dist[next_v][next_s]) continue;
                
                dist[next_v][next_s] = next_w;
                pq.add(new Edge(next_v, next_w, next_s));
            }
        }
    }
    
    public static int getNextState(int now_s, int next_v) {
        if(trap.containsKey(next_v)) {
            now_s ^= (1 << trap.get(next_v));
        }
        return now_s;
    }
    
    public static boolean checkReverse(int now_v, int next_v, int now_s) {
        
        boolean nowNodeState = false, nextNodeState = false;
        // & : 두 비트가 1이면 1 
        if(trap.containsKey(now_v)) {
            nowNodeState = ((now_s & (1 << trap.get(now_v))) != 0);
        }
        if(trap.containsKey(next_v)) {
            nextNodeState = ((now_s & (1 << trap.get(next_v))) != 0);
        }
        // ^ : 두 비트가 다르면 1 
        return nowNodeState ^ nextNodeState;
    }
    
    private static class Edge {
        int v , w, s;
        public Edge (int v, int w, int s) {
            this.v = v; 
            this.w = w;
            this.s = s;
        }
    }
}
