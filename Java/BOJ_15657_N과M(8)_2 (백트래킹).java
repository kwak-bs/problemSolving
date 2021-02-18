package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15657_2 {
	// BOJ / 15649번 / N과 M (8)  / 백트래킹 / 실3
	
	static int print[], list[];
	static boolean visit[];
	static int n, m;
	static StringBuffer sb;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		list = new int[n];
		visit = new boolean[n];
		print = new int [m];
		sb = new StringBuffer();
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i =0; i<list.length; i++) {
			list[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(list);
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

				print[depth] = list[i];
				dfs(depth + 1, i);

		}
	}
}
