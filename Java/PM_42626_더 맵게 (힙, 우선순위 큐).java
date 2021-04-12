package problemSolve4;

import java.util.PriorityQueue;

public class PM_42626 {

	public static void main(String[] args) {

		int[] scoville = {1,2,3,9,10,12};
		int k = 7;
		solution(scoville, k);
	}
	
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<scoville.length; i++) {
            pq.add(scoville[i]);
        }
        // 모든 음식을 스코빌 지수 이상으로 만들수 있는지 판단하는 변수 
        boolean pos = false;
        
        while(!pq.isEmpty()) {

            int f = pq.poll();
            // 우선순위 큐를 사용하는 거라 어차피 오름차순 정렬이다. 
            // 맨 앞의 숫자만 판단하면 됨.
            if(f >= K) {
                pos = true;
                break;
            }

            answer++;
            if(pq.size() >= 1) {
             
                int s = pq.poll();

                int scov = f + ( s * 2);
                pq.add(scov);   
            }
        }
        
        if(!pos) answer = -1;
        return answer;
    }

}
