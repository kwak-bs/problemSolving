package problemSolve4;

import java.util.Stack;

public class PM_76502 {
	// PM / 76502번 / 괄호 회전하기 / 스택, 구현  / Level2 / 월간 코드 챌린지 시즌2
	public static void main(String[] args) {
		solution("[](){}");
	}
	
    public static int solution(String s) {
        int answer = 0;
        int len = s.length();
        // 길이만큼 반복
        while(len -- > 0) {
            if(check(s)){
                answer++;
            }
            s = rotate(s);        
        }
        return answer;
    }
	
    // 올바른 괄호를 가진 문자열인지 검사
    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            char b = s.charAt(i);
            if(b == '(') {
                st.push(b);
            }
            else if(b == ')') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '(') continue;
                else return false;
            }
            else if(b == '{') {
                st.push(b);
            }
            else if(b == '}') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '{') continue;
                else return false;
            }
            else if(b == '[') {
                st.push(b);
            }
            else if(b == ']') {
                if(st.isEmpty()) return false;
                
                char tmp = st.pop();
                if(tmp == '[') continue;
                else return false;
            }
        }
        if(st.size() == 0) {
            return true;
        }
        return false;
    }
	
    // 왼쪽으로 회전 
    public static String rotate(String s) {
        char tmp = s.charAt(0);
        StringBuffer sb = new StringBuffer();
        
        for(int i=1; i<s.length(); i++) {
            sb.append(s.charAt(i));   
        }
        sb.append(tmp);
        return sb.toString();
    }
}
