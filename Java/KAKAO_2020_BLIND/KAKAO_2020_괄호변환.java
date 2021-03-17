package problemSolve3;

import java.util.Stack;

public class KAKAO_2020_괄호변환 {

	public static void main(String[] args) {
		
		KAKAO_2020_괄호변환 c = new KAKAO_2020_괄호변환();
		String p ="(()())()";
		c.solution(p);
	}
    static int pos;
    public String solution(String p) {

        
        if(p.isEmpty()) {
        	return p;
        }
        
        boolean correct = isCorrect(p);
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        // u가 올바른 괄호 문자열 이라면
        if(correct) {
        	return u + solution(v);
        }
        
        // 올바른 문자가 아니면
        String answer = "(" + solution(v) + ")";
        
        for(int i=1; i<u.length()-1; i++) {
        	char temp = u.charAt(i);
        	
        	if(temp == '(') {
        		answer += ")";
        	}
        	else {
        		answer += "(";
        	}
        };
        

        return answer;
    }

    public static boolean isCorrect(String str) {
    	boolean ret = true;
    	
    	int left = 0, right = 0;
    	
    	Stack<Character> st = new Stack<>();
    	
    	for(int i=0; i<str.length(); i++) {
    		if(str.charAt(i) == '(') {
    			left++;
    			st.push('(');
    		} else {
    			right++;
    			if(st.isEmpty()) {
    				ret = false;
    			}
    			else st.pop();
    		}
    		if(left == right) {
    			pos = i + 1;
    			return ret;
    		}
    	}
    	return true;
    }
}
