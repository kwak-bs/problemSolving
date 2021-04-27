package problemSolve4;

import java.util.Arrays;
import java.util.HashSet;

public class PM_64065 {
	// PM / 64065번 / 튜플 / 구현, 문자열 / Level2 / 2019 카카오 개발자 겨울 인턴십 
	public static void main(String[] args) {
		
		solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}

    public static int[] solution(String s) {
        
        // 앞 뒤 중괄호 삭제
        s = s.substring(1,s.length()-1);
        
        // '{' -> '}' 치환
        s = s.replace('{', '}');
        // '{', '}'문자 모두 " "로 바꿔준다.
        s = s.replaceAll("[{}]"," ");
        // 앞 뒤 공백 제거
        s = s.trim();

        String str[] = s.split(" ,");
        for(int i=0; i<str.length; i++) {
            str[i] = str[i].trim(); // 각 열별 공백 제거 
        }
     
        int[] answer = new int[str.length];
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(str, (o1, o2) -> (o1.length() - o2.length()));
        
        int i =0;
        for(String st : str) {
            String[] tmp = st.split(",");
            for(String tp : tmp) {
                if(!set.contains(Integer.parseInt(tp))) {
                    set.add(Integer.parseInt(tp));
                    answer[i++] = Integer.parseInt(tp);
                }
            }
            
        } 
        return answer;
    }
}
