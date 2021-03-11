package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14499 {
	// BOJ / 14499번 / 주사위 굴리기 / 구현 / 골드5
	static int[] dy= {0,0,-1,1}; // 동(0) 서(1) 북(2) 남(3)
	static int[] dx= {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int dice[] = new int[7];
		int map[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		while(k-- > 0) {
			int d = Integer.parseInt(stk.nextToken())-1;
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny < 0 || nx >= m || nx < 0 || ny >= n) {
				// 바깥으로 이동시키려고 하는 경우에는 해당 명령을 무시해야 하며, 출력도 하면 안 된다.
				continue;
			}
			
			// 주사위 이동
			switch(d) {
			//동
			case 0 : 
				int temp = dice[1];
				dice[1] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[3];
				dice[3] = temp;
				break;
			//서
			case 1 :
				temp = dice[1];
				dice[1] = dice[3];
				dice[3] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp;
				break;
			// 북
			case 2 :
				temp = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
				break;
			// 남
			case 3 :
				temp = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
				break;
			}
			y = ny;
			x = nx;
			
			// 0인지 판단 후 배열 값 복사 or 주사위 값 복사.
			if(map[y][x] == 0) {
				map[y][x] = dice[6];
			}
			else {
				dice[6] = map[y][x];
				map[y][x] = 0;
			}
			// 주사위 맨 위의 값 출력.
			sb.append(dice[1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
