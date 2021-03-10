package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16927 {
	// BOJ / 16927번 / 배열 돌리기 2 / 구현 / 실버1
	static int y,x, r;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		int map [][] = new int[y][x];
		
		for(int i=0; i<y; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<x; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
		int groupn = Math.min(y, x) / 2 ;
		
		// 각 그룹의 이동할 행과 열을 1차원 리스트에 넣어준다.
		for(int k=0; k<groupn; k++) {
			ArrayList<Integer> group = new ArrayList<>();
			
			// 첫 행
			for(int j=k; j<x-k; j++) {
				group.add(map[k][j]);
			}
			
			// 마지막 열 ( k+1 ~ y-k-1까지)
			for(int i=k+1; i<y-k-1; i++) {
				group.add(map[i][x-k-1]);
			}
			
			// 마지막 행 
			for(int j=x-k-1; j>k; j--) {
				group.add(map[y-k-1][j]);
			}
			
			// 첫 열
			for(int i=y-k-1; i>k; i--) {
				group.add(map[i][k]);
			}
			groups.add(group);
		}
		// r칸 만큼 회전시킨다. 
		for(int k=0; k<groupn; k++) {
			ArrayList<Integer> group = groups.get(k);
			int len = group.size();
			int index = r % len; // 어차피 배열의 길이만큼 돌면 똑같은 배열이 되므로, 배열의 길이만큼 나눠주면 된다.
			
			// 그대로 넣어준다.
			// 첫 행
			for(int j=k; j<x-k; j++, index = (index + 1) % len) {
				map[k][j] = group.get(index);
			}
			
			// 마지막 열 ( k+1 ~ y-k-1까지)
			for(int i=k+1; i<y-k-1; i++, index = (index + 1) % len) {
				map[i][x-k-1] = group.get(index);
			}
			
			// 마지막 행 
			for(int j=x-k-1; j>k; j--, index = (index + 1) % len) {
				map[y-k-1][j] = group.get(index);
			}
			
			// 첫 열
			for(int i=y-k-1; i>k; i--, index = (index + 1) % len) {
				map[i][k] = group.get(index);
			}
		}
		
		for(int i=0; i<y; i++) {
			for(int j=0; j<x; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
