package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226 {
	// BOJ / 14226번 / 이모티콘 / 그래프 / 골드5
	static int n,ans;
	static boolean visit[][] ;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		visit = new boolean[2002][2002];
		ans = 0;
		bfs(1,0, 0);
		System.out.println(ans);
	}
	
	public static void bfs(int start, int sClip, int sTime) {
		
		Queue<info> q = new LinkedList<>();
		
		q.offer(new info(start, sClip, sTime));
		visit[start][sClip] = true;
		while(!q.isEmpty()) {
			info now = q.poll();

			if(now.index == n) {
				ans = now.time;
				break;
			}
			
			if(!visit[now.index][now.index]) {
				//복 
				visit[now.index][now.index] = true;
				q.offer(new info(now.index, now.index, now.time+1));				
			}
			//붙
			if(now.clip > 0 &&
					!visit[now.index+now.clip][now.clip] &&
					now.index + now.clip <= 1000) {
				visit[now.index+now.clip][now.clip] = true;
				q.offer(new info(now.index + now.clip, now.clip, now.time+1));

			}
			//하나 빼기
			if(now.index - 1 > 0 && !visit[now.index-1][now.clip]) {
				visit[now.index-1][now.clip] = true;
				q.offer(new info(now.index-1, now.clip, now.time+1));
			
			}
		}
	}
	
	private static class info {
		int clip, index, time;
		public info(int index, int clip, int time) {
			this.index = index;
			this.clip = clip;
			this.time = time;
		}
	}
}
