package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2531 {
	// BOJ / 2531번 / 회전 초밥 / 슬라이딩 윈도우 / 실버1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		// 접시의 수
		int n = Integer.parseInt(stk.nextToken());
		// 초밥의 가짓 수
		int d = Integer.parseInt(stk.nextToken());
		// 연속해서 먹는 접시의 수 
		int k = Integer.parseInt(stk.nextToken());
		// 쿠폰 번호
		int c = Integer.parseInt(stk.nextToken());
		int v[] = new int[d+1];
		int arr[] = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 가짓수
		int total = 0;
		for(int i=0; i<k; i++) {
			if(v[arr[i]] == 0) total++;
			v[arr[i]]++;
		}
		// 최대 가짓수 초기화
		int max = total;
		for(int i=1; i<n; i++) {
			if(max <= total) {
				if(v[c] == 0) max = total + 1;
				else max = total;
			}
			// 슬라이딩 윈도우(길이는 고정적)
			// 가장 최근에 먹은 것은 제외 현재 먹을 것은 추가
			v[arr[i-1]]--;
			if(v[arr[i-1]] == 0) total--;
			
			if(v[arr[(i+k-1)%n]] == 0) total++;
			v[arr[(i+k-1)%n]]++;
		}
		System.out.println(max);
	}
}
