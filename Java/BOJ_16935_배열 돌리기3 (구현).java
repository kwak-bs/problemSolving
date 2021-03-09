package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {
	// BOJ / 16935번 / 배열 돌리기 3 / 구현 / 실버3
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int y = Integer.parseInt(stk.nextToken());
		int x = Integer.parseInt(stk.nextToken());
		int r = Integer.parseInt(stk.nextToken());
		
		int map[][] = new int[y][x];

		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		while(r-- > 0) {
			int op = Integer.parseInt(stk.nextToken());			
			if(op == 1) {
				map = op1(map);
			}
			else if(op == 2) {
				map =op2(map);
			}
			else if(op == 3) {
				map = op3(map);
			}
			else if(op == 4) {
				map = op4(map);
			}
			else if(op == 5) {
				map = op5(map);
			}
			else if(op == 6) {
				map = op6(map);
			}			
		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	// 상하 반전 
	public static int[][] op1(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[y][x];
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				temp[i][j] = map[y-1-i][j];
			}
		}
		
		return temp;
	}
	// 좌우 반전 
	public static int[][] op2(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[y][x];
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				temp[i][j] = map[i][x-1-j];
			}
		}
		
		return temp;
	}
	
	// 오른쪽 90도
	public static int[][] op3(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[x][y];
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j] = map[y-1-j][i];
			}
		}
		
		return temp;
	}
	
	// 왼쪽 90도
	public static int[][] op4(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[x][y];
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				temp[i][j] = map[j][x-1-i];
			}
		}
		
		return temp;
	}
	
	// 5번 연산, 1->2 , 2->3, 3->4, 4->1
	public static int[][] op5(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[y][x];
		// 1 -> 2
		for(int i=0; i<y/2; i++) {
			for(int j=0; j<x/2; j++) {
				temp[i][j+ x/2] = map[i][j];
			}
		}
		
		// 2-> 3
		for(int i=y/2; i<y; i++) {
			for(int j=x/2; j<x; j++) {
				temp[i][j] = map[i-y/2][j];
			}
		}
		
		// 3 -> 4
		for(int i=y/2; i<y; i++) {
			for(int j=0; j<x/2; j++) {
				temp[i][j] = map[i][j+x/2];
			}
		}
		
		// 4 -> 1 
		for(int i=0; i<y/2; i++) {
			for(int j=0; j<x/2; j++) {
				temp[i][j] = map[i+y/2][j];
			}
		}
		return temp;
	}
	
	// 6번 연산
	public static int[][] op6(int map[][]) {
		int y = map.length;
		int x = map[0].length;
		int temp[][] = new int[y][x];
		// 1 -> 4
		for(int i=y/2; i<y; i++) {
			for(int j=0; j<x/2; j++) {
				temp[i][j] = map[i - y/2][j];
			}
		}
		
		// 4 -> 3
		for(int i=y/2; i<y; i++) {
			for(int j=x/2; j<x; j++) {
				temp[i][j] = map[i][j-x/2];
			}
		}
		
		// 3 -> 2
		for(int i=0; i<y/2; i++) {
			for(int j=x/2; j<x; j++) {
				temp[i][j] = map[i+y/2][j];
			}
		}
		
		// 2 -> 1 
		for(int i=0; i<y/2; i++) {
			for(int j=0; j<x/2; j++) {
				temp[i][j] = map[i][j+x/2];
			}
		}
		return temp;
	}
}
