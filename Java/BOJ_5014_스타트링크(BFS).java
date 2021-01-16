package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	// BOJ / 5014번 / 스타트링크 / 그래프 / 골5
	
	static int f,s,g,u,d;
	static boolean visit[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		f = Integer.parseInt(stk.nextToken()); // 빌딩의 높이(가장 높은 층)
		s = Integer.parseInt(stk.nextToken()); // 강호가 있는 층
		g = Integer.parseInt(stk.nextToken()); // 스타트링크가 있는 층
		u = Integer.parseInt(stk.nextToken()); // up
		d = Integer.parseInt(stk.nextToken()); // down
		
		visit = new boolean[f+1];
		System.out.println(bfs(s));
	}
	
	public static String bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		visit[s] = true;
		q.offer(s);
		int count = 0;
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) { // 한번 움직일때마다 count
				int now = q.poll();

				if(now == g) { // 현재 위치가 스타트링크 층이면 return
					return String.valueOf(count);
				}
				
				// up 
				int up = now + u;
				if(up <= f  && !visit[up]) {
					q.offer(up);
					visit[up] = true;
				}
				
				// down
				int down = now - d;
				if( down > 0 && !visit[down]) {
					q.offer(down);
					visit[down] = true;
				}
				
			}
			count++;
		}
		
		return "use the stairs";
	}
}
