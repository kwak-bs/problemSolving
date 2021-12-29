package problemSolve7;

import java.util.LinkedList;
import java.util.Queue;

public class PM_43163 {
	// PM / 43163번 / bfs / 단어 변환 / Level3
	public static void main(String[] args) {
		
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		solution("hit", "cog", words);
	}
	static boolean v[];
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<info> q = new LinkedList<>();
        v = new boolean[words.length];
        q.add(new info(begin, 0));
        
        
        while(!q.isEmpty()) {
        	info now = q.poll();
        	
        	if(now.word.equals(target)) {
        		answer = now.count;
        		break;
        	}
        	
        	for(int i=0; i<words.length; i++) {
        		if(check(words[i], now.word)) {
        			if(!v[i]) {
        				v[i] = true;
        				q.add(new info(words[i], now.count+1));
        			}
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
    
    public static boolean check(String word, String now) {
    	int count = 0;
    	
    	for(int i=0; i<word.length(); i++) {
    		if(word.charAt(i) != now.charAt(i)) {
    			count++;
    		}
    		if(count > 1) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    private static class info {
    	String word;
    	int count;
    	
    	public info(String word, int count) {
    		this.word = word;
    		this.count = count;
    	}
    }
}
