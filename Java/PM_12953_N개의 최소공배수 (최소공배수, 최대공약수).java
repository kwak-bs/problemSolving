package problemSolve4;

public class PM_12953 {
	// PM / 12953번 / N개의 최소공배수 / 수학 / Level2 
	public static void main(String[] args) {
		
		solution(new int[] {2,6,8,14});
	}
    public static int solution(int[] arr) {
        int answer = arr[0];;
        
        for(int i=1; i<arr.length; i++) {
            int a = Math.max(answer, arr[i]);
            int b = Math.min(answer, arr[i]);
            answer = lcm(a,b);
        }
        return answer;
    }
    // 최대공약수
    public static int gcd (int a, int b) {
        if(b == 0) return a;
        return gcd(b , a%b);
    }
    // 최소공배수
    public static int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}
