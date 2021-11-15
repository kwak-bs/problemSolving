package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1213 {
	// BOJ / 1213�� / �Ӹ���� ����� / ���� / �ǹ�4
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int [] alp = new int[26];
		
		for(int i=0; i<str.length(); i++) {
			alp[str.charAt(i)-'A']++;
		}
		
		int midIndex = 0, odd = 0;
		
		for(int i=0; i<alp.length; i++) {
			if(alp[i] % 2 != 0) {
				midIndex = i;
				odd++;
			}
		}
		// ¦���� ���� Ȧ�� ������ �����ϸ� �ȵǰ�, Ȧ�� �� ���� Ȧ�� ������ 1�̻� �����ϸ� �ȵ�
		if((str.length() % 2 == 0 && odd > 0) ||  (str.length() % 2 != 0 && odd > 1)) {
			System.out.println("I'm Sorry Hansoo");
		}
		else {
			StringBuilder answer = new StringBuilder();
			StringBuilder reverse = new StringBuilder();
			// ���ĺ� ���� / 2 ��ŭ �տ��ٰ� �߰� + midIndex ���ĺ� + reverse �� �� 
			for(int i=0; i<alp.length; i++) {
				for(int j=0; j<alp[i]/2; j++) {
					String value= (char)(i+'A')+"";
					reverse.append(value);
				}
			}
			answer.append(reverse);
			if(str.length() % 2 != 0) answer.append((char)(midIndex + 'A')+"");
			answer.append(reverse.reverse().toString());
			System.out.println(answer);
		}
	}
}
