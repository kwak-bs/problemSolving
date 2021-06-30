package problemSolve5;

import java.util.HashMap;

public class KAKAO_2020_문자열압축 {
	// PM / 1835번 / 단체사진 찍기 / 구현 / Level2 / 2017 카카오 코드 본선
	public static void main(String[] args) {
		solution(2, new String[] {"N~F=0", "R~T>2"});
	}
	static int position[], count;
	static HashMap<String, Integer> hm;
	static boolean v[];
    public static int solution(int n, String[] data) {
        int answer = 0;
        // 이거 해줘야됨 안해주면 오류 뜸 . 이유는 몰겠
        count = 0;
        v = new boolean[8];
        position = new int[8];
        hm = new HashMap<>();
        
        // map을 활용해 미리 넣어줌
        hm.put("A", 0);
        hm.put("C", 1);
        hm.put("F", 2);
        hm.put("J", 3);
        hm.put("M", 4);
        hm.put("N", 5);
        hm.put("R", 6);
        hm.put("T", 7);
        
        perm(0, data);
        answer = count; 
        System.out.println(answer);
        return answer;
    }
    // 순열을 이용하여 모든 경우의 수를 탐색.
    public static void perm(int depth, String[] data) {
    	
    	if(depth == 8) {
    		if(check(data)) {
    			count++;
    		}
    		return;
    	}
    	
    	for(int i=0; i<8; i++) {
    		if(!v[i]) {
    			v[i] = true;
    			position[depth] = i;
    			perm(depth + 1, data);
    			v[i] = false;
    		}
    	}
    }
    // 조건 판별
    public static boolean check(String[] data) {
    	
    	for(int i=0; i<data.length; i++) {
    		String temp = data[i];
    		
    		String a = temp.substring(0,1);
    		String b = temp.substring(2,3);
    		String op = temp.substring(3,4);
    		int diff = Integer.parseInt(temp.substring(4, 5));
    		// a,b의 위치 (map을 활용)
    		int ap = position[hm.get(a)];
    		int bp = position[hm.get(b)];

    		// -1을 해줘야 서로의 거리를 구할 수 있다.
    		if(op.equals(">")) {
    			if(!(Math.abs(ap - bp)-1 > diff)) return false; 
    		}
    		else if(op.equals("<")) {
    			if(!(Math.abs(ap-bp)-1 < diff)) return false;
    		}
    		else if(op.equals("=")) {
    			if(Math.abs(ap-bp)-1 != diff) return false;
    		}
    	}
    	
    	return true;
    }
}
