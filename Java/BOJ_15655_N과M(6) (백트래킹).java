package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15655 {
	// BOJ / 15655번 / N과M(6) / 백트래킹 / 실3
	static int n, m;
	static boolean visit[];
	static int print[], num[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		visit = new boolean[n];
		num = new int[n];
		print = new int[m];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(num);
		
		dfs(0,0);
		
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
		
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				print[depth] = num[i];
				dfs(depth+1, i+1);
				visit[i] = false;
			}
		}
	}
}
