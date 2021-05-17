package problemSolve5;

import java.util.HashMap;

public class PM_42578 {
	// PM / 42578번 / 위장 / 해쉬, 조합 / Level2
	public static void main(String[] args) {

		solution(new String[][] {
			{"yellowhat", "headgear"},
			{"bluesunglasses", "eyewear"},
			{"green_turban", "headgear"},
		});
	}
	
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hm = new HashMap<>();
        // 종류 별로 갯수를 센다.
        for(String[] str : clothes) {
            hm.put(str[1], hm.getOrDefault(str[1],0)+1);
        }
        
        // 안 입을 경우를 포함하여 총 조합을 구한다.
        for(String str : hm.keySet()) {
            answer *= hm.get(str) + 1;
        }
        // 아예 안입는 상태 빼줌
        return answer-1;
    }

}
