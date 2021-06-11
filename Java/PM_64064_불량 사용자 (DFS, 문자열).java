package problemSolve5;

import java.util.Arrays;
import java.util.HashSet;

public class PM_64064 {
	// PM / 64064번 / 불량 사용자 / dfs, 문자열 / Level3 / 2019 카카오 개발자 겨울 인턴십
	public static void main(String[] args) {

		solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"},
				new String[] {"*rodo", "*rodo", "******"});
	}
	static HashSet<String> set;
	static boolean[] v;
    public static int solution(String[] user_id, String[] banned_id) {
        
        set = new HashSet<>();
        v = new boolean[user_id.length];
        
        dfs(0, "", user_id, banned_id);
        return set.size();
    }
    // dfs 탐색으로 모든 배열을 탐색한다. 
    public static void dfs(int idx, String str, String[] user_id, String[] banned_id) {
    	if(idx == banned_id.length) {
    		String sArr[] = str.split(" ");
    		Arrays.sort(sArr);
    		
    		StringBuffer sb = new StringBuffer();
    		for(String s : sArr) {
    			sb.append(s);
    		}
    		set.add(sb.toString());
    		return;
    	}
    	// *을 정규식으로 변환한다. 
    	String reg = banned_id[idx].replace("*", "[\\w\\d]");
    	for(int i=0; i<user_id.length; i++) {
    		
    		// matches 메소드를 사용하여 판별.
    		if(!v[i] && user_id[i].matches(reg)) {
    			v[i] = true;
    			dfs(idx+1, str+" "+user_id[i], user_id, banned_id);
    			v[i] = false;
    		}
    	}
    }
}
