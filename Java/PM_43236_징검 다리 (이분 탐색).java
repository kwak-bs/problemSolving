package problemSolve5;

import java.util.Arrays;

public class PM_43236 {
	// PM / 43263번 / 징검다리 / 이분탐색 / Level4 
	public static void main(String[] args) {

		solution(25, new int[] {2,14,11,21,17},2);
	}
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        
        Arrays.sort(rocks);
        
        int start = 0; 
        int end = Integer.MAX_VALUE;
        int mid;
        
        while(start <= end) {
        	// mid는 바위 사이의 거리 
        	mid = (start + end) / 2;
        	int count = 0;
        	int prev = 0;
        	for(int i=0; i<rocks.length; i++) {
        		// mid보다 작으면 삭제 
        		if(rocks[i] - prev < mid) {
        			count++;
        		}
        		// mid보다 크거나 같으면 prev 변경
        		else {
        			prev = rocks[i];
        		}
        		if(count > n) break;
        	}
        	// 마지막 비교 
        	if(distance - prev < mid && count<=n) {
        		count++;
        	}
        	// 삭제된 바위가 n개보다 크면  
        	if(count > n) {
        		end = mid - 1;
        	}
        	// 삭제된 바위가 n개보다 작거나 같으면  
        	// 최댓값을 구해야 하므로 start에서 mid 변화
        	else {
        		start = mid + 1;
        		answer = Math.max(answer, mid);
        	}
        	
        }
        System.out.println(answer);
        return answer;
    }
}
