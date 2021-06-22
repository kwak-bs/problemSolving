package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051 {
	// BOJ / 1051번 / 숫자 정사각형 / 자료구조 / 실버3
	static int max = 1;
	static int n,m, map[][];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				check(i, j, map[i][j]);
			}
		}
		
		System.out.println(max);
 	}
	
	public static void check(int r, int c, int val) {
		int nr = r+1;
		int nc = c+1;
		// 정사각형의 변
		int num = 2;
		while(nr < n && nc<m) {
			// 우
			int rr = map[r][nc];
			
			// 하
			int cc = map[nr][c];
			boolean isSquare = false;
			if(val == rr && rr == cc) {
				int rc = map[nr][nc];
				if(val == rc) {
					isSquare = true;
				}
			}
			// 정사각형이 만들어졌으면
			if(isSquare) {
				max = Math.max(max, num*num);				
			}
			nr++;
			nc++;
			num++;
		}
	}
}
