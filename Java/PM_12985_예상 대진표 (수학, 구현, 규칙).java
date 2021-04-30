package problemSolve4;

public class PM_12985 {
	// PM / 12985번 / 예상 대진표 / 수학,구현,규칙  / Level2 / 2017 팁스타운
	public static void main(String[] args) {

		solution(8,4,7);
	}
    public static int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true) {
            if(a / 2 != b / 2 && Math.abs(a-b) == 1) {
                break;
            }
            if(a % 2 == 0) {
                a /= 2;
            }
            else {
                a = (a+1) /2;
            }
            if( b % 2 == 0) {
                b /= 2;
            }
            else {
                b = (b+1) /2;
            }
            answer++;
        }

        return answer;
    }
}
