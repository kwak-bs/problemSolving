package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
	// BOJ / 1541�� / �Ҿ���� ��ȣ / ����, �׸��� / �ǹ�2
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		// '-'�� �������� ���� 
		String sub[] = s.split("\\-");
		// sub[0]�� ��� Ȥ�� '+'��ȣ�� ���� �����̴�. 
		int answer = cal(sub[0]);
		
		// sub[0]���� ������ �迭 ��(��� Ȥ�� '+'��ȣ�� ���� ����)���� ���ش�.
		for(int i=1; i<sub.length; i++) {
			answer -= cal(sub[i]);
		}
		System.out.println(answer);
	}
	// ��� Ȥ�� '+'��ȣ�� ���� ���� ���
	public static int cal(String exp) {
		int result = 0;
		String plus[] = exp.split("\\+");
		for(int i=0; i<plus.length; i++) {
			result += Integer.parseInt(plus[i]);
		}
		
		return result;
	}
}
