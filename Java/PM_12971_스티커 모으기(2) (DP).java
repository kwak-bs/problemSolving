package problemSolve7;

public class PM_12971 {
	// PM / 12971번 / 스티커 모으기(2) / 구현 / Level 3
	public static void main(String[] args) {
		
		int[] sticker = {14,6,5,11,3,9,2,10};
		solution(sticker);
	}
	
    public static int solution(int sticker[]) {
    	int answer = 0;
    	
    	int len = sticker.length;
    	int dp1[] = new int[len]; // 첫 번째 스티커를 떼느냐
    	int dp2[] = new int[len]; // 첫 번째 스티커를 안떼느냐
    	
    	if(len == 1) return sticker[0];
    	
    	// 첫 번째 스티커 뗌 
    	dp1[0] = sticker[0];
    	dp1[1] = sticker[0];
    	for(int i=2; i<len-1; i++) {
    		dp1[i] = Math.max(dp1[i-1], dp1[i-2]+ sticker[i]);
    	}
    	
    	// 첫 번째 스티커 안뗌
    	dp2[0] = 0;
    	dp2[1] = sticker[1];
    	for(int i=2; i<len; i++) {
    		dp2[i] = Math.max(dp2[i-1], dp2[i-2]+sticker[i]);
    	}
    	
    	answer = Math.max(dp1[len - 2], dp2[len-1]);
        return answer;
    }
}
