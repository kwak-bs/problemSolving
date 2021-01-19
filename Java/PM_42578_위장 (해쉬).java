package problemSolve;

import java.util.HashMap;
import java.util.Set;

public class PM_42578 {
	//PM(프로그래머스) / 68644번 / 위장
	public static void main(String[] args) {
		
		PM_42578 c = new PM_42578();
		
		String clothes [][] = {{"yellow_hat", "headgear"}, 
					{"blue_sunglasses", "eyewear"}, 
					{"green_turban", "headgear"}};
		c.solution(clothes);
	}
	
    public int solution(String[][] clothes) {
        int answer = 1; // 곱셉음 위해 1로 선언
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
        	// 의상 종류, 갯수
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        
        // 조합
        Set<String> keySet = map.keySet();
        
        for(String key : keySet) {
        	// 옷 종류마다 안 입는 경우를 +1 해준다.
        	answer *= map.get(key)+1;
        }
        
         // 아무것도 안 입는 상태 빼주기
        return answer-1;
    }
}
