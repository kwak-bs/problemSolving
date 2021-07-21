package problemSolve6;

import java.util.HashMap;

public class PM_81301 {
	// PM / 81301번 / 숫자 문자열과 영단어 / 구현, 해쉬맵 / Level1 / 2021 카카오 채용연계형 인턴십
	public static void main(String[] args) {

		solution("one4seveneight");
	}
    static HashMap<String, Integer> hm;
    public static int solution(String s) {
        int answer = 0;
        hm = new HashMap<String,Integer>();

        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);
        
        s = checkStr(s);
        
        answer = strToInt(s);
        System.out.println(answer);
        return answer;
    }
    
    public static String checkStr(String s) {
        StringBuilder sb = new StringBuilder();
        String num = "";

        for(int i =0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
            else {
                num += ch;
                if(hm.containsKey(num)) {
                    sb.append(hm.get(num));
                    num = "";
                }
            }
        }
        return sb.toString();
    }
    
    public static int strToInt(String s) {
        return Integer.parseInt(s);
    }

}
