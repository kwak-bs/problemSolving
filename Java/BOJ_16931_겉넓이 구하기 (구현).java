package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931 {
	// BOJ / 16931번 / 겉넓이 구하기 / 구현 / 실버3
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		// 101번째 위치도 탐색을 해야하므로
		int map[][] = new int[102][102];
		
		for(int i=1; i<=y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 윗면과 아랫면은 먼저 구해준다. 
		int ans = 2 *y*x;
		
		// 높이 차를 이용해서 옆면을 구해준다. 
		for(int i=1; i<=y; i++) {
			for(int j=1; j<=x; j++) {
				for(int k=0; k<4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					
					if(map[i][j] - map[ny][nx] > 0 ) {
						ans += map[i][j] - map[ny][nx];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
