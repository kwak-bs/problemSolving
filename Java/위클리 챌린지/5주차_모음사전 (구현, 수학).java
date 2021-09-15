package problemSolve6;

import java.util.HashMap;

public class BOJ_84512 {
	// PM / 84512�� / ��Ŭ�� ç���� / ����, ���� / 5���� 
	public static void main(String[] args) {
		
		solution("EIO");
	}

    public static int solution(String word) {
    	// ���ڿ��� ���̰� �ּҰ��� �ȴ�. 
        int answer = word.length();
        // ���̺� �����Ǵ� ���� ����.
        int add[] = {781, 156, 31, 6, 1};
        // Map�� ������ �� ����
        HashMap<Character, Integer> vowel = new HashMap<>();
        vowel.put('A', 0);
        vowel.put('E', 1);
        vowel.put('I', 2);
        vowel.put('O', 3);
        vowel.put('U', 4);
        // ���� ��Ģ�� ��ȭ���� �������� ����. 
        for(int i=0; i<word.length(); i++) {
        	char target = word.charAt(i);
        	int index = vowel.get(target);
        	answer += (add[i] * index);
        }
        return answer;
    }
}
