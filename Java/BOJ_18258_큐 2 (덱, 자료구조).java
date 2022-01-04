package problemSolve8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_18258 {
	// BOJ / 18258번 / 큐2 / 자료구조, 큐 / 실버2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		while(n-- > 0) {
			String input = br.readLine();
			String split[] = input.split(" ");
			String op = split[0];
			
			if(op.equals("push")) {
				dq.addFirst(Integer.parseInt(split[1]));
				continue;
			}
			else if(op.equals("pop")) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollLast());					
				}
				else sb.append(-1);
			}
			else if(op.equals("front")) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast());					
				}
				else sb.append(-1);
			}
			else if(op.equals("empty")) {
				if(dq.isEmpty()) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
			}
			else if(op.equals("size")) {
				sb.append(dq.size());
			}
			else if(op.equals("back")) {
				if(!dq.isEmpty()) {
					sb.append(dq.peekFirst());					
				}
				else sb.append(-1);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
