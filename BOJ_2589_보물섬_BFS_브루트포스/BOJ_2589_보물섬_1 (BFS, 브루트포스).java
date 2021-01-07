package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589 {
	// BOJ / 2589번 / 보물섬 / 그래프, 브루트포스 / 골5
	
	static char [][] map;
	static char [][] copy;
	static int [][] count;
	static int y, x, result;
	static int [] dy = {1,-1,0,0}; //상하
	static int [] dx = {0,0,1,-1}; //좌우
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		
		map = new char[y][x];
		copy = new char[y][x];
		count = new int[y][x];
		
		// map 입력
		for(int i=0; i<y; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// map 복사
		copyMap();
		
		//복사한 맵으로 브루투포스시작.
		bf();
		
		System.out.println(result);
	}
	
	// copymap
	public static void copyMap() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	// 브루트 포스로 전 구간 탐색
	public static void bf() {
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(copy[i][j] == 'L') {
					//L 구간 bfs
					bfs(i,j);
					
					// bfs한 count맵의 최대값 구하기
					int temp = countMax();

					// temp 별 최댓값 비교 
					if(result < temp) {
						result = temp;
					}
					
					copyMap(); //초기화
					count = new int[y][x]; // 초기화
				}
			}
		}
	}
	
	// 각 'L' 구간마다 bfs 돌아서 hour 값을 도출한다. 
	public static void bfs(int yy, int xx) {
		Queue<int []> q = new LinkedList<>();
		int hour = 0;
		
		q.offer(new int[] {yy,xx, 0});
		copy[yy][xx] = 'W'; // 재방문 하지 않기 위해 W로 바꿔줌 
		
		while(!q.isEmpty()) {
			int [] now = q.poll();
			hour= now[2];
			
			for(int i=0; i<4; i++) {
				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];
				
				if(ny>= 0 && ny <y && nx >= 0 && nx < x ) {
					// count[ny][nx] == 0 이거 꼭 해줘야됨. 이거 안해줘서 메모리 초과 뜸
					if(copy[ny][nx] == 'L' && count[ny][nx] == 0) {
						count[ny][nx] = hour + 1;
						q.offer(new int[] {ny,nx,hour+1});
						copy[now[0]][now[1]] = 'W'; // 마찬가지 재방문 x
					}
				}
			}
		}
	}
	
	// bfs한 count 맵 별로 최댓값을 도출한다.
	public static int countMax() {
		int max = 0;
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(max < count[i][j]) {
					max = count[i][j];
				}
			}
		}
		return max;
	}
}
