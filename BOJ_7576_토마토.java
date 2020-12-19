package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {
	//BOJ / 7576번 / 토마토  / 그래프, bfs / 실1
	
	static int [][] map;
	static int [] dr = {1,-1,0,0}; // 상하
	static int [] dc = {0,0,1,-1}; // 좌우
	static int N;
	static int M;
	static int day;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];
		day = 0;
		
		// map 입력.
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for( int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		
		// 이거 두번째 이슈였음. 여기서 bfs 호출하면 안됨. tc3에서 걸림. 그 이유는 1이 여러개 들어있는 상황에서는 순차적으로 bfs를 호출하기 때문에 안됨.
//		for(int i=1; i<=M; i++) {
//			for(int j=1; j<=N; j++) {
//				if(map[i][j] == 1) { // 1인 부분 찾아서 bfs 시작.
//					//System.out.println(i + " " + j);
//					bfs(i,j,0);
//				}
//			}
//		}

		bfs();
		if(check()) {
			System.out.println(day);
		}
		else {
			System.out.println(-1);
		}
	}
		
	public static void bfs() {
		
		Queue<int []> q = new LinkedList<>();
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 1) { // 1인 부분 찾아서 큐에 넣어줌 
					q.offer(new int[] {i,j, 0}); // 입력된 map에서 1을 찾아 day = 0으로 초기화 후 q에 넣어줌 
				}
			}
		}
		
		while(!q.isEmpty()) {
			
			int [] now = q.poll();
			
			//여기가 첫번째 이슈였음.
			// day = now[2] 이걸 안해주고 q에 day를 포함시켜주지 않았으면 day는 for문을 돌때마다 증가되는 이슈가 발생했음.
			day = now[2];
			
			for(int k=0; k<dr.length; k++) {
				int r = now[0] + dr[k]; // {1,-1,0,0}
				int c = now[1] + dc[k]; // {0,0,1,-1}
				
				if(r > 0 && c>0 && r<=M && c<=N) {
					if(map[r][c] == 0) {
						q.offer(new int[] {r,c, day+1} );
						map[r][c] = 1;
					}
				}
			}
		}
	}
	
	public static boolean check() {
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				if(map[i][j] == 0) { 
					return false;
				}
			}
		}
		
		return true;
	}
}
