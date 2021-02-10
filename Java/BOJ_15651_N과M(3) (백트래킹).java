package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651 {
	// BOJ / 15651번 / N과M(3) / 백트래킹 / 실3
	
	static int print[];
	static int n,m;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		print = new int [m];
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth) {
		
		if(depth == m) {
			for(int value : print) {
				sb.append(value).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<n; i++) {
			print[depth] = i + 1;
			dfs(depth + 1);
		}
	}
}
