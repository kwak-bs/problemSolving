package problemSolve5;

import java.util.HashMap;

public class PM_42576 {
	// PM / 42576번 / 완주하지 못한 선수 / 해쉬 / Level1 
	public static void main(String[] args) {
		solution(new String[] {"leo","kiki","eden"}, new String[] {"eden","kiki"});
	}
	
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for(String str : participant) {
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        for(String str : completion) {
            hm.put(str, hm.get(str)-1);
            if(hm.get(str) == 0) {
                hm.remove(str);
            }
        }
        for(String ans : hm.keySet()) {
            answer = ans;
        }
        return answer;
    }

}
