package problemSolve5;

public class PM_70128 {
	// PM / 70128번 / 내적 / 수학 / Level1 / 월간 코드 챌린지 시즌1 
	public static void main(String[] args) {
		
		solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2});
	}

    public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for(int i=0; i<a.length; i++) {
            answer += (a[i] * b[i]);
        }
        return answer;
    }
}
