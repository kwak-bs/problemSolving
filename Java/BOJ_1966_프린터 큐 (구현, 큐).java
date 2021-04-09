package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966 {
	// BOJ / 1966번 / 프린터 큐 / 큐 / 실버3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		StringBuffer sb = new StringBuffer();
		while(t-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int p[] = new int[n];
			

			Queue<int[]> q = new LinkedList<>();
			stk = new StringTokenizer(br.readLine(), " ");
				
			for(int i=0; i<n; i++) {
				p[i] = Integer.parseInt(stk.nextToken());

				q.add(new int[] {i, p[i]});
			}	
			int ans = 0;
			while(!q.isEmpty()) {
				int now[] = q.poll();
				boolean isMax = true;
				// 남아 있는 q를 탐색 
				for(int[] arr : q) {
					// 현재 뽑은 최댓값과 남아 있는 우선 순위에 최댓값 비교
					if(arr[1] > now[1]) {
						isMax = false;
					}
				}
				// 현재 뽑은게 최댓값이면
				if(isMax) {
					ans++;
					// 현재 뽑은 인덱스가 m이면
					if(now[0] == m) {
						sb.append(ans).append("\n");
						break;
					}
				}
				// 최댓값이 아니면 다시 넣어줌
				else {
					q.add(now);
				}
			}
		}
		System.out.println(sb.toString());
	}
}
