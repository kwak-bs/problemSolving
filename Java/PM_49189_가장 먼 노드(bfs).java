package problemSolve4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PM_49189 {
	// PM / 49189번 / 가장 먼 노드 / bfs  / Level3
    static boolean []v;

    public static void main(String[] args) {

    	int vertex[][] = {
    			{3,6},
    			{4,3},
    			{3,2},
    			{1,3},
    			{1,2},
    			{2,4},
    			{5,2},
    	};
	}
    
    public static int solution(int n, int[][] edge) {
        
        ArrayList<Integer> graph[] = new ArrayList[n];
        v = new boolean[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edge.length; i++) {
            graph[edge[i][0]-1].add(edge[i][1]-1);
            graph[edge[i][1]-1].add(edge[i][0]-1);
        }
        return bfs(graph, n);
    }
    
    public static int bfs(ArrayList<Integer>[] graph , int n) {
        
        Queue<int[]> q = new LinkedList<>();
        int len[] = new int[n];
        len[0] = 0;
        int cnt = 0;
        
        v[0] = true;
        int max = Integer.MIN_VALUE;
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(max < now[1]) max = now[1];
            for(int i=0; i<graph[now[0]].size(); i++) {
                int next = graph[now[0]].get(i);
                if(!v[next]) {
                    v[next] = true;
                    q.add(new int[]{next, now[1]+1});
                    len[next] = now[1]+1;
                }
            }
        }
        
        for(int val : len) {
            if( val == max ) cnt++;
        }
        return cnt;
    }
}
