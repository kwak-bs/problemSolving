package problemSolve4;

public class PM_43163 {
	// PM / 43163번 / 단어 변환 / DFS  / Level3
    static int answer;
    static boolean v[];
	public static void main(String[] args) {
		solution("hit", "cog",new String[] {"hot", "dot", "dog", "lot", "log"});
	}
    public static int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        v = new boolean[words.length];

        
        dfs(begin, target, words, 0);
        answer = (answer == Integer.MAX_VALUE) ? 0 : answer; 
        return answer;
    }
    // 모든 단어 탐색 (50개밖에 없어서 탐색 가능)
    public static void dfs(String begin, String target, String[] words,int count) {
        if(begin.equals(target)) {
            answer = (answer>count) ? count : answer;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!v[i] && check(begin, words[i])) {
                v[i] = true;
                dfs(words[i], target, words, count+1);
                v[i] = false;
            }
        }
    }
    // 다음 단어(탐색 될 단어)와 비교. 차이가 하나밖에 안나면 탐색 가능.
    public static boolean check(String str, String next) {
        int count =0;

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != next.charAt(i)) {
                count++;
            }
        }
        
        return count == 1 ? true : false;
    }
}
