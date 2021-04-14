package problemSolve4;

import java.util.HashSet;

public class PM_42839 {
	// PM / 42577번 / 전화번호 목록 / 해쉬  / Level2
    static String[] arr;
    static HashSet<Integer> set;
    static String[] s;
    static boolean[] v;
    
	public static void main(String[] args) {

		solution("17");
	}

    public static int solution(String numbers) {
        int answer = 0;
        
        v = new boolean[numbers.length()];
        arr = new String[numbers.length()];
        arr = numbers.split("");
        
        set = new HashSet<>();
        
        for(int i=1; i<=numbers.length(); i++) {
            s = new String[i];
            go(0, i, numbers.length());
        }
        answer = set.size();

        return answer;
    }
    
    public static void go(int st, int e, int len) {
        
        if( st == e) {
            findP();
        }
        else {
            for(int i=0; i<len; i++) {
                if(!v[i]) {
                    v[i] = true;
                    s[st] = arr[i];
                    go(st+1, e, len);
                    v[i] = false;
                }
            }            
        }
    }
    
    public static void findP() {
        // int로 변환
        String str = "";
        
        for(int i=0; i<s.length; i++) {
            str+= s[i];
        }
        int num = Integer.parseInt(str);
        
        if(num == 0 || num == 1) {
            return;
        }
        boolean isPrime = false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                isPrime = true;
            } 
        }
        
        if(!isPrime) {
            set.add(num);
        }
    } 
}
