package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1205 {
	// BOJ / 1205번 / 등수 구하기 / 구현 / 실버5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken()); // n
		int t = Integer.parseInt(stk.nextToken()); // 태수의 새로운 점수
		int p = Integer.parseInt(stk.nextToken()); // 총 길이 
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		if(n > 0) {
			stk = new StringTokenizer(br.readLine(), " ");			
		}
		int len = n;
		while(len-- > 0) {
			pq.add(Integer.parseInt(stk.nextToken()));
		}
		int answer = -1;
		int i = 1;

			while(p-- > 0) {
				int value = 0;
				if(pq.size() > 0) {
					value = pq.poll();
				}
				// t가 뺀 값보다 크면 i 등수.
				if(value < t) {
					answer = i;
					break;
				}
				// 값이 같으면 같은 값이 pq에 있는지 확인
				else if(value == t) {
					while(pq.size() > 0 && pq.peek() == value) {
						pq.poll();
						p--;
					}
					if(p == 0) {
						break;
					}
					answer = i;
					break;
				}
				i++;
			}

		System.out.println(answer);
	}
}
