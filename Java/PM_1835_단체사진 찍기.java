package problemSolve4;

import java.util.HashMap;

public class PM_1835 {
	// PM / 1835번 / 단체사진 찍기 / 구현 / Level2 / 2017 카카오코드 본선 
    static int p[];
    static boolean v[];
    static HashMap<Character, Integer> k;
    static int count;
	public static void main(String[] args) {
		
		solution(2, new String[] {"N~F=0","R~T>2"});
	}
    public static int solution(int n, String[] data) {
        int answer = 0;
        count = 0;
        p = new int[8]; // 카카오 프렌즈 위치
        v = new boolean[8]; // 방문 여부
        k = new HashMap<>();
        k.put('A', 0);
        k.put('C', 1);
        k.put('F', 2);
        k.put('J', 3);
        k.put('M', 4);
        k.put('N', 5);
        k.put('R', 6);
        k.put('T', 7);
        
        perm(0, data);
        answer = count;
        return answer;
    }
    
    // 순열을 통하여 완전 탐색 
    static void perm(int depth, String[] data) {
        
        if(depth == 8) {
            if(check(data)) {
                count++;
            }
            return;
        }
        
        for(int i=0; i<8; i++) {
            if(!v[i]) {
                v[i] = true;
                p[depth] = i;
                perm(depth+1, data);
                v[i] = false;
            }
        }
    }
    // 조건에 맞는지 체크
    static boolean check(String[] data) {
        
        for(int i=0; i<data.length; i++) {
            int a = k.get(data[i].charAt(0));
            int b = k.get(data[i].charAt(2));
            char t = data[i].charAt(3);
            int d = data[i].charAt(4) - '0';
            int ap = p[a];
            int bp = p[b];
            if(t == '=') {
                if(Math.abs(ap - bp) -1!= d) {
                    return false;
                }
            }
            else if(t == '>'){
                if(Math.abs(ap - bp) -1 <= d) {
                    return false;
                }
            }
            else if(t == '<') {
                if(Math.abs(ap-bp) -1 >= d) {
                    return false;
                }
            }
        }
        
        
        return true;
    }
}
