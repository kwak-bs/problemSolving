package problemSolve6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	// BOJ / 1759�� / ��ȣ ����� / ����, ��Ʈ��ŷ  / ���5
	static int l, c;
	static String print[], alp[];
	static StringBuilder sb;
	static String vowel[] = {"a","e","i","o","u"};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		l = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		alp = br.readLine().split(" ");
		print = new String[l];
		sb = new StringBuilder();
		
		// ���������� ����.
		Arrays.sort(alp);

		recursion(0,0);
		
		System.out.println(sb);
	}
	
	public static void recursion(int depth, int start) {
		
		// l���� ���������� 
		if(depth == l) {
			// ���� ���� ���� Ȯ��
			if(check()) {
				for(String value : print) {
					sb.append(value);
				}
				sb.append("\n");
			}
			
			return;
		}
		
		//visit �迭�� ���� �ʿ䰡 ����. ������ �������� �����̰� 
		// ���� �ε����� ����� start���ڷ� �޾��ָ� �Ǳ� ����.
		for(int i=start; i<alp.length; i++) {
			print[depth] = alp[i];
			recursion(depth+1, i+1);
		}
	}

	public static boolean check() {
		int vow = 0; // ����
		int cons = 0; // ����
		
		for(String value : print) {
			boolean isVowel = false;
			// �����̸� vow++
			for(int i=0; i<vowel.length;i++) {
				if(value.equals(vowel[i])) {
					isVowel = true;
					vow++;
				}
				if(isVowel) {
					break;
				}
			}
			// �����̸� cons++;
			if(!isVowel) cons++;
			
			// ���ǿ� ������ return;
			if(vow >= 1 && cons >= 2) {
				return true;
			}
		}
		
		return false;
	}
}
