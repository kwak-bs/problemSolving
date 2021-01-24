package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372 {
	// BOJ / 9372번 / 상근이의 여행 / 트리 / 실3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			
			stk  = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(stk.nextToken()); // 국가의 수 
			int m = Integer.parseInt(stk.nextToken()); // 비행기의 종류
			
			for(int i=0; i<m; i++) {
				stk  = new StringTokenizer(br.readLine(), " ");
				
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
			}
			// 최소 스패닝 트리는 V-1개의 간선으로 이루어져 있음. 
			// 즉, 간선의 갯수가 타야할 비행기 갯수다. 
			System.out.println(n-1);
		}		
 	}
}
