package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15662 {
	// BOJ / 15662번 / 톱니바퀴(2) / 구현 / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		
		int a[][] = new int[t][8];

		for(int i=0; i<t; i++) {
			String s = br.readLine();
			for(int j=0; j<8; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		StringTokenizer stk;

		while(k-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(stk.nextToken()) - 1;
			
			int dir = Integer.parseInt(stk.nextToken());
			// 톱니의 방향 저장. 1=시계, -1=반시계, 0= 회전 안함
			int[] d = new int[t];
			d[n] = dir;
			// 왼쪽 톱니 연쇄적으로 조사
			for(int i=n-1; i>=0; i--) {
				if(a[i][2] != a[i+1][6]) {
					d[i] = -d[i+1];
				}
				else {
					// 같으면 회전x 이므로, 연쇄적으로 회전 안한다.
					break;
				}
			}
			
			// 오른쪽 톱니 연쇄적으로 조사
			for(int i=n+1; i<t; i++) {
				if(a[i][6] != a[i-1][2]) {
					d[i] = -d[i-1];
				}
				else {
					break;
				}
			}
			
			for(int i=0; i<t; i++) {
				
				if(d[i] == 0) continue;
				
				// 시계 방향 회전
				if(d[i] == 1) {
					int temp = a[i][7];
					
					for(int j=7; j>=1; j--) {
						a[i][j] = a[i][j-1];
					}
					
					a[i][0] = temp;
				}
				
				// 반시계 방향 회전
				if(d[i] == -1) {
					int temp = a[i][0];
					
					for(int j=0; j<7; j++) {
						a[i][j] = a[i][j+1];
					}
					
					a[i][7] = temp;
				}
			}
		}
		int ans = 0;
		for(int i=0; i<t; i++) {
			if(a[i][0] == 1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
