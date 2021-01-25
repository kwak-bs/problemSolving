package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9943 {
	// BOJ / 9943번 / 완전 이진 트리 / 트리 / 실2
	
	static Queue<node> q;
	static int depth, limit;
	static int input[];
	static boolean visit[];
	
	static class node {
		int data, mid, start,end;
		
		public node (int data, int mid, int start, int end) {
			this.data = data;
			this.mid = mid;
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		depth = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		limit = (int)(Math.pow(2, depth));
		input = new int[limit];
		visit = new boolean[limit];
		
		for(int i=1; i<limit; i++) {
			int data = Integer.parseInt(stk.nextToken());
			input[i] = data;
		}
		
		build(1, limit);
	}
	
	public static void build(int start, int end) {
		
		q = new LinkedList<>();
		
		// 완전 이진 트리에서는 정 가운데가 최상위 노드이다. 
		int mid = (start + end) / 2;

		if(input[mid] != 0) {
			q.add(new node(input[mid], mid,start,end));
			visit[mid] = true;
		}
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			while(qSize-- > 0) {
				node node = q.poll();
				int data = node.data;
				mid = node.mid;
				start = node.start;
				end = node.end;
				
				System.out.print(data + " ");
				
				int leftMid = (start + mid) / 2;
				int rightMid = (mid + end) / 2;
				// 왼쪽
				if(!visit[leftMid]) {
					visit[leftMid] = true;
					q.add(new node(input[leftMid], leftMid,start, mid ));
				}
					
				// 오른쪽
				if(!visit[rightMid]) {
					visit[rightMid] = true;
					q.add(new node(input[rightMid], rightMid, mid, end));
				}
			}
			System.out.println();
		}
	}
}
