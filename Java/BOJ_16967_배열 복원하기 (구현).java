package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16967 {
	// BOJ / 16967번 / 배열 복원하기 / 구현, 시뮬레이션 / 실버3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int h = Integer.parseInt(stk.nextToken());
		int w = Integer.parseInt(stk.nextToken());
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		
		int b[][] = new int[h+y][w+x];
		
		for(int i=0; i<b.length; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<b[0].length; j++) {
				b[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		int temp[][] = new int[h+y][w+x];
		
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[0].length; j++) {
				temp[i][j] = -1;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				// 두 배열에 다 포함되면 
				if(i >= y  && j >= x) {
					temp[i][j] = b[i][j] - temp[i-y][j-x];
				}
				
				// 기존 배열에만 포함되면
				if(temp[i][j] == -1 && i< h && j < w) {
					temp[i][j] = b[i][j];					
				}
				
				sb.append(temp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
