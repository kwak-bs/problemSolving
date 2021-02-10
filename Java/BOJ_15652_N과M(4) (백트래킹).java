package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
	// BOJ / 15652번 / N과M(4) / 백트래킹 / 실3
	static int n,m, before;
	
	static boolean visit[];
	static int print[];
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		print = new int [m];
		
		dfs(0, 0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start) {

		if(depth == m) {
			for(int value : print) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		// 비오름차순은 start값을 현재 자기 자신값으로 인자를 넘겨주면 된다.
		for(int i=start; i<n; i++) {
			print[depth] = i + 1;
			dfs(depth+1, i);
		}
	}
}
