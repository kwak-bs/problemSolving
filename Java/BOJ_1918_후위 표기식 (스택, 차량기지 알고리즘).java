package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
	// BOJ / 1918번 / 후위 표기식 / 스택, 차량기지 알고리즘 / 골드4
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		
		Stack<Character> op = new Stack<>();
		for(int i=0; i<input.length(); i++) {
			
			char ch = input.charAt(i);
			// 알파벳은 그냥 출력
			if(ch >= 'A' && ch <='Z') {
				sb.append(ch);
			}
			// '('은 그냥 push
			else if(ch == '('){
				op.push(ch);
			}
			// 스택에서 '('을 만날 때 까지 pop
			else if(ch == ')') {
				while(!op.isEmpty()) {
					ch = op.pop();
					
					if(ch == '(') break;
					sb.append(ch);
				}
			}
			// 연산자는 우선순위를 비교해서 넣어준다. 
			// 스택 peek()에 있는 연산자가 들어올 연산자보다 우선 순위가 높으면 pop하고 push 한다.
			else {
				while(!op.isEmpty() && chk_priority(op.peek()) >= chk_priority(ch)) {
					sb.append(op.pop());
				}
				op.push(ch);
			}
	
		}
		while(!op.isEmpty()) {
			sb.append(op.pop());
		}
		System.out.println(sb);
	}
	
	public static int chk_priority(char op) {
		
		if(op == '+' || op == '-') {
			return 1;
		}
		else if(op == '/' || op == '*') {
			return 2;
		}
		
		return 0;
	}
}
