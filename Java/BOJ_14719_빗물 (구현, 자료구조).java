package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14719 {
	// BOJ / 14719번 / 빗물 / 구현, 자료구조 / 골드5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int h = Integer.parseInt(stk.nextToken());
		int w = Integer.parseInt(stk.nextToken());
		int map[][] = new int[h][w];
		int answer = 0;
		stk = new StringTokenizer(br.readLine(), " ");
		// map 초기화
		for(int i=0; i<w; i++) {
			int wall = Integer.parseInt(stk.nextToken());
			for(int j=h-1; j>=h-wall; j--) {
				map[j][i] = 1;
			}
		}
		// 맨 위층부터 반복문을 시작한다. 
		for(int i=0; i<h; i++) {
			// 각 층에 벽을 저장한다. 
			ArrayList<Integer> wall = new ArrayList<>();
			for(int j=0; j<w; j++) {
				if(map[i][j] == 1) {
					wall.add(j);
				}
			}
			// 벽이 2개 이상부터 벽 사이의 인덱스를 물이 차는곳으로 간주하고 값을 도출한다.
			if(wall.size() > 1) {
				int left = wall.get(0);
				for(int k=1; k<wall.size(); k++) {
					answer += (wall.get(k) - left - 1);
					left = wall.get(k); 
				}
			}
		}
		
		System.out.println(answer);
	}
}
