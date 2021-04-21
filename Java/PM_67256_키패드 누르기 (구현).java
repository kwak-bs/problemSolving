package problemSolve4;

public class PM_67256 {
	// PM / 76501번 / 키패드 누르기 / 구현  / Level1 / 2020 카카오 인턴
	public static void main(String[] args) {
		solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right");
	}
    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int l = 10; // 왼손 *
        int r = 12; // 오른손 #
        
        for(int i=0; i<numbers.length; i++) {
            int n = numbers[i];
            
            if(n == 1 || n==4||n==7) {
                l = n;
                sb.append("L");
            }
            else if(n == 3 || n== 6 || n == 9) {
                r = n;
                sb.append("R");
            }
            else {
                if(n == 0) n = 11;
                
                int Llen = getLength(l-1, n-1);
                int Rlen = getLength(r-1, n-1);

                if(Llen < Rlen) {
                    sb.append("L");
                    l = n;
                }
                else if(Llen > Rlen) {
                    sb.append("R");
                    r = n;
                }
                else {
                    if(hand.equals("left")) {
                        sb.append("L");
                        l = n;
                    }
                    else {
                        sb.append("R");
                        r = n;
                    }
                }
            }
        }
        
        return sb.toString();
    }
    
    public static int getLength(int hand, int num) {
        
        int hr = hand / 3; 
        int hc = hand % 3;
        int nr = num / 3;
        int nc = num % 3;
        return Math.abs(hr -  nr) + Math.abs(hc - nc);
    }
}
