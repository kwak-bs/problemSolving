package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
	// BOJ / 4949번 / 균형잡힌 세상 / 스택, 문자열 / 실4
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			//입력
			String line = br.readLine();
			
			// .이면 break;
			if(line.equals(".")) {
				break;
			}
			
			boolean result = true;
			Stack<String> stack = new Stack<>();
			
			for(int i = 0; i<line.length(); i++) {
				char temp = line.charAt(i);
				
				if(temp == '(' || temp == '[') {
					stack.push(String.valueOf(temp));
				} else if (temp == ')') {
					if(stack.isEmpty() || !stack.pop().equals("(")) { // 스택이 비거나, 균형잡히지 않으면 false 
						result = false;
						break;
					}
				} else if (temp == ']') {
					if(stack.isEmpty() || !stack.pop().equals("[")) {
						result = false;
						break;
					}
				}
			}
			if(!stack.isEmpty() || !result) {
				System.out.println("no");
			} else if ( result) {
				System.out.println("yes");
			}
		}
	}
}
