package problemSolve5;

import java.util.Collections;
import java.util.PriorityQueue;

public class PM_42587 {
	// PM / 42587번 / 프린터 / 자료구조, 우선순위 큐 / Level2
	public static void main(String[] args) {
		solution(new int[] {2,1,3,2}, 2);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        // 우선순위 저장 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int p : priorities) {
            pq.add(p);
        }
        // 우선순위 높은 순으로 반복문을 탐색한다. 
        while(!pq.isEmpty()) {
            for(int i=0; i<priorities.length; i++) {
                if(priorities[i] == pq.peek()) {
                    if(i == location) return answer;
                    else {
                        answer++;
                        pq.poll();
                    }
                }
            }
        }
        return answer;
    }

}
