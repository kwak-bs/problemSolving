package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1890 {
	// BOJ / 1890번 / 점프 / dp / 실2
	// bfs로 풀었다가 시간초과 나서 접음. 아 내 시간 
	static boolean visit[][];
	static int n;
	static int map[][];
	static long dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n];

		for(int i=0; i<n; i++) {
			stk= new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		dp[0][0] = 1;

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 갈 수있는 거리 저장
				int next = map[i][j];
				// 마지막 좌표는 건너뛴다.
				if(i == n-1 && j == n-1) {
					continue;
				}
				// y축이 범위 안에 있으면, 현재 dp 값을 다음 dp값에 더한다.
				if(next + i < n) {
					dp[next+i][j] += dp[i][j];
				}
				// 마찬가지
				if(next + j < n) {
					dp[i][next+j] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-1][n-1]);

	}
}
