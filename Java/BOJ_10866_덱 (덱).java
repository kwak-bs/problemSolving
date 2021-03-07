package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10866 {
	// BOJ / 10866¹ø / µ¦ / µ¦ / ½Ç¹ö4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		while(n-- > 0) {
			String s[] = br.readLine().split(" ");
			
			if(s[0].equals("push_front")) {
				dq.addFirst(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("push_back")) {
				dq.addLast(Integer.parseInt(s[1]));
			}
			else if(s[0].equals("pop_front")) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
			else if(s[0].equals("pop_back")) {
				if(!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
			else if(s[0].equals("size")) {
				sb.append(dq.size()).append("\n");
			}
			else if(s[0].equals("empty")) {
				if(dq.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
			else if(s[0].equals("front")) {
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(dq.getFirst()).append("\n");
				}
			}
			else if(s[0].equals("back")) {
				if(dq.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(dq.getLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
