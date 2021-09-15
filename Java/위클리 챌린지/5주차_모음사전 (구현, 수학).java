package problemSolve6;

import java.util.HashMap;

public class BOJ_84512 {
	// PM / 84512번 / 위클리 챌린지 / 구현, 수학 / 5주차 
	public static void main(String[] args) {
		
		solution("EIO");
	}

    public static int solution(String word) {
    	// 문자열의 길이가 최소값이 된다. 
        int answer = word.length();
        // 길이별 증가되는 숫자 저장.
        int add[] = {781, 156, 31, 6, 1};
        // Map에 모음별 값 저장
        HashMap<Character, Integer> vowel = new HashMap<>();
        vowel.put('A', 0);
        vowel.put('E', 1);
        vowel.put('I', 2);
        vowel.put('O', 3);
        vowel.put('U', 4);
        // 구한 규칙과 점화식을 바탕으로 구현. 
        for(int i=0; i<word.length(); i++) {
        	char target = word.charAt(i);
        	int index = vowel.get(target);
        	answer += (add[i] * index);
        }
        return answer;
    }
}
