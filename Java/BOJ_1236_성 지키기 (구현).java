package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1236 {
	// BOJ / 1236�� / �� ��Ű�� / ���� / �����1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		char [][] map = new char[n][m];
		// �Է�
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int row = 0;
		int col = 0;
		// ��
		for(int i=0; i<n; i++) {
			boolean flag = true;
			for(int j=0; j<m; j++) {
				if(map[i][j] == 'X') {
					flag = false;
					break;
				}
			}
			if(flag) row++;
		}
		
		// ��
		for(int i=0; i<m; i++) {
			boolean flag = true;
			for(int j=0; j<n; j++) {
				if(map[j][i] == 'X') {
					flag = false;
					break;
				}
			}
			if(flag) col++;
		}
		// ��� ���� ū ���� �ʿ��� �ּ� ���� ���̴�.
		int answer = Math.max(row, col);
		System.out.println(answer);
	}
}
