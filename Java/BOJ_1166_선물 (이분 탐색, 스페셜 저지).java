package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166 {
	// BOJ / 1166번 / 선물 / 이분 탐색 / 실버3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		long n = Integer.parseInt(stk.nextToken());
		long l = Integer.parseInt(stk.nextToken());
		long w = Integer.parseInt(stk.nextToken());
		long h = Integer.parseInt(stk.nextToken());
		
		double left = 0;
		// 정사각형의 한 변은 직사각형의 가장 작은 변보다 클 수 없다. 
		double right = Math.min(l, Math.min(w, h));
		double answer = Double.MIN_VALUE;
		
		// 대충 50000번 안에는 될 것이라 판단하고 테스트해봤는데 통과됐다.
		int time = 50000;
		
		while(time-- > 0) {
			// mid는 정사각형의 한 변 
			double mid = (left + right) / 2;
			
			long total = (long)(l / mid) * (long)(w / mid) * (long)(h / mid);
			
			// 정사각형의 갯수가 n보다 많거나 같으면 left = mid이다. 
			// mid의 자료형이 int가 아닌 double형이라 일반적인 +1,-1을 할 수 없고 while문의 제한 또한 함부로 걸어줄 수 없다. 
			if(total >= n) {
				left = mid;
				answer = Math.max(mid, answer);
			}
			else {
				right = mid;
			}
		}
		System.out.println(answer);
	}
}
