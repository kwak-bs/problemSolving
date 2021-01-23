package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_5568 {
	// BOJ / 5568번 / 카드 놓기 / 해쉬 / 실5
	static HashSet<String> set;
	static int num[], n , k;
	static boolean visit[];
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		num = new int[n];
		set = new HashSet<>();
		sb = new StringBuilder();
		visit = new boolean[n];
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		// k값, 시작 인덱스, 빈문자열을 넘겨준다.
		dfs(k, 0, "");
		
		// set size 출력.
		System.out.println(set.size());
	}
	
	public static void dfs(int k, int index, String s) {
		
		// 2개를 다 선택햇으면 set에 넣어줌
		if(k == 0) {
			set.add(s);
			return;
		}
		
		for(int i=0; i<n; i++) {
			
			if(!visit[i]) {
				visit[i] = true;
				dfs(k-1, i, s+num[i]);
				// 백트래킹 처리
				visit[i] = false;
			}
		}
	}
}
