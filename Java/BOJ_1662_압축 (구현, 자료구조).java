package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662 {
	// BOJ / 1662번 / 압축 / 자료구조, 구현 / 골드5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		// 문자열의 길이를 저장할 len 스택, 곱할 값을 저장할 mul 스택.
		Stack<Integer> len = new Stack<>();
		Stack<Integer> mul = new Stack<>();
		int size = 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			// '('을 만나면  i-1은 mul.push, len-1은 len.push (곱할 값 길이는 빼야함) 
			if(ch == '(') {
				mul.push(s.charAt(i-1)-'0');
				len.push(size-1);
				size = 0;
			}
			// ')'을 만나면 현재 사이즈와 곱할 값-1(size는 0이 아니므로)을 곱함.
			// 그 다음 현재 사이즈에 남아있는 len을 더함
			else if(ch == ')') {
				int mulNum = mul.pop();
				size += size * (mulNum-1);
				size += len.pop();
			}
			// 숫자는 size++
			else {
				size++;
			}
		}
		System.out.println(size);
	}
}
