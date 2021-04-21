package problemSolve4;

public class PM_12899 {
	// PM / 12899번 / 124 나라의 숫자 / 수학  / Level2 
	public static void main(String[] args) {

		solution(4);
	}
    public static String solution(int n) {
        String answer = "";
        // 숫자가 총 3개 이므로 3으로 나눴을 때의 나머지 값을 인덱스로 하고 해당 인덱스에 사용하는 숫자를 저장한다.
        String nums [] = {"4","1","2"};
        
        while(n > 0) {
            answer = nums[n % 3] + answer;
            // 나누어 떨어지면 어차피 자리수로 가기 위해 -1을 해줘야 하므로 -1을 통해서 다음 자릿수로 미리 이동.
            n = (n-1) / 3;
        }
        
        return answer;
    }

}
