package problemSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {
	//BOJ / 17413번 / 단어 뒤집기2 / 구현, 문자열 / 실3
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String line = br.readLine();
		Stack st = new Stack();
		boolean flag = false;
		
		for(int i=0; i<line.length(); i++) {
			
			if(line.charAt(i) == '<') {
				printStack(st);
				sb.append(line.charAt(i));
				flag = true;

			}
			else if(line.charAt(i) == '>') {
				flag = false;
				sb.append(line.charAt(i));

			}
			else if(flag == true) {
				sb.append(line.charAt(i));

			}

			else if(line.charAt(i) == ' ' && !flag){
					printStack(st);
					sb.append(line.charAt(i));

				}
				else {
					st.push(line.charAt(i));
				}
			
		}
		printStack(st);
		System.out.println(sb.toString());
	}
	
	public static void printStack(Stack st) {
		while (!st.empty()) {
			sb.append(st.pop());
		}
	}
}
