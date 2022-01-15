package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049 {
	// BOJ / 1049번 / 기타줄 / 수학, 그리디 / 실버4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int p[] = new int[m];
		int u[] = new int[m];
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			p[i] = Integer.parseInt(stk.nextToken());
			u[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(p); Arrays.sort(u);
		// 가장 싼 6개짜리 팩 구매 vs 낱개 구매
		int temp = Math.min(((n/6)+1)*p[0] , n*u[0]);
		// temp vs 팩 + 낱개
		int answer = Math.min(temp, (n/6)*p[0] + (n%6) * u[0]);
		System.out.println(answer);
	}
}
