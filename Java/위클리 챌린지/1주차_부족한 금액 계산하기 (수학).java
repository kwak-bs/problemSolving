package problemSolve6;

public class PM_82612 {
	// PM / 82612번 / 위클리 챌린지 / 수학 / 1주차 /
	public static void main(String[] args) {

		solution(3,20,4);
	}
    public static long solution(int price, int money, int count) {
        long answer = money;
        long sum  = 0;
        long temp = price;
        while(count-- > 0) {
        	sum += price;
        	price += temp;
        }
        sum += price;
        answer = sum - money;
        if(answer < 0) {
        	answer = 0;
        }
        return answer;
    }
}
