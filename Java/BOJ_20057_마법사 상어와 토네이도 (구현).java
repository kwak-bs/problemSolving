package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057 {
	// BOJ / 20057번 / 마법사 상어와 토네이도 / 구현  / 골드3
	
	static int map[][], n;
	static int dr[] = {0, 1, 0, -1}; // 서 남 동 북 
	static int dc[] = {-1, 0, 1, 0};
	static int dt[] = {1,1,2,2}; // 한바퀴당 이동 거리 (비율)
	static int sr[][] = { 
			{-1,1,-2,-1,1,2,-1,1,0}, // 서
			{-1,-1,0,0,0,0,1,1,2},   // 남 
            {1,-1,2,1,-1,-2,1,-1,0}, // 동
            {1,1,0,0,0,0,-1,-1,-2}	// 북
	};
	static int sc[][] = {
			{1,1,0,0,0,0,-1,-1,-2}, // 서
			{-1,1,-2,-1,1,2,-1,1,0}, // 남    
            {-1,-1,0,0,0,0,1,1,2}, // 동
            {1,-1,2,1,-1,-2,1,-1,0}, // 북
	};
	static int sRatio[] = {1,1,2,7,7,2,10,10,5};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		StringTokenizer stk;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		int answer = calculateOutSand(n/2, n/2);
		System.out.println(answer);
	}
	
	public static int calculateOutSand(int r, int c) {
		
		int result = 0;
		
		int cr = r; 
		int cc = c; 
		
		// 위치 이동(토네이동) -> 모래 뿌리기, 밖에 나간 모래 계산 -> 위치 업데이트
		while(true) {
			// 4방향
			for(int i=0; i<4; i++) {
				// 방향당 토네이도 이동 거리 
				for(int d=0; d<dt[i]; d++) {					
					int nr = dr[i] + cr;
					int nc = dc[i] + cc;
					if(!(nr >= 0 && nc >= 0 && nr < n && nc < n)) return result;
					
					int sand = map[nr][nc];
					map[nr][nc] = 0;
					int spread = 0;
					
					// 비율 체크 된 곳 모래 뿌리기
					for(int j=0; j<9; j++) {
						int nsr = sr[i][j] + nr;
						int nsc = sc[i][j] + nc;
						int nSand = (sand * sRatio[j]) / 100;
						spread += nSand;
						
						if(!(nsr >= 0 && nsc >= 0 && nsr < n && nsc < n)) {
							result += nSand;
						}
						else {
							map[nsr][nsc] += nSand;
						}
					}

					// a쪽 모래 뿌리기
					int nar = nr+dr[i];
					int nac = nc+dc[i];

					if(!(nar >= 0 && nac >= 0 && nar < n && nac < n)) {
						result += (sand - spread);
					}
					else {
						map[nar][nac] += (sand - spread);
					}
					cr = nr;
					cc = nc;
				}
			}
			for(int t=0; t<4; t++) {
				dt[t] += 2;
			}
		}
	}
}
