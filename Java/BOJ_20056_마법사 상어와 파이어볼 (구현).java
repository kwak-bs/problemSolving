package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20056 {
	// BOJ / 20056번 / 마법사 상어와 파이어볼 / 구현 / 골드5
	static LinkedList<FireBall> map[][];
	static int N,M,K;
	static int dr[] = {-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		map = new LinkedList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int r = Integer.parseInt(stk.nextToken())-1;
			int c = Integer.parseInt(stk.nextToken())-1;
			int m = Integer.parseInt(stk.nextToken());
			int s = Integer.parseInt(stk.nextToken());
			int d = Integer.parseInt(stk.nextToken());
			
			map[r][c].add(new FireBall(m,s,d));
		}
		
		while(K-- > 0) {
			move();
		}
		System.out.println(sum());
	}
	
	public static void move() {
		LinkedList<FireBall> next[][] = new LinkedList[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				next[i][j] = new LinkedList<>();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() >= 1) {
					for(FireBall fb : map[i][j]) {
						int dir = fb.d;
						int speed = fb.s % N;
						int r = i + dr[dir] * speed;
						int c = j + dc[dir] * speed;
						
						if(r >= N) r -= N;
						else if(r < 0) r+=N;
						
						if(c >= N) c -= N;
						else if(c < 0) c+=N;
						next[r][c].add(new FireBall(fb.m, fb.s,fb.d));
					}
				}
			}
		}
		map = next;
		split();
	}
	
	public static void split() {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() >= 2) {
					int m = 0;
					int s = 0;
					boolean even = true;
					boolean odd = true;
					for(FireBall fb : map[i][j]) {
						m += fb.m;
						s += fb.s;
						if(fb.d % 2 == 0) odd = false;
						else even = false;
					}
					m /= 5;
					s /= map[i][j].size();
					map[i][j].clear();
					
					if(m > 0) {
						for(int k=0; k<4; k++) {
							if(even || odd) {
								map[i][j].add(new FireBall(m,s, k * 2));
							}
							else {
								map[i][j].add(new FireBall(m,s,(k * 2)+1));
							}
						}
					}
				}
			}
		}
	}
	
	public static int sum() {
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].size() >= 1) {
					for(FireBall fb : map[i][j]) {
						answer += fb.m;
					}
				}
			}
		}
		
		return answer;
	}
	
	
	private static class FireBall {
		int m,s,d;
		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
}
