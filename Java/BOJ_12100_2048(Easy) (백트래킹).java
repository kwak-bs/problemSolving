package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12100 {
	// BOJ / 12100¹ø / 2048(Easy) / ½Ã¹Ä·¹ÀÌ¼Ç / °ñµå2
	static int n, map[][], answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		game(0);
		
		System.out.println(answer);
	}
	
	public static void game(int depth) {
		
		if(depth == 5) {
			findMax();
			return;
		}

        int copy[][] = new int[n][n];
        copy(copy);
		// »ó ÇÏ ÁÂ ¿ì 
		for(int i=0; i<4; i++) {
			move(i);
			game(depth + 1);
			back(copy);
		}
	}
	
	public static void move(int dir) {
		
		switch(dir) {
		// »ó
		case 0 :
			for(int j=0; j<n; j++) {
				int index = 0;
				int block = 0;
				for(int i=0; i<n; i++) {
					if(map[i][j] != 0 ) {
						
						if(block == map[i][j]) {
							map[index-1][j] = block * 2;
							block = 0; 
							map[i][j] = 0;
						}
						
						else {
							block = map[i][j];
							map[i][j] = 0;
							map[index][j] = block;
							index++;
						}
					}
				}
			}
			break;
			// ÇÏ
			case 1 :
				for(int j=0; j<n; j++) {
					int index = n-1;
					int block = 0;
					for(int i=n-1; i>=0; i--) {
						if(map[i][j] != 0 ) {
							if(block == map[i][j]) {
								map[index+1][j] = block * 2;
								block = 0; 
								map[i][j] = 0;
							}
							else {
								block = map[i][j];
								map[i][j] = 0;
								map[index][j] = block;
								index--;
							}
						}
					}
				}
				break;
			// ÁÂ
			case 2 :
				for(int i=0; i<n; i++) {
					int index = 0;
					int block = 0;
					for(int j=0; j<n; j++) {
						if(map[i][j] != 0 ) {
							if(block == map[i][j]) {
								map[i][index-1] = block * 2;
								block = 0; 
								map[i][j] = 0;
							}
							else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][index] = block;
								index++;
							}
						}
					}
				}
				break;
			// ¿ì
			case 3 :
				for(int i=0; i<n; i++) {
					int index = n-1;
					int block = 0;
					for(int j=n-1; j>=0; j--) {
						if(map[i][j] != 0 ) {
							if(block == map[i][j]) {
								map[i][index+1] = block * 2;
								block = 0; 
								map[i][j] = 0;
							}
							
							else {
								block = map[i][j];
								map[i][j] = 0;
								map[i][index] = block;
								index--;
							}
						}
					}
				}
				break;
		}
	}
	
	public static void back(int[][] copy) {
		for(int i=0; i<n; i++) {
			map[i] = copy[i].clone();
		}
	}
	
	public static void copy(int[][] copy) {
		for(int i=0; i<n; i++) {
			copy[i] = map[i].clone();
		}
	}
	
	public static void findMax() {	
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
	}
}
