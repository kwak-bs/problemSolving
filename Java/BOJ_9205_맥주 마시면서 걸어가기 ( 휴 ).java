package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class BOJ_9205 {
	// BOJ / 9205번 / 맥주 마시면서 걸어가기 / 그래프 / 실1
	
	static class dot {
		int x;
		int y;
		int idx;
		
		public dot(int y, int x, int idx) {
			this.y = y;
			this.x = x;
			this.idx = idx;
		}
	}
	
	static dot[] dotlist;
	static boolean[] visit;
	static boolean ok;
	static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		
		int tc = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<tc; i++) {
			
			int n = Integer.parseInt(br.readLine()); // 편의점의 개수
			num = n+2; // 지점의 총 갯수
			dotlist = new dot[num];
			visit = new boolean[num];
			ok = false; // 정답
			
			for(int j=0; j<num; j++) {
				stk = new StringTokenizer(br.readLine(), " ");
				dotlist[j] = new dot(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()),j);
			}

			dfs(dotlist[0].y, dotlist[0].x, dotlist[0].idx);
			
			if(ok) {
				System.out.println("happy");
			}
			else {
				System.out.println("sad");
			}
		}
		
	}
	
	public static void dfs(int y, int x, int index) {
		visit[index] = true;
		
		if(index == num-1) { // index가 num-1 이라면 락 페스티발에 잘 도착한 것이다. 
			ok = true;
			return;
		}
		
		// 현재 index 다음을 기준으로 distance가 1000 이하면 재귀 호출한다.
		// for문 시작은 무조건 0이다. 하 여기서 시간 엄청 잡아먹었따.
		for(int i=0; i<num; i++ ) {
			if(index != i) {
				int distance = Math.abs(x - dotlist[i].x) + Math.abs(y - dotlist[i].y);
				
				if(!visit[i] && distance <= 1000) {
					dfs(dotlist[i].y, dotlist[i].x, dotlist[i].idx);
				}				
			}
		}
	}
}


