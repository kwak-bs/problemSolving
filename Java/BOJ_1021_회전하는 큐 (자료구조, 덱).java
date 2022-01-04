package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1021 {
	// BOJ / 1021번 / 회전하는 큐 / 자료구조, 큐 / 실버4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		// 입력부 
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		int answer = 0;
		int num = 1;
		int [] poll = new int[m];		
		while(n-- > 0) {
			dq.add(num);
			num++;
		}		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<m; i++) {
			poll[i] = Integer.parseInt(stk.nextToken());
		}
		
		// 수행
		for(int i=0; i<poll.length; i++) {
			int target = poll[i];
			// 뽑으려는 원소가 첫 위치에 있으면 Poll
			if(target == dq.peekFirst()) {
				dq.pollFirst();
			}
			// 없으면 맨 앞, 맨 뒤 위치 비교.
			else {
				int position = 0;
				for(int value : dq) {
					if(value == target) {
						break;
					}
					position++;
				}
				
				// (2) 왼쪽으로 이동
				if(position <= dq.size()/2) {
					answer+=position;
					while(position-- > 0) {
						dq.addLast(dq.pollFirst());
					}
				}
				// (3) 오른쪽으로 이동
				else {
					// 총 길이에서 위치 값을 빼며 (3)연산 횟수를 구한다. 
					position = dq.size() - position;
					answer += position;
					while(position-- > 0) {
						dq.addFirst(dq.pollLast());
					}
					
				}
				dq.pollFirst();
			}
		}
		
		System.out.println(answer);
	}
}
