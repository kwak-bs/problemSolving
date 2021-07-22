package problemSolve6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PM_81302 {
	// PM / 81302번 / 거리두기 확인하기 / 구현, bfs / Level2 / 2021 카카오 채용연계형 인턴십
	public static void main(String[] args) {
		solution(new String[][] {
			{"OOPOO", "OPOOO", "OOOOO", "OOOOO", "OOOOO"}
		});
	}
    static int dr[] = {1,-1,0,0};
    static int dc[] = {0,0,1,-1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++) {
        	answer[i] = go(places[i]);
        }
        return answer;
    }
    
    public static int go(String[] map) {
    	for(int i=0; i<map.length; i++) {
    		for(int j=0; j<map[i].length(); j++) {
    			if(map[i].charAt(j) == 'P') {
    				if(!bfs(map,i,j)) return 0;
    			}
    		}
    	}
    	return 1;
    }
    
    public static boolean bfs(String map[], int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        boolean [][] v = new boolean[map.length][map.length];
        q.add(new int[] {r,c});
        v[r][c] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];

            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int manhattan = Math.abs(r - nr) + Math.abs(c - nc);
                
                if(!(nr >=0 && nc >= 0 && nr<map.length && nc <map.length))continue;
                if(v[nr][nc] || manhattan > 2) continue;
                
                v[nr][nc] = true;
                if(map[nr].charAt(nc) == 'X') continue;
                else if(map[nr].charAt(nc) == 'P') return false;
                else {
                    q.add(new int[] {nr,nc});
                }
            }
        }
        return true;
    }
}
