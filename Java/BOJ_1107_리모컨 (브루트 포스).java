package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
	// BOJ / 1107번 / 리모컨  / 브르투 포스 / 골5
	
	static int n,m;
	static boolean broken[];
	static int min, limit;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		// 런타임 에러(Nullpointer 에러) 방지
		if(m != 0) {
			stk=new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<m; i++) {
				broken[Integer.parseInt(stk.nextToken())] = true;
			}			
		}
		
		limit = (n+"").length()+1;
		min = Math.abs(n-100);
		
		// 가능한 모든 번호탐색 
		for(int i=0; i<10; i++) {
			if(broken[i]) {
				continue;
			}
			dfs(1,i);
		}
		System.out.println(min);
	}
	
	public static void dfs(int depth, int ch) {
		
		if(limit < depth) {
			return;
		}
		
		// 최대한 누를 수 있는 가까운 번호를 눌러주고 +-처리는 depth
		min = Math.min(min, depth + Math.abs(n-ch));
		
		for(int i=0; i<10; i++) {
			if(broken[i]) {
				continue;
			}
			dfs(depth+1, (ch*10) + i);
		}
	}

}
