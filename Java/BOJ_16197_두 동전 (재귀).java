package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16197 {
	// BOJ / 16197번 / 두 동전 / 재귀 / 골드 4
	
	static int n,m, ans,dy[] = {1,-1,0,0} , dx[] = {0,0,1,-1};
	static char map[][];
	static int y1,y2,x1,x2;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new char[n][m];
		boolean first = true;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'o') {
					if(first) {
						y1 = i;
						x1 = j;	
						first = false;
					}
					else {
						y2 = i;
						x2 = j;
					}
				}
				
			}
		}
		ans = Integer.MAX_VALUE;

		go(new coin(y1,x1,y2,x2), 0);
		
		
		if(ans > 10 || ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	public static void go(coin coinInfo, int btnCount) {

		if(btnCount > 10 ) return;
		
		coin now = coinInfo;
		
		for(int i=0; i<4; i++) {
			int ny1 = now.y1 + dy[i];
			int nx1 = now.x1 + dx[i];
			int ny2 = now.y2 + dy[i];
			int nx2 = now.x2 + dx[i];
			
			int out = 0;
			
			if( !(ny1 >= 0 && ny1 < n && nx1 >=0 && nx1 < m)) out++;
			if( !(ny2 >= 0 && ny2 < n && nx2 >=0 && nx2 < m)) out++;

			// 두개 다 떨어졌으면 그냥 넘어감 
			if(out == 2) continue;
			
			// 하나만 떨어졌으면 return;
			if(out == 1) {

				ans = Math.min(ans, btnCount+1);
				return;
			}
			 
			// 둘 다 안떨어졌을 경우는 다음 칸이 빈칸이거나 , 벽임 
			if(map[ny1][nx1] == '#') {
				ny1 = now.y1;
				nx1 = now.x1;
			}
			if(map[ny2][nx2] == '#') {
				ny2 = now.y2;
				nx2 = now.x2;
			}
			
			go(new coin(ny1,nx1,ny2,nx2), btnCount+1);
		}
	}
	
	static class coin {
		int y1, x1, y2, x2;
		
		public coin(int y1, int x1, int y2, int x2) {
			this.y1 = y1;
			this.x1 = x1;
			this.y2 = y2;
			this.x2 = x2;
		}
	}
}
