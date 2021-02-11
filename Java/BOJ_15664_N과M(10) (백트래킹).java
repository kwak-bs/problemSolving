package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15664 {
	// BOJ / 15664번 / N과M(10) / 백트래킹 / 실2
	
	static int n,m;
	static int print[], num[];
	static boolean visit[];
	static HashSet<String> set = new HashSet<String>();
	
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		
		num = new int[n];
		print = new int[m];
		visit = new boolean[n];
		
		stk = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(num);
		
		dfs(0,0, "");
		
		System.out.println(sb);
	}
	
	public static void dfs(int depth, int start, String s) {
		if(depth == m) {
			if (set.contains(s)) {
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
		
		for(int i=start; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				print[depth] = num[i];
				dfs(depth + 1, i, s+num[i]+" ");
				visit[i] = false;
			}
		}
	}
}
