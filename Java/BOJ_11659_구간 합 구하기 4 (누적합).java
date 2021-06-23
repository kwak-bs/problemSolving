package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {
	// BOJ / 11659번 / 구간 합 구하기 4 / 누적 합 / 실버3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		int sum[] = new int[N+1];
		stk = new StringTokenizer(br.readLine(), " ");
		// 입력과 동시에 각 배열의 누적합을 저장해놓는다. 
		for(int i=1; i<=N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(stk.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		while(M-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			// 끝 배열 - (시작 -1) 배열을 빼준다.
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			sb.append(sum[e] - sum[s-1]).append("\n");
		}
		System.out.println(sb);
	}
}
