package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	// BOJ / 16236번 / 아기 상어 / 구현, BFS / 골드4
	static int n, map[][], size, sr,sc,time,count;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<fish> al;
	static boolean v[][];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		size = 2;
		StringTokenizer stk;
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j] == 9) {
					sr = i;
					sc = j;
					// 이거 중요! 9를 그대로 뒀다가 테케 많이 틀렸다. 상어가 있는 초기 자리는 어차피 이동할 자리기 때문에 0으로 초기화해준다.
					map[i][j] = 0;
				}
			}
		}
		
		bfs(sr,sc);
	}
	
	public static void bfs(int sr, int sc) {
		
		while(true) {
			Queue<fish> q = new LinkedList<>();
			al = new ArrayList<>(); // 먹을수 있는 물고기 리스트 
			v = new boolean[n][n];
			q.add(new fish(sr,sc,0)); // 초기 아기 상어 위치 
			
			while(!q.isEmpty()) {
				fish now = q.poll();
				
				for(int i=0; i<4; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					
					if(!(nr >= 0 && nr < n && nc >= 0 && nc < n)) continue;
					if(v[nr][nc]) continue;
					// 1보다 크고 사이즈보다 작은
					if(map[nr][nc] >= 1 && map[nr][nc] < size) {
						// 상어 위치 갱신 
						q.add(new fish(nr,nc,now.dist+1));
						// 먹을 수 있는 물고기 추가 
						al.add(new fish(nr,nc,now.dist+1));
						v[nr][nc] = true;
					}
					// 먹을 순 없지만 지나는 갈 수 있다.
					else if(map[nr][nc] == size || map[nr][nc] == 0) {
						q.add(new fish(nr,nc,now.dist+1));
						v[nr][nc] = true;
					}
				}
			}
			// 먹이가 없으면 , 이 부분으로 break처리 해준다. 
			if(al.size() == 0) {
				System.out.println(time);
				return;
			}
			// 먹이가 있으면 거리가 가장 가까운 먹이로 갱신 
			fish eat = al.get(0);
			for(int i=1; i<al.size(); i++) {
				if(eat.dist > al.get(i).dist) {
					eat = al.get(i);
				}
				// 거리가 같을 경우 
				if(eat.dist == al.get(i).dist) {
					// 가장 위에 있는 물고기 
					if(eat.r > al.get(i).r) {
						eat = al.get(i);
					}
					// 가장 위에 있는 물고기 마저 여러 마리면 
					else if(eat.r == al.get(i).r) {
						// 가장 왼쪽에 있는 물고기 
						if(eat.c > al.get(i).c) {
							eat = al.get(i);
						}
					}
				}
			}
			// 먹을 물고기의 거리를 시간에 추가 
			time += eat.dist;
			// 먹었으니 1증가 
			count++;
			// 크기와 같은 수의 물고기를 먹으면 size +1
			if(count == size) {
				size++;
				count = 0;
			}
			// 먹힌 물고기의 자리는 0 
			map[eat.r][eat.c] = 0;
			// 먹힌 물고기 자리로 상어 이동
			sr = eat.r;
			sc = eat.c;
		}
	}
	private static class fish {
		int r;
		int c;
		int dist;
		public fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}
