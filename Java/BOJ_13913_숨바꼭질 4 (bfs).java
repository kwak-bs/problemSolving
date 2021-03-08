package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {
	// BOJ / 13913번 / 숨바꼭질 4 / 그래프 / 골드4
	static int n, k;
	static int map[];
	static int parent[];
	static StringBuffer sb;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(stk.nextToken()); // 수빈이 위치
		k = Integer.parseInt(stk.nextToken()); // 동생 위치
		map = new int[100001];
		parent = new int[100001];
		sb = new StringBuffer();
		
		if(n == k) {
			System.out.println(0);
			System.out.println(n);
		}
		else {
			bfs(n);
			sb.append(map[k]).append("\n");
			int temp = k;
			ArrayList<Integer> al = new ArrayList<>();
			while(temp != n) {
				al.add(temp);
				temp = parent[temp];
			}
			sb.append(n).append(" ");
			for(int i=al.size()-1; i>=0; i--) {
				sb.append(al.get(i)).append(" ");
			}
			
			System.out.println(sb);
 		}
	}
	public static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			if(map[k] != 0 ) { // 동생의 위치가 0이 아니면 최솟값을 찾은것이다. 
				break;
			}
			
			// -1 
			if(now -1 >= 0 && map[now-1] == 0) {
				q.offer(now-1);
				map[now-1] = map[now] + 1;
				parent[now-1] = now;
			}
			
			// +1
			if(now +1 < 100001 && map[now+1] == 0) {
				q.offer(now+1);
				map[now+1] = map[now] + 1;
				parent[now+1] = now;
			}
			
			// *2
			if(now*2 < 100001 && map[now*2] == 0) {
				q.offer(now*2);
				map[now*2] = map[now] + 1;
				parent[now*2] = now;
			}
			
		}	
	}
}
