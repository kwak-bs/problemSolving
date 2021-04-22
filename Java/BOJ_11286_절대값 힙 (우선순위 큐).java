package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_11286 {
	// BOJ / 11286번 / 절댓값 힙 / 우선순위 큐 / 실버1
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->  {
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			
			if(abs1 == abs2) return o1 - o2;
			return abs1-abs2;
		});
		StringBuilder sb = new StringBuilder();
		while(n-- > 0) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()+"\n");					
				}
				else {
					sb.append(0+"\n");
				}
			}
			else {
				pq.add(num);
			}
		}
		System.out.println(sb);
	}
}
