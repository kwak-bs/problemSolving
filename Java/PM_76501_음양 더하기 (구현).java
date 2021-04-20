package problemSolve4;

public class PM_76501 {
	// PM / 76501번 / 음양 더하기 / 구현  / Level1
	public static void main(String[] args) {
		solution(new int[] {4,7,2}, new boolean[] {true, false, true});
	}
	
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i =0; i<signs.length; i++) {
            if(signs[i]) {
                answer += absolutes[i];
            }
            else {
                absolutes[i] = -absolutes[i];
                answer += absolutes[i];
            }
        }
        return answer;
    }

}
