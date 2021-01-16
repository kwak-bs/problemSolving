package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502 {
	//BOJ / 14502번 / 연구소 / 그래프, 브루트포스  / 골5
	
	static int [][] map;
	static int [][] copy;
	static int [] dy = {1, -1, 0, 0};
	static int [] dx = {0, 0, 1, -1};
	static int y, x, max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(st.nextToken()); // 세로 크기
		x = Integer.parseInt(st.nextToken()); // 가로 크기
		map = new int[y][x];
		copy = new int[y][x];

		// map 입력
		for(int i=0; i<y; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		makeWall(0, 0);
		

		System.out.println(max);
		
	}
	
	// 백트래킹 + 조합 이용하여 벽 세우기
	public static void makeWall(int start, int wallCount) { 
		
		if(wallCount == 3) {
			copyMap(); // 벽 3개 세웠으면 맵 복사 ( 바이러스 퍼트릴 용)
			
			// 바이러스 퍼트리기
			for(int i=0; i<y; i++) {
				for(int j=0; j<x; j++) {
					if(copy[i][j] == 2) {
						dfs(i,j);
					}
				}
			}

			max = Math.max(max, countSafeZone()); // 안전지대 최댓값 구하기 
			return;
			
		}
		
		for(int i=start; i< y * x; i++) {
			int dy = i / x; // 조합 
			int dx = i % x;
			
			if(map[dy][dx] == 0) {
				map[dy][dx] = 1;
				// 백트래킹
				makeWall(i + 1, wallCount + 1); 
				map[dy][dx] = 0;
			}
		}
	}
	
	// dfs 이용하여 바이러스 퍼트리기
	public static void dfs(int yy, int xx) {
		
        for (int i = 0; i < 4; i++) {
            int ny = yy + dy[i];
            int nx = xx + dx[i];

            if (0 <= ny && ny < y && 0 <= nx && nx < x) {
                if (copy[ny][nx] == 0) {
                    copy[ny][nx] = 2;
                    dfs(ny, nx);
                }
            }
        }
	}
	
	// 바이러스를 퍼트릴 맵
	public static void copyMap() {
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
	// 안전지대 갯수 세기
	public static int countSafeZone() {
		int safe = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (copy[i][j] == 0)
                    safe++;
            }
        }
        return safe;
	}
}
