package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
	// BOJ / 2110번 / 공유기 설치 / 이분 탐색 / 실버1
	
	static int n,c;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		int wifi[] = new int [n];
		
		for(int i=0; i<n; i++) {
			wifi[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(wifi);
		
		int start = 1; // 가능한 최소 거리 (거리는 무조건 1이상 차이남)
		int end = wifi[n-1] - wifi[0]; // 가능한 최대 거리
		int ans = 0;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(check(mid, wifi)) {
				ans = Math.max(ans, mid);
				start = mid + 1 ;
			} else {
				end = mid - 1;
			}
 		}
		
		System.out.println(ans);
	}
	
	public static boolean check(int dis, int arr[]) {
		int count = 1;
		
		int next = arr[0] + dis; // 첫 번째 집의 다음 집.
		
		for(int i=0; i<n; i++) {
			if(arr[i] >= next) {
				count++;
				next = arr[i] + dis; // 다음 집이 존재하면 count++ 후 그 다음 집으로 이동.
			}
		}
		
		return count >= c;
	}
}
