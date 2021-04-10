package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	// BOJ / 1074번 / Z / 분할 정복 / 실버1
	static int r,c,count;
	static int dy[] = {0,0,1,1};
	static int dx[] = {0,1,0,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = (int)Math.pow(2, Integer.parseInt(stk.nextToken()));
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		go(n, 0, 0);
	}
	
	public static void go(int num, int row, int col) {
		
		if(row == r && col == c) {
			System.out.println(count);
			System.exit(0);
		}
		// 찾으려는 좌표가 4등분한 범위 내에 있으면 그 부분을 또 4등분하여 찾는다. 
		if(row <= r && r <(row + num) && col <= c && c < (col+num)) {
			go(num/2, row,col); // 좌측 상단 
			go(num/2, row, col+num/2); // 우측 상단 
			go(num/2, row+num/2, col); // 좌측 하단 
			go(num/2, row+num/2, col+num/2); // 우측 하단 			
		}
		// 4등분한 범위 내에 없으면 그 범위는 무조건 지나가는 것이므로 그 부분의 모든 횟수를 더한다. 
		else count += num*num;
	}
}
