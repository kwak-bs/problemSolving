package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {
	// BOJ / 2583번 / 영역 구하기 / 그래프 / 실1
	
	static int [][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int y, x, area;
 
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[y][x];
		ArrayList<Integer> areaList = new ArrayList<>();
		int count = 0; // 분리되는 영역의 개수
		
		for(int i=0; i<k; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			makeSquare(x1, y1, x2, y2);
		}
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				if(map[i][j] == 0) {
					dfs(i, j);
					count++;
					areaList.add(area);
					area = 0; // 넓이 초기화 
				}
			}
		}
		// 오름차순 정렬
		Collections.sort(areaList); 
		
		// 출력
		System.out.println(count);
		for(int i =0 ; i<areaList.size(); i++) {
			System.out.print(areaList.get(i) + " ");
		}
	}
	
	// 사각형 만들기
	public static void makeSquare(int stX, int stY, int endX, int endY) {
		for(int i=stY; i<endY; i++) {
			for(int j=stX; j<endX; j++) {
				map[i][j] = 1;
			}
		}
	}
	
	// dfs
	public static void dfs(int r, int c) {
		map[r][c] = 1;
		area++; // 넓이 계산
		
		for(int i=0; i<4; i++) {
			int nx = c + dx[i];
			int ny = r + dy[i];
			
			if(0 <= nx && nx < x && 0 <= ny && ny < y ) {
				if(map[ny][nx] == 0) {
					dfs(ny, nx);
				}
			}
		}
	}
}
