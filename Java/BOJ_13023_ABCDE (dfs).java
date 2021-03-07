package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_13023 {
	// BOJ / 13023번 / ABCDE / 그래프 / 골드5
	static boolean visit[];
	static ArrayList<Integer> al[];
	static int m,n, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		ans = 0;
		al = new ArrayList[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) {
			al[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			al[a].add(b);
			al[b].add(a);
		}
		
		for(int i=0; i<n; i++) {
			if(ans == 0) dfs(i,1);
		}
		System.out.println(ans);
	}
	
	public static void dfs(int index, int depth) {
		
		if(ans == 1) {
			return;
		}
		
		if(depth == 5) {
			ans = 1;
			return;
		}
		
		visit[index] = true;
		for(int value : al[index]) {
			if(!visit[value]) {
				dfs(value, depth+1);
			}
		}
		visit[index] = false;
	}
}
