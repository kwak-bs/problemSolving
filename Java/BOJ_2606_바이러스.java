package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2606 {
	// BOJ / 2606번 / 바이러스 / 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색/ 실3
	static ArrayList<Integer> []list;
	static boolean visit[];
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int l = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];
		visit = new boolean[n+1];
		Arrays.fill(visit, false);
		
		for(int i =1; i<n+1; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<=l; i++) { // 그래프 입력
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			list[u].add(v);
			list[v].add(u);
		}
		
		for(int i=1; i<n+1; i++) {
			Collections.sort(list[i]);
		}
		dfs(1);
		System.out.println(count);
	}
	
	public static void dfs(int i) {
		
		visit[i] = true;
		
		for(int j : list[i]) {
			if(!visit[j]) {
				dfs(j);
				count++;
			}
		}
		
	}
}
