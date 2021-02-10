package problemSolve2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

	static int n, k;
	static int map[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken()); // 수빈이 위치
		k = Integer.parseInt(stk.nextToken()); // 동생 위치
		map = new int[100001];
		Arrays.fill(map, -1);
		
		if(n == k) {
			System.out.println(0);
		} else {
			bfs(n);
			System.out.println(map[k]);
		}
	}
	
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		map[n] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			//System.out.println(now +" "+ map[now]);
			
			if(now == k) { // now가 k를 만나면 break
				break;
			}
			int teleport = now * 2;
			while(teleport <= 100000 && map[teleport] == -1) {
				map[teleport] = map[now];
				q.add(teleport);
				teleport *=2;
			}
			
			// -1 
			if(now -1 >= 0 && map[now-1] == -1) {
				q.offer(now-1);
				map[now-1] = map[now] + 1;
			}
			
			// +1
			if(now +1 < 100001 && map[now+1] == -1) {
				q.offer(now+1);
				map[now+1] = map[now] + 1;
			}
		}	
	}
}
