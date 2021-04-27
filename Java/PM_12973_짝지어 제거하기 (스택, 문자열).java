package problemSolve4;

import java.util.Stack;

public class PM_12973 {
	// PM / 12973번 / 짝지어 제거하기 / 스택, 문자열 / Level2 / 2017 팁스타운 
	public static void main(String[] args) {
		
		solution("baabaa");
	}

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        for(int i=1; i<s.length(); i++) {
            
            // 스택이 비어있지 않으면 
            if(!st.isEmpty()) {
                // 일단 pop
                char c = st.pop();

                // 비교할 글자랑 같으면 pop한거 유지 및 i++
                if(c == s.charAt(i)) {
                    continue;
                }
                // 비교할 글자랑 다르면 뺀거랑 비교글자 둘다 push
                else {
                    st.push(c);
                    st.push(s.charAt(i));
                }
            }
            // 스택이 비어있으면 현재 글자 push
            else {
                st.push(s.charAt(i));
            }
        }

        // 스택 사이즈가 0이면 answer = 1 
        if(st.isEmpty()) answer = 1;
        return answer;
    }
}
