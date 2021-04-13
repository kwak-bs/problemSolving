package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_2210 {
	// BOJ / 2210번 / 숫자판 점프 / 브루트포스 / 실버2
	static Set<String> set = new HashSet<>();
	static int b[][];
	static int dy[] = {1,-1,0,0};
	static int dx[] = {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk;
		b = new int[5][5];
		
		for(int i=0; i<5; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<5; j++) {
				b[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				go(i,j, b[i][j]+"");

			}
		}
		
		System.out.println(set.size());
	}
	
	public static void go(int r, int c, String s) {
		
		if (s.length() == 6) {
			set.add(s);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int ny = r + dy[i];
			int nx = c + dx[i];
			
			if(ny >=0 && ny <5 & nx >=0 && nx < 5) {
				go(ny,nx,s+b[ny][nx]);
			}
		}
		
	}
}
