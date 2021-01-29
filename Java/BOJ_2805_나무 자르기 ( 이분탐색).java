package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
	// BOJ / 2805번 / 나무 자르기 / 이분 탐색/ 실3
	
	static long n,m;
	static long tree[];
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Long.parseLong(stk.nextToken()); // 나무 수
		m = Long.parseLong(stk.nextToken()); // 집으로 가져가려고 하는 나무 길이
		
		tree = new long [(int) n];
		stk = new StringTokenizer(br.readLine(), " ");
		long max = 0;
		for(int i=0; i<n; i++) {
			tree[i] = Long.parseLong(stk.nextToken());
			
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		

		long start = 1;
		long end = max;
		long ans = 0; 

		while (start <= end) {
			long mid = (start + end) / 2;

			
			if(check(mid, tree) ) {
				ans = Math.max(ans, mid);
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
	
	public static boolean check(long mid, long arr[]) {
		
		long len = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] >= mid) {
				// 높이만큼 나무를 잘라낸다. 잘라낸 나무의 길이를 더한다.
				len += (arr[i] - mid);				
			}
		}

		return len >= m;
	}
}
