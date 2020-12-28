package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403 {
	//BOJ / 11403번 / 경로 찾기 / 그래프 / 실1
	static int [][] map;
	static int n;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		print();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(map[i][j] == 1) { // 1인곳 다 찾아서 q에 넣어주기.
					q.offer(j);
				}
			}
			while(!q.isEmpty()) {
				int now = q.poll();
				
				map[i][now] = 1;
				for(int k=1; k<=n; k++) { 
					if(map[now][k] == 1 && map[i][k] != 1) { // map[now][k] 요것이 포인트
						q.offer(k);
					}
				}
			}
		}
	}
	
	public static void print() {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
