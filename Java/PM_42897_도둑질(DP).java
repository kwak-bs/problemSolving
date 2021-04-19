package problemSolve4;

public class PM_42897 {
	// PM / 42897번 / 도둑질 / DP  / Level4
	public static void main(String[] args) {
		solution(new int[] {1,2,3,1});
	}
	
    public static int solution(int[] money) {
        int dp1[] = new int [money.length-1]; // 처음 집을 훔친 경우
        int dp2[] = new int [money.length]; // 처음 집을 훔치지 않은 경우 
        
        dp1[0] = money[0];
        dp1[1] = money[0];
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i=2; i<dp1.length; i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
        }
        for(int i=2; i<dp2.length; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }

}
