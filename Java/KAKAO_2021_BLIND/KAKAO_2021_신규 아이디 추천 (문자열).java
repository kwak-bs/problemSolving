package problemSolve2;

import java.util.ArrayList;

public class PM_KAKAO_2021_1_1 {

	public static void main(String[] args) {
		
		String new_id = "abcdefghijklmn.p";
		
		PM_KAKAO_2021_1_1 c = new PM_KAKAO_2021_1_1();
		
		c.solution(new_id);

	}
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계, 모든 문자를 소문자로
        String one = new_id.toLowerCase();
        
        // 2단계, -, _, .를 제외한 모든 문자 제거
        for(int i = 0; i<one.length(); i++) {
        	char temp = one.charAt(i);
        	
        	if(temp >= 'a' && temp <= 'z') {
        		answer += Character.toString(temp);
        	}
        	else if (temp >= '0' && temp <= '9') {
        		answer += Character.toString(temp);
        	}
        	else if(temp == '-' || temp == '_' || temp == '.') {
        		answer += Character.toString(temp);
        	}
        	else {
        		continue;
        	}
        }
        
        // 3단계, .가 2번 이상 연속된 부분을 하나의 .로 치환
        while(answer.indexOf("..") >= 0) {
        	answer = answer.replace("..", ".");
        }
        
        // 4단계, .가 처음이나 끝에 위치하면 제거
        if(answer.charAt(0) == '.'){
            answer = answer.substring(1, answer.length());
        }
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
            answer = answer.substring(0, answer.length()-1);
        }
        
        
        // 5단계, 빈 문자열이면 "a" 대입
        if(answer.length() == 0 ) {
        	answer = "a";
        }
        
        // 6단계, 16자 이상이면 첫 15개를 제외한 나머지 문자 모두 제거.
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            // 6.5단계, 제거했는데 마지막 문자가 .이면 제거 
            if(answer.length() > 0 && answer.charAt(14) == '.'){
                answer = answer.substring(0, 14);
            }
        }
        
        // 7단계, 2자 이하이면, 마지막 문자를 3이 될때까지 반복 
        if(answer.length() <= 2) {
        	char temp = answer.charAt(answer.length() - 1);
        	
        	while(answer.length() != 3) {
        		answer += Character.toString(temp);
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
}
