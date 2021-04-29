package problemSolve4;

import java.util.LinkedList;
import java.util.Queue;

public class PM_1844 {
	// PM / 1844번 / 게임 맵 최단거리 / BFS  / Level2 / 찾아라 프로그래밍 마에스터
	public static void main(String[] args) {

		solution(new int[][] {
			{1,0,1,1,1},
			{1,0,1,0,1},
			{1,0,1,1,1},
			{1,1,1,0,1},
			{0,0,0,0,1},
		});
	}
    static boolean[][] v;
    static int N, M, answer;
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};
	
    public static int solution(int[][] maps) {
        answer = -1;
        N = maps.length;
        M = maps[0].length;
        v = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(maps[i][j] == 0) {
                    v[i][j] = true;
                }
            }
        }
        
        bfs(maps, 0, 0);
        return answer;
    }
    
    public static void bfs(int [][]maps, int r, int c) {
        
    Queue<int[]> q = new LinkedList<>();
    q.add (new int[] {r,c,1});
    v[r][c] = true;
    
    while(!q.isEmpty()) {
        int[] now = q.poll();
        int cr = now[0];
        int cc = now[1];
        int cnt = now[2];
        if(cr == N-1 && cc == M-1) {
            answer = cnt;
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nr = cr + dr[i];
            int nc = cc + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if(!v[nr][nc] && maps[nr][nc] == 1) {
                    v[nr][nc] = true;
                    q.add(new int[] {nr, nc, cnt + 1});
                }
            }
        }
    }
    }

}
