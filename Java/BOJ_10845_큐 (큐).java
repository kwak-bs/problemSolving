package problemSolve3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10845 {
	// BOJ / 10845번 / 큐 / 큐 / 실버4
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		
		int last = 0;
		while(n-- > 0) {
			
			String s[] = br.readLine().split(" ");
			
			if(s[0].equals("push")) {
				q.add(Integer.parseInt(s[1]));
				last = Integer.parseInt(s[1]);
			}
			else if(s[0].equals("pop")) {
				if(!q.isEmpty()) {
					sb.append(q.poll()).append("\n");
				}
				else {
					sb.append(-1).append("\n");
				}
			}
			else if(s[0].equals("size")) {
				sb.append(q.size()).append("\n");
			}
			else if(s[0].equals("empty")) {
				if(q.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
			else if(s[0].equals("front")) {
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.peek()).append("\n");
				}
			}
			else if(s[0].equals("back")) {
				if(q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(last).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
