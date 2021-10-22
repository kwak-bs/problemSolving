package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
	// BOJ / 2504�� / ��ȣ�� �� / ����, ���� / �ǹ�2
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
				// '(' , '['�� ���� �����ش�. 
				if(ch == '(') {
					value *= 2; 
				}
				else if(ch == '[') {
					value *= 3;
				}
				else {
					// ������ ������ open�� ���� ��ȣ�� answer�� �����ش�. 
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
		// �ݷ� : "()[" ó�� 
		if(!st.isEmpty()) {
			return false;
		}
		return true;
	}
}
