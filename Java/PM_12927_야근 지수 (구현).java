package problemSolve5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PM_12927 {
	// PM / 12927번 / 야근 지수 / 구현 / Level3 
	public static void main(String[] args) {
		
		solution(4, new int[] {4,3,3});
	}
	
    public static long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
        
        for(int i=0; i<works.length; i++) {
        	pq.add(new int[] {i,works[i]});
        }
        
        while(n-->0) {
        	int[] now = pq.poll();
        	if(now[1] > 0) {
        		now[1]--;
        	}
        	pq.add(new int[] {now[0],now[1]});
        }
        
        while(!pq.isEmpty()) {
        	answer += (int)(Math.pow(pq.poll()[1], 2));
        }
        return answer;
    }
}
