package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_3 {
	//BOJ / 14502번 / 연구소 / 그래프, 브루트포스  / 골5
	
	
	static class Pair {
	    int x;
	    int y;
	    
	    Pair(int y, int x) {
	        this.y = y;
	        this.x = x;
	    }
	}
	
	static int y, x, max;
	static int map[][];
	static int copy[][];
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		copy = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dfs(0);
		System.out.println(max);
	}
	
	public static void dfs(int count) {
		
		if( count == 3) {
			// 벽 세게 세운 맵 복사. 
			copyMap();
			
			// 바이러스 퍼트리기
			bfs();
		
			// 최댓값 비교 
			max = Math.max(countSafe(), max);
			return;
		}
		
		// dfs, 백트래킹으로 벽 세우기 
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(count+1);
					map[i][j] = 0;		
				}
			}
		}
	}
	
	// bfs로 바이러스 퍼트리끼
	public static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(copy[i][j] == 2) {
					q.offer(new Pair(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if(ny >= 0 && ny < y && nx >= 0 && nx < x) {
					if(copy[ny][nx] == 0) {
						copy[ny][nx] = 2;
						q.offer(new Pair(ny,nx));
					}
				}
			}
		}
	}
	
	public static int countSafe() {
		int count = 0;
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(copy[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static void copyMap() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
}
