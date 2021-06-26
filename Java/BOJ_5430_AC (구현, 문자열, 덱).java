package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_5430 {
	// BOJ / 5430번 / AC / 구현, 문자열, 덱 / 골드5
	// 역시 StringBuilder 무조건 써줘야함
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer stk;
		ArrayDeque<Integer> dq;
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			dq = new ArrayDeque<>();
			stk = new StringTokenizer(br.readLine(), ",[]");
			
			for(int i=0; i<n; i++) {
				dq.add(Integer.parseInt(stk.nextToken()));
			}
			
			AC(p, dq);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	// 명령어대로 게임 시작
	public static void AC(String p, ArrayDeque<Integer> dq) {
		
		boolean right = true;
		for(int i=0; i<p.length(); i++) {
			char op = p.charAt(i);
			
			if(op == 'R') {
				right = !right;
			}
			else if(op == 'D') {
				if(dq.size() > 0) {
					if(right) dq.removeFirst();
					else dq.removeLast();
				}
				else {
					sb.append("error");
					return;
				}
			}
		}
		makeString(dq, right);
	}
	
	public static void makeString(ArrayDeque<Integer> dq, boolean right) {

		sb.append("[");
		if(dq.size() > 0) {
			if(right) {
				// 먼저 하나를 넣어주고 그 다음에 ","를 넣어줘야 마지막 숫자에서 처리해줄 필요가 없어진다.
				sb.append(dq.pollFirst());		
				while(!dq.isEmpty()) {
					sb.append(",").append(dq.pollFirst());
				}
			}
			else {
				sb.append(dq.pollLast());
				while(!dq.isEmpty()) {
					sb.append(",").append(dq.pollLast());
				}
			}
		}
		sb.append("]");
	}
}
