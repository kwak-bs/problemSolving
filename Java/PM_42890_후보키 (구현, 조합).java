package problemSolve5;

import java.util.ArrayList;
import java.util.HashSet;

public class PM_42890 {
	// PM / 42890번 / 후보키 / 구현,조합 / Level2 / 2019 카카오 블라인드 채용
    static ArrayList<HashSet<Integer>> cdKey;
    static String map[][];
    static int answer, len;
	public static void main(String[] args) {
		
		solution(new String[][] {
			{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","computer","4"},
			{"500","muzi","music","3"},
			{"600","apeach","music","2"}
		});
	}

    public static int solution(String[][] relation) {
        answer = 0;
        cdKey = new ArrayList<>();
        map = relation;
        len = relation[0].length;
        // 속성 갯수만큼 탐색 
        for(int i=1; i<=len; i++) {
            makeSet(-1, i, 0, new HashSet<Integer>());
        }
        
        return answer;
    }
    public static void makeSet(int index, int target, int count, HashSet<Integer> set) {
        
        if(count == target) {
            // 유일성을 만족하는지
            if(!isUnique(set)) {
                return;
            }
            // 최소성을 만족하는지 
            for(HashSet<Integer> key : cdKey) {
                //set은 key의 원소들을 모두 포함한다.
                if(set.containsAll(key)) {
                    return;
                }
            }
            cdKey.add(set);
            answer++;
            return;
        }
        
        for(int i=index+1; i<len; i++) {
            // ()안에 set을 넣어줬기 때문에 newSet은 set의 값을 이미 갖고있다.
            HashSet<Integer> newSet = new HashSet<Integer>(set);
            newSet.add(i);
            makeSet(i, target, count + 1, newSet);
        }
    }
    public static boolean isUnique(HashSet<Integer> set) {
        
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0; i<map.length; i++) {
            String temp = "";
            for(int index : set) {
                temp+= map[i][index];
            }
            if(!list.contains(temp)) {
                list.add(temp);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
