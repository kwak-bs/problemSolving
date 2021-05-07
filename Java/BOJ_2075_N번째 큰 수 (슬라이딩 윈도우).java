package problemSolve5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2075 {
	// BOJ / 2075번 / N번째 큰 수 / 슬라이딩 윈도우 / 골드5
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		StringTokenizer stk;
		stk= new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			pq.add(Integer.parseInt(stk.nextToken()));
		}
		
		for(int i=1; i<n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(stk.nextToken());
				
				if(pq.peek() < num) {
					pq.poll();
					pq.add(num);
				}
			}
		}
		
		System.out.println(pq.poll());
	}
}
