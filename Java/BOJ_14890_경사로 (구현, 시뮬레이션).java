package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14890 {
	// BOJ / 14890번 / 경사로 / 구현 / 골드3
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		
		int map[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int ans = 0;
		// 행 검사
		for(int i=0; i<n; i++) {
			int r[] = new int[n];
			
			for(int j=0; j<n; j++) {
				r[j] = map[i][j];
			}
			if(go(r, l)) ans++;
		}
		
		//열 검사
		for(int i=0; i<n; i++) {
			int c[] = new int[n];
			
			for(int j=0; j<n; j++) {
				c[j] = map[j][i];
			}
			if(go(c,l)) ans++;
		}
		System.out.println(ans);
	}
	
	public static boolean go(int a[], int l) {
		// 한 줄 검사
		int n = a.length;
		boolean c [] = new boolean[n];
		for(int i=1; i<n; i++) {
			// 인접한 칸의 높이가 다르면, 경사로를 높는다.
			if(a[i-1] != a[i]) {
				int diff = a[i]-a[i-1];
				if(diff < 0) diff = -diff;
				// 낮은 칸과 높은 칸의 차이는 1이어야 한다.
				if(diff != 1) return false;
				
				// 왼쪽 부터 검사
				if(a[i-1] < a[i]) {
					for(int j=1; j<=l; j++) {
						// 경사로를 놓다가 범위를 벗어나는 경우
						if(i-j < 0) return false;

						// 낮은 지점의 칸의 높이가 모두 가지 않거나, 
						// L개가 연속되지 않은 경우
						if(a[i-1] != a[i-j]) return false;
						
						// 경사로를 이미 놓은 경우
						if(c[i-j]) return false;
						
						c[i-j] = true;
					}
				}
				// 오른쪽 부터 검사 a[i-1] > a[i]
				else {
					for(int j=0; j<l; j++) {
						if(i+j >= n) return false;
						
						if(a[i] != a[i+j]) return false;
						
						if(c[i+j]) return false;
						
						c[i+j] = true;
					}
				}
			}
		}
		return true;
	}
}
