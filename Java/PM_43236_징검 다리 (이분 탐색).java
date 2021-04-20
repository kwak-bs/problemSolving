package problemSolve4;

import java.util.Arrays;

public class PM_43236 {
	// PM / 43236번 / 입국 심사 / 이분 탐색  / Level3
	public static void main(String[] args) {
		
		solution(25, new int[] {2,14,11,21,17},2);
	}
	
    public static int solution(int distance, int[] rocks, int n) {
        int answer = Integer.MIN_VALUE;
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance; 
        int mid;
        
        while(start <= end) {
            // mid는 바위 사이의 최소 길이 
            mid = (start + end) / 2;
            int count = 0;
            int prev = 0;
            for(int i=0; i<rocks.length; i++) {
                // 전과 비교해서 작으면 바위 삭제 
                if(rocks[i] - prev < mid) {
                    count++;
                }
                // 크거나 같으면 prev를 현재바위로 변경
                else {
                    prev = rocks[i];
                }
                if(count > n ) break;
            }
            // count가 작으면 도착지점과 마지막돌 비교
            if(count <= n && distance - prev < mid) {
                count++;
            }
            
            // 제거한 바위의 갯수가 n 보다 작거나 같으면 start 변화 
            if(count <= n) {
                start = mid + 1;
                answer = Math.max(answer, mid);
            }
            // 제거한 바위의 갯수가 n보다 크면 end 변화 
            else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
