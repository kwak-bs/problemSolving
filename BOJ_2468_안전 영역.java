package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468 {
	// BOJ / 2468번 / 안전 영역 / 브루트포스, 그래프 / 실1
	
	static int [][] map;
	static boolean [][] isFlood;
	static int l;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// length 입력
		l = Integer.parseInt(br.readLine());
		
		map = new int[l][l];
		isFlood = new boolean[l][l];
		int safe = 0;
		int maxResult = 0;
		
		// map 입력
		for(int i =0; i<l; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<l; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 최대 높이값 찾기
		int maxHeight = 0 ;
		for(int i =0; i<l; i++) {
			for(int j=0; j<l; j++) {
				if(map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}
			}
		}

		//i가 내린 비의 양이다.
		for(int i=0; i<=maxHeight; i++) {
			checkFlood(i);
			for(int j=0; j<l; j++) {
				for(int k=0; k<l; k++) {
					if(!isFlood[j][k]) { // 물에 잠기지 않았으면 dfs 돌린다.
						dfs(j,k);
						safe++; // 안전지대별로 count++
					}
				}
			}
			
			if(safe > maxResult) { // 최대값 변환
				maxResult = safe;
			}

			safe = 0; // count 초기화
			isFlood = new boolean[l][l]; // isFlood 초기화
		}
		System.out.println(maxResult);
	}
	
	// 각 장마의 높이 별로(모든 구간, 브루트 포스) 잠기는 곳을 check후 true로 변환한다.
	public static void checkFlood (int floodHeight ) {
		for(int i=0; i<l; i++) {
			for(int j=0; j<l; j++) {
				if(map[i][j] <= floodHeight) {						
					isFlood[i][j] = true;
				}
			}			
		}
	}
	
	public static void dfs(int y, int x) {
		isFlood[y][x] = true;

		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(nx >= 0 && nx < l && ny >= 0 && ny < l) {
				if(!isFlood[ny][nx]) {
					dfs(ny,nx);
				}
			}
		}
	}
}
