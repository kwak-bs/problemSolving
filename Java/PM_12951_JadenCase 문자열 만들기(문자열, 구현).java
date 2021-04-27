package problemSolve4;

public class PM_12951 {
	// PM / 12951번 / JadenCase 문자열 만들기 / 구현, 문자열 / Level2 
	public static void main(String[] args) {
		solution("3people unFollowed me");
	}
	
    public static String solution(String s) {
        StringBuffer answer = new StringBuffer();
        
        String f = s.charAt(0)+"";
        answer.append(f.toUpperCase());

        for(int i=1; i<s.length(); i++) {
            // 공백이면 그냥 넣어줌
            if(s.charAt(i) == ' ') {
                answer.append(" ");
            }
            else {
                String str = s.charAt(i)+"";
                // 전 문자가 공백이면 대문자로 
                if(s.charAt(i-1) == ' ') {
                    answer.append(str.toUpperCase());
                }
                // 아니면 소문자로 
                else {
                    answer.append(str.toLowerCase());
                }
            }
        }
        return answer.toString();
    }
}
