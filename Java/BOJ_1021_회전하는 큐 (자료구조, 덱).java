package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1021 {
	// BOJ / 1021�� / ȸ���ϴ� ť / �ڷᱸ��, ť / �ǹ�4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		// �Էº� 
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
		
		// ����
		for(int i=0; i<poll.length; i++) {
			int target = poll[i];
			// �������� ���Ұ� ù ��ġ�� ������ Poll
			if(target == dq.peekFirst()) {
				dq.pollFirst();
			}
			// ������ �� ��, �� �� ��ġ ��.
			else {
				int position = 0;
				for(int value : dq) {
					if(value == target) {
						break;
					}
					position++;
				}
				
				// (2) �������� �̵�
				if(position <= dq.size()/2) {
					answer+=position;
					while(position-- > 0) {
						dq.addLast(dq.pollFirst());
					}
				}
				// (3) ���������� �̵�
				else {
					// �� ���̿��� ��ġ ���� ���� (3)���� Ƚ���� ���Ѵ�. 
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
