package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
	// BOJ / 16928번 / 뱀과 사다리 게임 / BFS / 실버1
	
	static int n,m;
	static boolean v[];
	static HashMap<Integer, Integer> map;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		v = new boolean[101];
		map = new HashMap<>();
		// 사다리
		for(int i=0; i <n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			map.put(s, e);
		}
		
		// 뱀
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(stk.nextToken());
			int e = Integer.parseInt(stk.nextToken());
			map.put(s, e);
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		v[1] = true;
		q.add(new int[] {1,0});
		int count = 0;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int index = now[0];
			count = now[1];

			if(index == 100) {
				return count;
			}
			
			for(int i=1; i<=6; i++) {
				int next = index + i;
				
				if(next > 100) break;
				if(v[next]) continue;
				
				// 사다리나 뱀 칸이면 next를 변경한다.
				if(map.containsKey(next)) {
					next = map.get(next);
					if(v[next]) continue;
					v[next] = true;
				}
				v[next] = true;
				q.add(new int[] {next, count+1});
			}
		}
		
		return count;
	}
}
