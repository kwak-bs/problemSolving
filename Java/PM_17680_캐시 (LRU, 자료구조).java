package problemSolve5;

import java.util.LinkedList;

public class PM_17680 {
	// PM / 17680번 / 캐시 / LRU, 자료구조 / Level2 / 2018 카카오 블라인드 채용
	public static void main(String[] args) {

		solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
	}
	
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 0이면 길이만큼 miss 사이즈 곱해서 반환
        if(cacheSize == 0) return cities.length * 5;
        
        LinkedList<String>cache = new LinkedList<>();
        
        for(int i=0; i<cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            // hit
            if(cache.remove(city)) {
                cache.addFirst(city);
                answer += 1;
            }
            // miss
            else {
                int curSize = cache.size();
                // 꽉차 있으면 가장 오래된 것(끝) 제거
                if(curSize == cacheSize) {
                    cache.pollLast();
                }
                cache.addFirst(city);
                answer += 5;
            }
        }
        return answer;
    }

}
