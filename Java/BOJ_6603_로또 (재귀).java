package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
	// BOJ / 6603번 / 로또 / 재귀 / 실버2
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk;

		while(true) {
			stk = new StringTokenizer(br.readLine(), " ");	
			
			int n = Integer.parseInt(stk.nextToken());
			
			if(n == 0) break;
			int num [] = new int[n];
			int lotto [] = new int[6];
			boolean visit[] = new boolean[n];
			for(int i=0; i<n; i++) {
				num[i] = Integer.parseInt(stk.nextToken());
			}
			
			go(num,lotto,visit, 0);
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void go(int num[],int lotto[], boolean visit[], int depth) {
		
		if(depth == 6) {
			for(int i=0; i<lotto.length; i++) {
				sb.append(lotto[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<num.length; i++) {
			if(visit[i]) continue;
			if(depth == 0 || check(lotto,num[i], depth)) {
				
				visit[i] = true;
				lotto[depth] = num[i];
				go(num, lotto, visit, depth+1);
				visit[i] = false;
			}
		}
	}
	
	public static boolean check(int [] lotto,int num, int idx) {
		
		if(num > lotto[idx-1]) {
			return true;
		}
		else return false;
	}
}
