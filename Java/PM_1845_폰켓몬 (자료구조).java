package problemSolve5;

import java.util.HashSet;

public class PM_1845 {
	// PM / 1845번 / 폰켓몬 / 자료구조 / Level1 / 찾아라 프로그래밍 마에스터
	public static void main(String[] args) {

		solution(new int[] {3,1,2,3});
	}
	
    public static int solution(int[] nums) {

        int limit = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);

        }
        if(set.size() > limit) {
            return limit;
        }
        
        return set.size();
    }

}
