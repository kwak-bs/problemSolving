package problemSolve7;

import java.util.PriorityQueue;

public class PM_86491 {
	// PM / 86491번 / 위클리 챌린지 / 자료구조 / 8주차_최소직사각형
	public static void main(String[] args) {
		
		solution(new int[][] {
			{14, 4},
			{19, 6},
			{6, 16},
			{18, 7},
			{7, 11},
		});
	}

    public static int solution(int[][] sizes) {
        int answer = 0;
        int valueBig = 0;
        int valueSmall = 0;
        for(int i=0; i<sizes.length; i++) {
            int big = Math.max(sizes[i][0], sizes[i][1]);
            int small = Math.min(sizes[i][1], sizes[i][0]);
            if(big > valueBig) {
                valueBig = big;
            }
            if(small > valueSmall) {
            	valueSmall = small;
            }
        }
        answer = valueBig * valueSmall;
        return answer;
    }
}
