package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
	// BOJ / 2252번 / 줄 세우기 / 위상정렬 / 골드3
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int [] indegree = new int[n+1];
		ArrayList<Integer>[] al = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			
			al[a].add(b);
			// a가 b앞에 서야 하기 때문에  a -> b 이므로 b의 차수를 증가시킨다.
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			// now -> target 좌표들을 방문하여 indegree -1 하고, 0이라면  q에 넣는다. 
			for(int i=0; i<al[now].size(); i++) {
				int next = al[now].get(i);
				indegree[next]--;
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		System.out.println(sb);
	}
}
