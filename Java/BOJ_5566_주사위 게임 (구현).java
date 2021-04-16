package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5566 {
	// BOJ / 5566번 / 주사위 게임 / 구현 / 브론즈2
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // 지시사항 
		int m = Integer.parseInt(stk.nextToken()); // 주사위
		int [] dir = new int[n+1];
		int [] dice = new int [m];
		
		for(int i=1; i<dir.length; i++) {
			dir[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<m; i++) {
			dice[i] = Integer.parseInt(br.readLine());
		}
		int board[] = new int[2001];
		int t = 1001;
		n += 1000;

		int cnt = 0;
		for(int i=0; i<dice.length; i++) {
			cnt++;
			t-=1000;
			int p = dice[i]; // 주사위 먼저 던진다.
			t += p; // 주사위 만큼 이동 
			if(t+1000 >= n) break; // 이동하자마자 넘어갈수도있음 
			t += dir[t]; // 주사위로 이동한 위치의 지시를 따름 
			t+=1000;
			if( t >= n) break;
		}
		System.out.println(cnt);
	}
}
