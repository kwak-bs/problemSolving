package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1939 {
	// BOJ / 1939번 / 중량제한 / 이분 탐색 / 골드4
	
	static int n, m, maxlimit, ans;
	static ArrayList<islands> islands[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		islands = new ArrayList[n+1];
		
		for(int i=1; i<=n; i++) {
			islands[i] = new ArrayList<islands>();
		}
		
		for(int i =0; i<m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int limit = Integer.parseInt(stk.nextToken());
			
			// 양방향 그래프
			islands[from].add(new islands(to, limit));
			islands[to].add(new islands(from, limit));
			maxlimit = Math.max(maxlimit, limit);
			
		}
		

		stk = new StringTokenizer(br.readLine(), " ");
		int Fa = Integer.parseInt(stk.nextToken());
		int Fb = Integer.parseInt(stk.nextToken());
		
		findMaxWeight(Fa,Fb);
		
		System.out.println(ans);
	}
	
	public static void findMaxWeight(int FactoryA, int FactoryB) {
		
		int start = 1;
		int end = maxlimit;
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		boolean visit[] = new boolean[n+1];
		
		while(start <= end ) {
			int mid = (start + end) / 2;
			
			q.add(FactoryA);
			visit[FactoryA] = true;
			// 해당 중량을 옮길수 있는 섬이 있다.
			if(checkRoute(q, visit, mid, FactoryB)) {
				ans = Math.max(ans,  mid);
				start = mid + 1;
			}
			// 없다.
			else {
				end = mid - 1;
			}
			// 경로를 체크하고 다시 초기화.
			q.clear();
			Arrays.fill(visit, false);
		}
	}
	
	public static boolean checkRoute(Queue<Integer> q, boolean[] visit ,int mid,int FactoryB) {
		// bfs를 통하여 경로를 체크한다.
		while(!q.isEmpty()) {
			int now = q.poll();
			
			//System.out.println("now : "  + now);

			
			for(islands island : islands[now]) {
				// 이동할 섬의 다리가 중량 제한이 충분하면
				if(island.limit >= mid) {
					
					// 이동할 섬이 목적지이면 true 반환.
					if(island.end == FactoryB) {	

						return true;
					}
					
					// 목적지가 아니면 q에 추가 
					if(!visit[island.end]) {
						//System.out.println("visit end :" + island.end);
						visit[island.end] = true;
						q.add(island.end);
					}
				}
			}
		}
		
		return false;
	}
}

class islands {
	int end, limit;
	
	islands (int end, int limit) {
		this.end = end;
		this.limit = limit;
	}
}
