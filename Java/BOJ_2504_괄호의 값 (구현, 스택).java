package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
	// BOJ / 2504번 / 괄호의 값 / 구현, 스택 / 실버2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		long answer = 0;
		int value = 1;
		boolean flag = true;
		if(!isCorrect(input)) {
			flag = false;
		}
		if(flag) {
			for(int i=0; i<input.length(); i++) {
				char ch = input.charAt(i);
				// '(' , '['은 값을 곱해준다. 
				if(ch == '(') {
					value *= 2; 
				}
				else if(ch == '[') {
					value *= 3;
				}
				else {
					// 직전에 동일한 open을 가진 괄호만 answer에 더해준다. 
					if(ch == ')') {
						if(input.charAt(i-1) == '(') {
							answer += value;
						}
						value /= 2;
					}
					else if(ch == ']') {
						if(input.charAt(i-1) == '[') {
							answer += value;
						}
						value /= 3;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean isCorrect(String input) {
		
		Stack<Character> st = new Stack<>();
		for(int i=0; i<input.length(); i++) {
			char ch = input.charAt(i);
			
			if(ch == '(' || ch == '[') {
				st.push(ch);
			}
			else if(ch == ')') {
				if(st.isEmpty()) return false;
				
				char open = st.peek();
				if(open != '(') {
					return false;
				}
				st.pop();
			}
			else if(ch == ']') {
				if(st.isEmpty()) return false;
				
				char open = st.peek();
				if(open != '[') {
					return false;
				}
				st.pop();
			}
		}
		// 반례 : "()[" 처리 
		if(!st.isEmpty()) {
			return false;
		}
		return true;
	}
}
