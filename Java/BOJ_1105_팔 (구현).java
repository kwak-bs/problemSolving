package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1105 {
	// BOJ / 1105�� / �� / ���� / �ǹ�1
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		String l = stk.nextToken();
		String r = stk.nextToken();
		int answer = 0;
		// �ڸ����� �ٸ��� ������ 0�� ����Ѵ�. l�� r������ ���� ũ�Ƿ� 8�� �������� �ʴ� ���� ������ �� �ִ�. 
		// �ڸ����� ������ l�� r�� �� �ڸ����� ���Ͽ� '8'�� �������� �����ִ� �ڸ����� ������ ���ش�. 
		// ���� �ڸ����� ���ڰ� �ٸ��� �� �ڸ��� ���Ϸδ� ���� ���� �����ϹǷ� ���� �ʿ䰡 ����. (break)
		if(l.length() == r.length() && Integer.parseInt(l) <= Integer.parseInt(r)) {
			for(int i=0; i<l.length(); i++) {
				if(l.charAt(i) == '8' && l.charAt(i) == r.charAt(i)) {
					answer++;
				}
				else if(l.charAt(i) != r.charAt(i)) {
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
