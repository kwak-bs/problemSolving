package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1766 {
	// BOJ / 1766번 / 문제집 / 위상정렬 / 골드2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		
		int[] indegree = new int[n+1];
		ArrayList<Integer>[] al = new ArrayList[n+1];
		
		for(int i=0; i<al.length; i++) {
			al[i] = new ArrayList<>();
		}
		for(int i=0; i<m; i++) {
			stk= new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			// a -> b 이므로 b의 차수를 증가시킨다.
			al[a].add(b);
			indegree[b]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		while(!pq.isEmpty()) {
			int now = pq.poll();
			
			sb.append(now).append(" ");
			
			// now -> target 좌표들을 방문하여 indegree-1 하고, 0이라면 pq에 넣는다.
			for(int i=0; i<al[now].size(); i++) {
				int next = al[now].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					pq.add(next);
				}
			}
		}
		
		System.out.println(sb);
	}
}
