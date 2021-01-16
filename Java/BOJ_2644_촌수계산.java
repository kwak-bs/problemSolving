package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644 {
	// BOJ / 2644번 / 촌수계산 / 그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색/ 실2
	
	static int map[][];
	static int people;
	static int q1, q2;
	static int visit[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		people = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		map = new int[people+1][people+1];
		visit = new int[people+1];
		
		q1 = Integer.parseInt(st.nextToken());
		q2 = Integer.parseInt(st.nextToken());
		
		int rel = Integer.parseInt(br.readLine());
		
		for(int i=0; i<rel; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			// 관계 이어주기
			map[parent][child] = 1;
			map[child][parent] = 1;
		}
		
		bfs(q1);
		
		//visit[q2]가 0이면 관계가 없는 것이므로 -1 출력
		System.out.println(visit[q2] == 0 ? -1 : visit[q2]);
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);

		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<= people; i++) {
				if(map[now][i] == 1 && visit[i] == 0) {
					q.offer(i);
					visit[i] = visit[now] + 1; // 현재 위치에서 연결되어 있는 관계에 +1 
				}
			}
		}
	}
}
