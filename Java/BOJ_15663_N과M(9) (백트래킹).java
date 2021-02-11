package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15663 {
	// BOJ / 15663번 / N과M(9) / 백트래킹 / 실2
	
	static int n, m;
	static int print[], num[], before[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		num = new int[n];
		print = new int[m];
		before = new int[m];
		visit = new boolean[n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(num);
		dfs(0, "");
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth, String s) {
		
		if(depth == m) {
			// set에 이미 수열이 있으면 return;
			if(set.contains(s)) {
				return;
			}
			else {
				set.add(s);				
			}
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
				dfs(depth+1, s+num[i]+" ");
				visit[i] = false;
			}
		}
	}
}
