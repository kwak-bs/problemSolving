package problemSolve4;

public class PM_42842 {
	// PM / 42842번 / 카펫 / 완전 탐색  / Level2
	public static void main(String[] args) {

		solution(24,24);
	}
	
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 가로는 x , 세로는 y
        int x, y;
        int temp = brown + yellow;
        
        for(int i=3; i<brown; i++) {
            x = i; 
            y = temp / i;
            if(x < y) continue;
            int tmp = 2 * x + 2 * (y-2);

            if(tmp == brown) {
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }
        return answer;
    }
}
