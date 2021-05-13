package problemSolve5;

import java.util.Arrays;

public class PM_43238 {
	// PM / 43238번 / 입국심사 / 이분 탐색 / Level3 
	public static void main(String[] args) {

		solution(6, new int[] {7,10});
	}
	
    public static long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        
        long start = 0;
        long end = Long.MAX_VALUE;
        long mid;
        Arrays.sort(times);
        
        while(start <= end) {
        	// m은 주어진 시간 
        	mid = (start+end) / 2;
        	
        	long sum = 0;
        	// 주어진 시간 동안 각 심사대에서 총 몇명이 심사 받을 수 있는지 센다. 
        	for(int i=0; i<times.length; i++) {
        		sum += (mid / times[i]);
        		if(sum >= n) {
        			break;
        		}
        	}
        	// 모든 사람이 주어진 시간 내에 심사를 할 수 없으면 
        	if(sum < n ) {
        		start = mid+1;
        	}
        	// 모든 사람이 주어진 시간 내에 심사를 할 수 있으면 
        	else {
        		end = mid-1;
        		answer = Math.min(answer, mid);
        	}
        }
        System.out.println(answer);
        return answer;
    }
}
