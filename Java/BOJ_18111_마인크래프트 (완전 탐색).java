package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
	// BOJ / 18111번 / 마인크래프트 / 완전 탐색  / 실버2
	static int min = Integer.MAX_VALUE;
	static int minLow = Integer.MAX_VALUE;
	static int low, high;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		low = 256;
		high = 0;
		int map[][] = new int[n][m];
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(low > map[i][j]) low = map[i][j];
				if(high < map[i][j]) high = map[i][j];
			}
		}
		

		while(low <= high) {
			int temp[][] = map;
			int B = b;
			int time = 0;
			loop:
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(temp[i][j] != low) {
						// 블록 제거
						if(temp[i][j] > low) {
							int block = temp[i][j] - low;
							// 인벤토리 추가 
							B += block;
							// 블록당 걸리는 시간 
							time += (2*block);
						}
						// 블록 쌓기
						else if(temp[i][j] < low) {
							int block = low - temp[i][j];
							// 인벤토리 제거 
							B -= block;
							// 블록당 걸리는 시간
							time += (1*block);
						}
					}
				}
			}
			if(min >= time && B >= 0) {
				min = time;
				if(minLow > low && minLow != Integer.MAX_VALUE) continue;
				minLow = low;
			}
			low++;
		}
		System.out.println(min+" " + minLow);
	}
}
