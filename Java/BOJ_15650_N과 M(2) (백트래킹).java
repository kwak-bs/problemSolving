package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
	// BOJ / 15649번 / N과M(2) / 백트래킹 / 실3
	static int n,m;
	static int print[];
	static boolean visit[];
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());	
		m = Integer.parseInt(stk.nextToken());
		
		print = new int[m];
		visit = new boolean[n];

		dfs(0, 0);
		System.out.println(sb);
	}
	
	public static void dfs(int depth,int start) {
		
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
				print[depth] = i + 1;
				// 어차피 초기 배열이 오름차순이기 때문에 다음 배열을 dfs 인자로 보내면된다.
				dfs(depth + 1, i + 1);
				visit[i] = false;
			}
		}
	}
}
