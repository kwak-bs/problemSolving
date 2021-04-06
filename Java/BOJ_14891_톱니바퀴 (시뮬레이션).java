package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891 {
	// BOJ / 14891번 / 톱니바퀴 / 시뮬레이션 / 골드5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a[][] = new int[4][8];

		for(int i=0; i<a.length; i++) {
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
			int d = Integer.parseInt(stk.nextToken()); // 1:시계, -1:반시계
			
			// 1 시계 , -1 반시계, 0 회전x
			int turn[] = new int[4];
			turn[n] = d;
			
			// 왼쪽 회전 연쇄 조사
			for(int i=n; i>=1; i--) {
				// 다르면
				if(a[i][6] != a[i-1][2] ) {
					turn[i-1] = -turn[i];
				}
				else break;
			}
			
			// 오른쪽 회전 연쇄 조사
			for(int i=n; i<=2; i++) {
				// 다르면
				if(a[i][2] != a[i+1][6] ) {
					turn[i+1] = -turn[i];
				}
				else break;
			}
			
			// 톱니바퀴 회전 
			for(int i=0; i<4; i++) {
				switch(turn[i]) {
				
				case 0 : continue;
				// 시계
				case 1 : 
					int temp = a[i][7];
					for(int j=7; j>=1; j--) {
						a[i][j] = a[i][j-1];  
					}
					a[i][0] = temp; 
					break;
				// 반시계
				case -1 :
					int tmp = a[i][0];
					for(int j=0; j<7; j++) {
						a[i][j] = a[i][j+1];
					}
					a[i][7] = tmp;
					break;
				}
			}
		}
		int sum = 0;
		// 점수의 합 계산 
		for(int i=0; i<4; i++) {
			if(i == 0 && a[i][0] == 1) {
				sum++;
			}			
			else if(i == 1 && a[i][0] == 1) {
				sum+=2;
			}
			else if(i == 2 && a[i][0] == 1) {
				sum+=4;
			}
			else if(i == 3 && a[i][0] == 1) {
				sum+=8;
			}
		}
		System.out.println(sum);
	}
}
