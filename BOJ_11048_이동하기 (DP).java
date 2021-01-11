package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048 {
	// BOJ / 14503번 / 이동하기 / DP / 실1
	
	static int y, x;
	static int map[][], dp[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][x];
		dp = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 초기 시작점 
		dp[0][0] = map[0][0];
		
		// 첫 열과 첫 행은 순서대로 넣어준다.
		for(int i=1; i<x; i++) {
			dp[0][i] = dp[0][i-1] + map[0][i];
		}
		for(int i=1; i<y; i++) {
			dp[i][0] = dp[i-1][0] + map[i][0];
		}
		
		// 행-1, 열-1, 행-1 열-1의 인덱스 값 + map[i][j] 한 결과들을 비교한다. 
		for(int i=1; i<y; i++) {
			for(int j=1; j<x; j++) {
				dp[i][j] = Math.max(dp[i-1][j] + map[i][j],
							Math.max(dp[i][j-1] + map[i][j],
									  dp[i-1][j-1] + map[i][j]));
			}
		}

		System.out.println(dp[y-1][x-1]);
	}
}
