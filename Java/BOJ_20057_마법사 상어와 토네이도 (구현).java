package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057 {
	// BOJ / 20057�� / ������ ���� ����̵� / ����  / ���3
	
	static int map[][], n;
	static int dr[] = {0, 1, 0, -1}; // �� �� �� �� 
	static int dc[] = {-1, 0, 1, 0};
	static int dt[] = {1,1,2,2}; // �ѹ����� �̵� �Ÿ� (����)
	static int sr[][] = { 
			{-1,1,-2,-1,1,2,-1,1,0}, // ��
			{-1,-1,0,0,0,0,1,1,2},   // �� 
            {1,-1,2,1,-1,-2,1,-1,0}, // ��
            {1,1,0,0,0,0,-1,-1,-2}	// ��
	};
	static int sc[][] = {
			{1,1,0,0,0,0,-1,-1,-2}, // ��
			{-1,1,-2,-1,1,2,-1,1,0}, // ��    
            {-1,-1,0,0,0,0,1,1,2}, // ��
            {1,-1,2,1,-1,-2,1,-1,0}, // ��
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
		
		// ��ġ �̵�(����̵�) -> �� �Ѹ���, �ۿ� ���� �� ��� -> ��ġ ������Ʈ
		while(true) {
			// 4����
			for(int i=0; i<4; i++) {
				// ����� ����̵� �̵� �Ÿ� 
				for(int d=0; d<dt[i]; d++) {					
					int nr = dr[i] + cr;
					int nc = dc[i] + cc;
					if(!(nr >= 0 && nc >= 0 && nr < n && nc < n)) return result;
					
					int sand = map[nr][nc];
					map[nr][nc] = 0;
					int spread = 0;
					
					// ���� üũ �� �� �� �Ѹ���
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

					// a�� �� �Ѹ���
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
