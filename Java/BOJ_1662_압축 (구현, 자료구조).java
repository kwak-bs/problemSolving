package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1662 {
	// BOJ / 1662�� / ���� / �ڷᱸ��, ���� / ���5
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		// ���ڿ��� ���̸� ������ len ����, ���� ���� ������ mul ����.
		Stack<Integer> len = new Stack<>();
		Stack<Integer> mul = new Stack<>();
		int size = 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			// '('�� ������  i-1�� mul.push, len-1�� len.push (���� �� ���̴� ������) 
			if(ch == '(') {
				mul.push(s.charAt(i-1)-'0');
				len.push(size-1);
				size = 0;
			}
			// ')'�� ������ ���� ������� ���� ��-1(size�� 0�� �ƴϹǷ�)�� ����.
			// �� ���� ���� ����� �����ִ� len�� ����
			else if(ch == ')') {
				int mulNum = mul.pop();
				size += size * (mulNum-1);
				size += len.pop();
			}
			// ���ڴ� size++
			else {
				size++;
			}
		}
		System.out.println(size);
	}
}
