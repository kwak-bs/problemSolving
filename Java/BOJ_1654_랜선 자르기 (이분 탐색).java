package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
	// BOJ / 1654번 / 랜선 자르기 / 이분 탐색 / 실3
	
	static long line[];
	static int n,k;
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		k = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		
		line = new long [k]; 
		
		long max = 0;
		
		for(int i=0; i<k; i++) {
			line[i] = Long.parseLong(br.readLine());
			if(max < line[i]) {
				max = line[i];
			}
		}
		
		long start = 1; // 0이면 런타임 에러 (/by Zero 발생)
		long end = max;
		long ans = 0;
		
		// 이분 탐색을 통하여 mid 값을 구한다. 
		while(start <= end) {
			long mid = (start + end) / 2;
			
			if(check(mid, line)) {
				// count가 k 값이 나와도 mid의 최댓값을 찾기위해 while문은 계속 돎.
				ans = Math.max(ans, mid);
				start = mid + 1;
			} 
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	// mid로 잘라낸 갯수를 확인한다.
	public static boolean check(long mid, long[] arr) {
		int count = 0;
		
		for(int i=0; i<k; i++) {
			count += arr[i] / mid;
		}
		
		return count >= n;
	}
}
