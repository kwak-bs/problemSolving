package problemSolve5;

import java.util.ArrayList;
import java.util.HashMap;

public class PM_17684 {
	// PM / 17684번 / 압축 / 구현 / Level2 / 2018 카카오 블라인드 채용
	public static void main(String[] args) {

		solution("KAKAO");
	}
	
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> list = new ArrayList<>();
     
        HashMap<String, Integer> hm = new HashMap<>();
        char al = 'A';
        // map에 (alphabet, 숫자) 삽입
        for(int i=1; i<=26; i++) {
            hm.put(String.valueOf(al), i);
            al += 1;
        }
        int idx = 27;
        for(int i=0; i<msg.length(); i++) {
            int j = 1;
            // 문자열을 더해가면서, 이 문자들이 사전에 있는지 검사.
            while(i + j <= msg.length() && hm.containsKey(msg.substring(i, i+j))) {
                j++;
            }
            // 문자열이 끝났을 경우 break;
            if(i + j > msg.length()) {
                list.add(hm.get(msg.substring(i)));
                break;
            }
            // 사전에 없으면 (i+j)까지 사전에 넣어주고
            // (i+j-1)까지는 list에 넣어줌
            list.add(hm.get(msg.substring(i, i+j-1)));
            hm.put(msg.substring(i, i+j), idx++);

            if(j > 1) i += j -2;
        }

        return list;
    }
}
