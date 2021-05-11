package problemSolve5;

import java.util.Arrays;

public class PM_12938 {
	// PM / 12938번 / 최고의 집합 / 구현 / Level3 
	public static void main(String[] args) {

		solution(2,9);
	}
	
    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if( n>s) return new int[] {-1};
        for(int i=0; i<answer.length; i++) {
        	answer[i] = s/n;
        }
        for(int i=0; i<s%n; i++) {
        	answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
