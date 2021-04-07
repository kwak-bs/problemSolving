package problemSolve4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
	// BOJ / 1935번 / 후위 표기식2 / 스택 / 실버3
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		double[] num = new double[27];
		
		String s = br.readLine();
		
		for(int i=1; i<=n; i++) {
			int input = Integer.parseInt(br.readLine());
			num[i] = (double)input;
		}
		Stack<Double> st = new Stack<>();

		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				st.push(num[ch-'A'+1]);
			}
			else {
				double n1 = st.pop();
				double n2 = st.pop();
				double result = 0;
				
				if(ch == '*') {
					result = n2 * n1;
				}
				else if(ch == '+') {
					result = n2 + n1;
				}
				else if(ch == '-') {
					result = n2 - n1;
				}
				else if(ch == '/') {
					result = n2 / n1;
				}
				
				st.push(result);
			}
		}
		
		System.out.printf("%.2f", st.pop());
	}
}
