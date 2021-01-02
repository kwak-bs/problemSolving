package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	//BOJ / 7569번 / 토마토  / 그래프 / 실1
	
	static int [][][] map;
	static int y, x, z;
	static int [] dz = {1, -1, 0, 0, 0, 0}; // 상 하 좌 우 앞 뒤
	static int [] dy = {0, 0, 1, -1 , 0, 0}; // 앞 뒤
	static int [] dx = {0, 0, 0, 0, 1, -1}; // 좌 우 
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		x = Integer.parseInt(stk.nextToken());
		y = Integer.parseInt(stk.nextToken());
		z = Integer.parseInt(stk.nextToken());
		
		map = new int[z][y][x];
		boolean isZero = false;
		
		// 3차원 행렬 입력
		for(int i=0; i<z; i++) {
			for(int j=0; j<y; j++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for(int k=0; k<x; k++) {
					map[i][j][k] = Integer.parseInt(stk.nextToken());
				}
			}
		}
		
		// 처음부터 모든 토마토가 익었으면 isZero = false;
		for(int i=0; i<z; i++) {
			for(int j=0; j<y; j++) {
				for(int k=0; k<x; k++) {
					if(map[i][j][k] == 0) {
						isZero = true;
					}
				}
			}
		}
		
		// 안 익은 토마토가 있으면 if문
		if(isZero) {
			// 익은 토마토로 bfs 시작 
			bfs();
			// 안 익은 토마토가 있는지 check후 출력.
			System.out.println(check());
		}
		else { // 기존의 토마토가 다 익었으면 0 출력
			System.out.println(0);
		}
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int day = 0;
		
		for(int i=0; i<z; i++) {
			for(int j=0; j<y; j++) {
				for(int k=0; k<x; k++) {
					if(map[i][j][k] == 1) {
						// 기존의 토마토는 day가 0임.
						q.offer(new int[] {i,j,k,0});
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			day = now[3];
			
			for(int i=0; i<dx.length; i++) {
				int nz = now[0] + dz[i];
				int ny = now[1] + dy[i];
				int nx = now[2] + dx[i];
				
				if(nz >= 0 && nz < z && ny >= 0 && ny < y &&
						nx >= 0 && nx < x) {
					if(map[nz][ny][nx] == 0) {
						map[nz][ny][nx] = day + 1;
						q.offer(new int[] {nz,ny,nx, day + 1});
					}
				}
			}
		}
	}
	
	public static int check() {
		int max_day = 0;
		
		for(int i=0; i<z; i++) {
			for(int j=0; j<y; j++) {
				for(int k=0; k<x; k++) {
					max_day = Math.max(max_day, map[i][j][k]);
				}
			}
		}
		
		for(int i=0; i<z; i++) {
			for(int j=0; j<y; j++) {
				for(int k=0; k<x; k++) {
					if(map[i][j][k] == 0) { // 안익은게 있으면
						max_day = -1;
					}  
				}
			}
		}
		
		return max_day;
	}
}
