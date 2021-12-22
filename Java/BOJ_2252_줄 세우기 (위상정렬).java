package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
	// BOJ / 2252�� / �� ����� / �������� / ���3
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
			// a�� b�տ� ���� �ϱ� ������  a -> b �̹Ƿ� b�� ������ ������Ų��.
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
			// now -> target ��ǥ���� �湮�Ͽ� indegree -1 �ϰ�, 0�̶��  q�� �ִ´�. 
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
