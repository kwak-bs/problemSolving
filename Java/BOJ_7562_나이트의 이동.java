package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562 {
	// BOJ / 7562번 / 나이트의 이동 / 그래프 / 실2
	
	static int [][] map;
	static int sty, stx, Endy, Endx, l, count;
	static int[] dy = {1, -1, 1, -1,2, 2, -2, -2};
	static int[] dx = {2, 2, -2, -2,1, -1, 1, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		int tcCnt = 1;
		
		while(tcCnt <= tc) {
			// -- 입력 시작
			// 크기
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			
			// start 지점
			stk = new StringTokenizer(br.readLine(), " ");
			sty = Integer.parseInt(stk.nextToken());
			stx = Integer.parseInt(stk.nextToken());
			
			// End 지점
			stk = new StringTokenizer(br.readLine(), " ");
			Endy = Integer.parseInt(stk.nextToken());
			Endx = Integer.parseInt(stk.nextToken());
			// -- 입력 끝
			
			bfs();
			
			System.out.println(map[Endy][Endx]);
			tcCnt++; 
		}
	}
	
	public static void bfs() {
		
		if(stx == Endx && sty == Endy) { // 첫점과 끝점이 같으면 return
			return;
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {sty,stx});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for(int i=0; i<dy.length; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if(ny >= 0 && ny < l && nx >= 0 && nx < l) {
					if(map[ny][nx] == 0) {
						q.offer(new int[] {ny,nx});
						map[ny][nx] = map[now[0]][now[1]] + 1;						
					}
				}
			}
			
		}
		
	}
}
