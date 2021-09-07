package problemSolve6;

import java.util.Stack;

public class PM_60058 {
	// PM / 60058�� / ��ȣ ��ȯ / ����, �ڷᱸ��  / Level2 / 2020 KAKAO BLIND
	public static void main(String[] args) {
		
		solution("(()())()");
	}
	static int split;
    public static String solution(String p) {
        String answer = "";
        
        if (p.equals("")) return p;
        
        boolean right = isRight(p);
        // u,v�� �и�.
        String u = p.substring(0, split);
        String v = p.substring(split, p.length());

        // �ùٸ� ��ȣ ���ڿ��̶�� 3. ����
        if(right) {
        	return u + solution(v);
        }

        // �ùٸ� ��ȣ���ڿ��� �ƴ϶�� 4. ����
        answer= "(" + solution(v) + ")";
        	
        for(int i=1; i<u.length()-1; i++) {
        	if(u.charAt(i) == '(') {
        		answer += ")";
        	}
        	else answer += "(";
        }


        return answer;
    }
    // �ùٸ� ��ȣ ���ڿ����� �Ǻ�. (���� �ڷᱸ��)
    public static boolean isRight(String p) {
    	Stack<Character> st = new Stack<>();
    	
    	boolean right = true;
    	int l = 0; 
    	int r = 0;
    	
    	for(int i=0; i<p.length(); i++) {
    		
    		if(p.charAt(i) == '(') {
    			l++;
    			st.push('(');
    		}
    		else {
    			r++;
    			if(!st.isEmpty()) {
    				st.pop();
    			}
    			else {
    				right = false; 
    			}
    		}
    		
    		if( l == r) {
    			split = i + 1;
    			return right;
    		}
    	}
    	return right;
    }
}
