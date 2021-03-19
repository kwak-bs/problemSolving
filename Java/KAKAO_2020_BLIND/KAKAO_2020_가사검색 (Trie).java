package problemSolve4;

public class KAKAO_2020_가사검색 {

	public static void main(String[] args) {
		
		KAKAO_2020_가사검색 c = new KAKAO_2020_가사검색();
		
		String [] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String [] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
		c.solution(words, queries);
	}
	
	class Trie {
		Trie[] child = new Trie[26];
		int count;
		int aletter = Character.getNumericValue('a');
		
		void insert(String str) {
			Trie curr = this; // 시작은 현재 객체 , curr는 root에서 시작하는거임.
			
			for(char ch : str.toCharArray()) {
				curr.count++;
				int idx = Character.getNumericValue(ch) - aletter;
				if(curr.child[idx] == null) {
					curr.child[idx] = new Trie();
				}
				curr = curr.child[idx];
			}
		}
		
		int search(String str) {
			Trie curr = this;
			for(char ch : str.toCharArray()) {
				if(ch == '?') return curr.count;
				
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if(curr == null) return 0;
			}
			
			return curr.count; // 여기까지 이르는 경우는 없을거임 , ? 문자가 없는거 처리할 수 잇음
		}
	}
	
	Trie[] TrieRoot = new Trie[10000];
	Trie[] RevTrieRoot = new Trie[10000];
	
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int ansIdx = 0;
        
        for(String str : words) {
        	int idx = str.length() - 1;
        	if(TrieRoot[idx] == null) {
        		TrieRoot[idx] = new Trie();
        		RevTrieRoot[idx] = new Trie();
        	}
        	
        	TrieRoot[idx].insert(str);
        	str = new StringBuilder(str).reverse().toString();
        	RevTrieRoot[idx].insert(str);
        }
        
        for(String str : queries) {
        	int idx = str.length() - 1;
        	if(TrieRoot[idx] == null) {
        		answer[ansIdx++] = 0;
        		continue;
        	}
        	// 정방향 검사
        	if(str.charAt(0) != '?') {
        		answer[ansIdx++] = TrieRoot[idx].search(str);
        	}
        	// 역방향 검사
        	else {
        		str = new StringBuilder(str).reverse().toString();
        		answer[ansIdx++] = RevTrieRoot[idx].search(str);
        	}
        }
        
        return answer;
    }
}
