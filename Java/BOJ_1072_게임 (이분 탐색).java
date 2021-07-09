package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {
	// BOJ / 1072번 / 게임 / 이분 탐색 / 실버3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		long x = Integer.parseInt(stk.nextToken());
		long y = Integer.parseInt(stk.nextToken());
		
		long z = y*100 / x;
		// 승률이 99이상이면 아무리 게임을 더해도 확률이 변하지 않음.
		if(z >= 99) {
			System.out.println("-1");
		}
		else {
			long left = 1;
			long right = x; // x번 까지 다 돌면 확률은 무조건 증가임 
			while(left <= right) {
				// mid는 게임 횟수
				long mid = (left + right) / 2;
				long zz = (y+mid)*100/ (x+mid) ;
				if(zz > z) {
					right = mid - 1;
				}
				
				else {
					left = mid + 1;
				}
			}
			// zz가 같거나 작으면 left를 증가. 최종적으로 감소된 mid(게임 횟수)에서 +1 하면됨. 
			System.out.println(left);			
		}
	}
}
