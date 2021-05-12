package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2559 {
	// BOJ / 2559번 / 수열 / 투 포인터 / 실버3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		int arr[] = new int[n];
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++ ) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=0; i<n; i++) {
			// 초반 k-1범위 전까지는 sum을 max랑 비교하면안됨.
			if(i == k-1) flag = true;
			if(i >= k) {
				sum-= arr[i-k];
			}
			sum += arr[i];
			
			if(max < sum && flag) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
