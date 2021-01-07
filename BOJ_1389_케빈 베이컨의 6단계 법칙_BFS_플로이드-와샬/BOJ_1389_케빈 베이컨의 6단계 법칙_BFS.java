package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389 {
	//BOJ / 1389번 / 케빈 베이컨의 6단계 법칙 / 그래프, BFS, 플로이드–와샬 / 실1
	
	static int [][] map;
	static boolean[] visit;
	static int[] total;
	static int y,x;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		y = Integer.parseInt(stk.nextToken());
		x = Integer.parseInt(stk.nextToken());
		map = new int[y][y];
		total = new int[y];
		int min = 99999;
		int answer = 0;
		
		// map 입력
		for(int i=0; i<x; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			map[a-1][b-1] = 1;
			map[b-1][a-1] = 1;
		}
		
		//출발점, 도착점을 bfs로 보내줌
		for(int i=0; i<y; i++) {
			for(int j =0; j<y; j++) {
				if(i == j ) {
					continue;
				}
				visit = new boolean[y];
				visit[i] = true; 
				total[i] += bfs(i,j); // 출발점, 도착점
			}
		}
		
		// 케빈 베이컨의 수가 가장 작은 사람출력. 여러 명일 경우 번호가 가장 작은 사람 출력.
		for(int i=0; i<y; i++) {
			if(min > total[i]) {
				min = total[i];
				answer = i;
			}
		}
		
		System.out.println(answer+1);
	}
	
	public static int bfs(int from, int to) {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i<y; i++) {
			if(map[from][i] == 1) {
				visit[i] = true;
				q.offer(i);
			}
		}
		int count = 1;
		
		while(!q.isEmpty()) {
			
			int qSize = q.size();
			while(qSize-- > 0) {  // 요거 신선함. 굳이 q에 count까지 포함시켜서 넣을 필요없어짐.
				int now = q.poll();
				
				if(now == to) { // 도착점이 존재하면 바로 리턴.
					return count;
				}
				for(int i=0; i<y; i++) {
					if(map[now][i] == 1 && !visit[i]) {
						q.offer(i);
						visit[i] = true;
					}
				}				
			}
			count++;
		}
		return 0;
	}
}
