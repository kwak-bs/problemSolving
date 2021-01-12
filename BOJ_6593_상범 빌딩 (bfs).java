package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
	//BOJ / 6593번 / 상범 빌딩  / 그래프  / 골5
	
	static class dot {
		int z,x,y;
		
		public dot(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}
	
	static int x,y,z, minute;
	static dot start, end;
	static boolean escape;
	static char map[][][];
	static int dz[] = {1, -1, 0, 0, 0, 0}; // 상하
	static int dy[] = {0, 0, 1, -1, 0, 0}; // 행 이동
	static int dx[] = {0, 0, 0, 0, 1, -1}; // 열 이동
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		
		while(true) {
			escape = false;
			minute = 0;
			
			stk = new StringTokenizer(br.readLine(), " ");
			z = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());
			x = Integer.parseInt(stk.nextToken());
			
			// 0 0 0 입력이면 종료.
			if(z == 0 && y == 0 && x == 0) {
				break;
			}
			map = new char[z][y][x];
			
			// map 입력
			for(int i=0; i<z; i++) {
				for(int j=0; j<y; j++) {
					map[i][j] = br.readLine().toCharArray();
					for(int k=0; k<x; k++) {
						// 입력했으면 start 지점과 end 지점을 찾음
						if(map[i][j][k] == 'S') {
							start = new dot(i,j,k);
						}
						if(map[i][j][k] == 'E') {
							end = new dot(i,j,k);
						}
					}
				}
				br.readLine();
			}
			
			bfs();
			
			if(escape) {
				System.out.println("Escaped in "+minute+" minute(s).");
			} else {
				System.out.println("Trapped!");
			}
		}	
	}
	
	public static void bfs() {
		Queue<dot> q = new LinkedList<>();
		
		q.offer(start);
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) {
				dot now = q.poll();
				
				// now.equlas(end)가 안먹히는데 왜 그런지는 모르겠다. 
				if(now.z == end.z && now.y == end.y && now.x == end.x ) {
					escape = true;
					return;
				}
				
				for(int i=0 ; i<6; i++) {
					int nz = now.z + dz[i];
					int ny = now.y + dy[i];
					int nx = now.x + dx[i];
					
					if(nz >= 0 && nz < z && ny >= 0 && ny < y && 
							nx >= 0 && nx < x ) {
						if(map[nz][ny][nx] == '.' || map[nz][ny][nx] == 'E') {
							map[nz][ny][nx] = '#';
							q.offer(new dot(nz,ny,nx));
						}
					}
				}
			}
			minute++;
		}
		
	}
}
