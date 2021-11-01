package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14620 {
	// BOJ / 14620�� / �ɱ� / ����Ž�� / �ǹ�2
	static int map[][],n;
	static boolean v[][];
	static int answer = Integer.MAX_VALUE;
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new boolean[n][n];
		StringTokenizer stk;
		for(int i=0; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		// 1.�� ��ǥ���� ���� ����� �ִ��� �Ǵ�.
		// 2. ���� ����� ������ �湮 üũ 
		// 3. dfs Ž�� 
		// 4. Ž�� �Ŀ��� �ѹ�
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(makeFlower(i,j) && !v[i][j]) {
					checkFlower(i, j);
					go(i,j,1);
					rollbackFlower(i,j);
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void go(int r, int c, int count) {
		if(count == 3) {
			int currentWeight = getWeight();
			answer = Math.min(answer, currentWeight);
			return;
		}
		// i�� j�� 0 ���� �����ؾ��� 
		// r c�� �����ϴϱ� Ʋ��
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(makeFlower(i,j) && !v[i][j]) {
					checkFlower(i,j);
					go(i,j,count+1);
					rollbackFlower(i,j);
				}
			}
		}
	}
	// ��Ʈ��ŷ
	public static void rollbackFlower(int r, int c) {
		v[r][c] = false;
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = false;
		}
	}
	// ��� ���ϱ� 
	public static int getWeight() {
		int weight = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(v[i][j]) {
					weight += map[i][j];
				}
			}
		}
		
		return weight;
	}
	// ���� ���� ���� üũ 
	public static void checkFlower(int r, int c) {
		v[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			v[nr][nc] = true;
		}
	}
	// ���� ������ִ��� �Ǵ�.
	public static boolean makeFlower(int r, int c) {
		
		for(int i=0; i<4; i++) {
			int nr = dr[i] + r;
			int nc = dc[i] + c;
			if(nr < 0 || nc < 0 || nr >= n || nc >= n) {
				return false;
			}	
			else if(v[nr][nc]) return false;
		}
		return true;
	}
}
