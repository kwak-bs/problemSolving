package problemSolve5;
import java.util.*;
public class PM_67257 {
	// PM / 67257번 / 수식 최대화 / 문자열, 수학, 구현  / Level2 / 2020 카카오 인턴쉽
    static String exp;
    static ArrayList<Long> numList; // 숫자 저장
    static ArrayList<Character> opList; // 연산자 저장 
    static Character op[] = {'+','-', '*'}; // 연산자 3개 
    static Character tmp[] = new Character[3]; // 연산자 순열 결과(우선순위)
    static boolean v[] = new boolean[3];
    static long answer;
	public static void main(String[] args) {
	
		solution("100-200*300-500+20");
	}
    public static long solution(String expression) {
        answer = Long.MIN_VALUE;
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        exp = expression;
        String n = "";
        
        for(int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);
            if(ch== '+' || ch== '*' || ch== '-' ) {
                opList.add(ch);
                numList.add(Long.parseLong(n));
                n = "";
            }
            else {
                n += (ch+"");
            }
        }
        numList.add(Long.parseLong(n));
        
        perm(0, 3);
        
        return answer;
    }
	
    // 연산자 우선순위를 순열을 통해서 정한다. 
    public static void perm(int depth, int l) {
        
        if(depth == l) {
            solve();
            return;
        }
        
        for(int i=0; i<op.length; i++) {
            if(!v[i]) {
                v[i] = true;
                tmp[depth] = op[i];
                perm(depth+1, l);
                v[i] = false;
            }
        }
    }
	
    // 우선순위를 정했으면 그 순위로 answer값 도출 (최댓값이 나올때 까지)
    public static void solve() {
        
        ArrayList<Character> opT = new ArrayList<>();
        opT.addAll(opList);
        
        ArrayList<Long> numT = new ArrayList<>();
        numT.addAll(numList);
        
        for(int i=0; i<tmp.length; i++) {
            char o = tmp[i];
            
            for(int j=0; j<opT.size(); j++) {
                // 현재 우선순위의 연산자와 일치하면
                if(o == opT.get(j)) {
                    long n1 = numT.get(j);
                    long n2 = numT.get(j+1);
                    // 계산
                    long ans = calc(n1,n2, o);
                    // 숫자 삭제
                    numT.remove(j+1); // +1 먼저 삭제해 줘야됨
                    numT.remove(j);
                    // 연산자 삭제
                    opT.remove(j);
                    // 계산 결과 넣기
                    numT.add(j, ans);
                    
                    // 삭제햇으니 인덱스를 하나 줄여준다.
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(numT.get(0)));
    }
	
    // 계산
    public static long calc(long n1, long n2, Character o) {
        long ans = 0;
        if(o == '+') {
            ans = n1 + n2;
        }
        else if(o == '-') {
            ans = n1 - n2;
        }
        else if(o == '*') {
            ans = n1 * n2;
        }
        return ans;
    }
}
