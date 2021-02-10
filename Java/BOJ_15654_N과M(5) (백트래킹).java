package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15654 {
	// BOJ / 15652번 / N과M(5) / 백트래킹 / 실3
	static int n,m;
	
	static boolean visit[];
	static int print[];
	static int num[];
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		print = new int [m];
		num = new int[n];
		visit = new boolean[n];
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		// 오름차순 출력을 위하여 정렬.
		Arrays.sort(num);
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
			if(!visit[i]) {
				visit[i] = true;
				print[depth] = num[i];
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}
}
