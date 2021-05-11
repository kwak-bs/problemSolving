package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10025 {
	// BOJ / 10025번 / 게으른 백곰 / 슬라이딩 윈도우 / 실버4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int arr[] = new int[1000001];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int w = Integer.parseInt(stk.nextToken());
			int p = Integer.parseInt(stk.nextToken());
			
			arr[p] = w; 
		}
		int sum = 0;
		int max = 0;
		int d = 1 +(2*k);
		for(int i=0; i<=1000000; i++) {
			if(i >= d) {
				sum -= arr[i-d];
			}
			sum += arr[i];
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
