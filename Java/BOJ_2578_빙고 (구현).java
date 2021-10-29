package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	// BOJ / 2578번 / 빙고 / 구현 / 실버5
	
	static int map[][],count = 0;
	public static void main(String[] args) throws IOException {
		
		map = new int[5][5];
		StringTokenizer stk;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j<5; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		loop:
		for(int i=0; i<5; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				int target = Integer.parseInt(stk.nextToken());
				checkTarget(target);
				count++;
				if(checkBingo(target)) {
					break loop;
				}
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean checkBingo(int target) {
		int bingo = 0;
		boolean isBingo = true;
		// 가로
		for(int i=0; i<5; i++) {
			isBingo = true;
			for(int j=0; j<5; j++) {
				if(map[i][j] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) {
				bingo++;
				if(bingo == 3) {
					return true;
				}
			}
		}
		
		// 세로
		for(int i=0; i<5; i++) {
			isBingo = true;
			for(int j=0; j<5; j++) {
				if(map[j][i] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) {
				bingo++;
				if(bingo == 3) {
					return true;
				}
			}
		}
		
		// 좌측 대각선
		isBingo = true;
		for(int i=0; i<5; i++) {
			if(map[i][i] != 0) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) {
			bingo++;
			if(bingo == 3) {
				return true;
			}
		}

		// 우측 대각선
		isBingo = true;
		for(int i=4; i>=0; i--) {
			if(map[i][4-i] != 0) {
				isBingo = false;
				break;
			}
		}
		if(isBingo) {
			bingo++;
			if(bingo == 3) {
				return true;
			}
		}
		return false;
	}
	
	public static void checkTarget(int target) {
		
		for(int i=0; i<5; i++) {
			for(int j =0; j<5; j++) {
				if(map[i][j] == target) {
					map[i][j] = 0;
					return;
				}
			}
		}
	}
}
