package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190 {
	// BOJ / 3190번 / 뱀 / 시뮬레이션 / 골드5
	static int n, k, map[][];
	// 우,하,좌,상
	static int dy[] = {0,1,0,-1};
	static int dx[] = {1,0,-1,0};
	static List<int[]> snake;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer stk;
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		
		for(int i=0; i<k; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int y = Integer.parseInt(stk.nextToken());
			int x = Integer.parseInt(stk.nextToken());
			
			// 사과의 위치
			map[y-1][x-1] = 1;
		}
		
		int l = Integer.parseInt(br.readLine());
		
		int[][] dir = new int[l][2]; 
		for(int i=0; i<l; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			dir[i][0] = Integer.parseInt(stk.nextToken());
			
			char temp = stk.nextToken().charAt(0);			
			dir[i][1] = (temp == 'L') ? -1 : 1; // L -> -1, D ->1
		}
		
		snake = new LinkedList<>();
		snake.add(new int[] {0,0});
		
		int time = 0;
		int DirIdx = 0;
		int curDir = 0; // 처음은 오른쪽
		int nowY = 0;
		int nowX = 0;
		while(true) {
			time++;
			
			int nextY = nowY+dy[curDir];
			int nextX = nowX+dx[curDir];
			
			if(isFinish(nextY, nextX)) {
				break;
			}
			// 사과가 있으면 사과 없애고 꼬리는 그대로
			if(map[nextY][nextX]  ==  1) {
				map[nextY][nextX] = 0;
				snake.add(new int[] {nextY,nextX});
			}
			// 없으면 꼬리는 자르자
			else {
				snake.add(new int[] {nextY,nextX});
				snake.remove(0);
			}
			
			nowY = nextY;
			nowX = nextX;
			
			// DirIdx가 뱀의 방향 변환 정보 배열 길이보다 작은경우만 
			if(DirIdx < l) {
				// 만약 바뀌어야될 시간이 됐다면 
				if(time == dir[DirIdx][0]) {
					// 왼쪽 90도
					if(dir[DirIdx][1] == -1) {
						curDir = (curDir + 3) % 4;
					}
					// 오른쪽 90도
					else {
						curDir = (curDir + 1)%4; 
					}
					DirIdx++;
				}
			}
		}
		
		System.out.println(time);
		
	}
	public static boolean isFinish(int ny, int nx) {
		
		// 벽
		if(!(ny >=0 && ny<n && nx>=0 && nx <n)) {
			return true;
		}
		// 자기 몸 
		for(int i=0; i<snake.size(); i++) {
			int body[] = snake.get(i);
			
			if(body[0] == ny && body[1] == nx) {
				return true;
			}
		}
		return false;
	}
	
}
