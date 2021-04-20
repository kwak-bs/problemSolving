package problemSolve4;

import java.util.Arrays;

public class PM_43238 {
	// PM / 43238번 / 입국 심사 / 이분 탐색  / Level3
	public static void main(String[] args) {
		solution(6, new int[] {7,10});
	}
	
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // 시간 순으로 정렬
        Arrays.sort(times);
        
        long start,mid,end;
        start = 0;
        end = Long.MAX_VALUE;
        
        while(start <= end) {
            // mid는 심사를 받는 시간이다. 
            mid = (end +start) / 2;
            long sum = 0;
            for(int i=0; i<times.length; i++) {
                // 주어진 시간 동안 심사를 몇 명 받을 수 있는 센다. 
                sum += mid / times[i];
                if(sum >= n) break;
            }
            
            // 모든 사람을 심사 할 수 없으면(시간이 모자르면) 
            if(sum < n) {
                start = mid + 1;
            }
            // 모든 사람을 심사 할 수 있으면(시간이 남거나 같으면)
            else {
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        return answer;
    }

}
