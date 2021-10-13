package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9953 {
	// BOJ / 9953�� / ���ڿ� ���� / ���ڿ�, ���� / ���4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String explosion = br.readLine();
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int len = explosion.length();
		
		for(int i=0; i<input.length(); i++) {
			st.push(input.charAt(i));
			// ���� ���̰� ���ų� Ŀ�� ������ �����ش�. 
			if(st.size() >= explosion.length()) {
				boolean flag = true;
				for(int j=0; j<len; j++) {
					if(st.get(st.size()-len+j) != explosion.charAt(j)) {
						flag = false;
						break;
					}
				}
				if( flag ) {
					int temp = len;
					while(temp-- > 0) {
						st.pop();
					}
				}
			}
		}
		if(st.size() == 0) {
			System.out.println("FRULA");
		}else {
			while(!st.isEmpty()) {
				sb.append(st.pop());
			}
			System.out.println(sb.reverse());
		}
	}
}
