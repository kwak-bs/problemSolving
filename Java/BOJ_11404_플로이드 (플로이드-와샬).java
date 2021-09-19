package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404 {
	// BOJ / 11404�� / �÷��̵�- �ͼ�   / �÷��̵�
	static int map[][];
	static final int INF = 99999999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				else map[i][j] = INF;
			}
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			// ���� ���ÿ� ���� ���ø� �����ϴ� �뼱�� ���� ���� Ȯ���� ����Ͽ� �ּڰ� ����.
			map[s][e]= Math.min(w, map[s][e]); 
		}
		
		floydWarshall(n);
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] == INF) {
					sb.append("0 ");
				}
				else sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void floydWarshall(int n) {
		
		for(int k=1; k<=n; k++) { // ������ 
			for(int i=1; i<=n; i++) { // �����
				if(i==k) continue;
				for(int j=1; j<=n; j++) { // ������ 
					if(i==j || j==k) continue;
					if(map[i][j] > map[i][k]+ map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
				
		}
	}

}
