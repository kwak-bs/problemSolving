package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055 {
	// BOJ / 20055번 / 컨베이어 벨트 위의 로봇 / 구현, 시뮬레이션 / 실버2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		
		int a[] = new int[2*n];
		int r[] = new int[2*n];
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<a.length; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		int zero = 0;
		int ans = 0;
		while(true) {
			ans++;
			// 1. 벨트 한칸 회전
			rotate(a);
			rotate(r); // 로봇 유무 배열도 회전 
			
			// 내려가는 위치에 있으면 로봇 삭제
			if(r[n-1] == 1) {
				r[n-1] = 0;
			}
			
			// 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 이동 안되면 가만 있는다.
			// 마지막 배열은 n-1 이니 n-2부터 탐색한다.
			for(int i=n-2; i>=0; i--) {		
				// 로봇이 있으면 
				if(r[i] == 1) {
					// 다음 칸에 로봇이 없고 내구도가 1이상이면
					if(r[i+1] == 0 && a[i+1] >= 1) {
						r[i+1] = 1;
						a[i+1]--;
						r[i] = 0;
						
						// 중요포인트! 내구도가 0이 된 경우는 바로바로 체크해줘야한다. 
						// 처음에 모든 과정을 다 거치고 내구도 0인 경우를 한번에 처리해줬다가 애먹음.
						if(a[i+1] == 0) {
							zero++;
						}
					}
				}
			}
			// 내려가는 위치에 있으면 로봇 삭제
			if(r[n-1] == 1) {
				r[n-1] = 0;
			}
			
			// 3. 올라가는 위치에 로봇이 없다면 로봇을 하나 올린다.
			if(a[0] > 0) {
				r[0] = 1;
				a[0]--;
				
				if(a[0] == 0) {
					zero++;
				}
			}
			
			// 4. 내구도 체크
			if(zero >= k) {
				System.out.println(ans);
				break;
			}
		}
	}
	
	public static void rotate(int[] a) {
		int temp = a[a.length-1];
		
		for(int i=a.length-1; i>0; i--) {
			a[i] = a[i-1];
		}
		a[0] = temp;
	}
}
