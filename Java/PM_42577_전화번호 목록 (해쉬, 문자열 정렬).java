package problemSolve5;

import java.util.Arrays;

public class PM_42577 {
	// PM / 42577번 / 전화번호 목록 / 해쉬 / Level2
	public static void main(String[] args) {
		solution(new String[] {"119", "97674223", "1195524421"});
	}
	
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
            // 문자열 정렬은 유니코드 순서 기준으로 비교하기 때문에 문자들이 일치하지만 길이가 다른 경우는 길이가 짧은 문자열이 낮은 순위로 정렬 된다. 또한, 문자열 비교 특징으로 인해 배열[n]의 문자열을 접두어로 포함하는 문자열은 배열[n+1]에 위치할 수 있게 된다. 
        for(int i=0; i<phone_book.length-1; i++) {
            if(phone_book[i+1].indexOf(phone_book[i]) == 0) {
                answer = false;
                return answer;
            }
        }
        return answer;
    }

}
