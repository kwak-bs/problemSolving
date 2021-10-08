package problemSolve7;
import java.util.HashMap;

public class PM_86971 {
	// PM / 86971번 / 위클리 챌린지 / 그래프 / 9주차_전력망을 둘로 나누기

	public static void main(String[] args) {
		solution(9, new int[][] {
			{9,7},
			{8,7},
			{4,7},
			{1,3},
			{3,2},
			{4,3},
			{5,4},
			{4,6},
		});
	}
	static int parent[], answer = Integer.MAX_VALUE;
    public static int solution(int n, int[][] wires) {
        parent = new int[n+1];
        
        parentInit();

        for(int i=0; i<wires.length; i++) {
        	for(int j=0; j<wires.length; j++) {
        		if(i==j) continue;
        		union(wires[j][0],wires[j][1]);
        	}
        	compareParent();
            parentInit();
        }

        return answer;
    }
    
    public static void parentInit() {
        for(int i=1; i<parent.length; i++) {
        	parent[i] = i;
        }
    }
    
    public static void compareParent() {
    	HashMap<Integer, Integer> parentCount = new HashMap<>();
    	
    	for(int i=1; i<parent.length; i++) {
    		parentCount.put(parent[i], parentCount.getOrDefault(parent[i], 0)+1);
    	}
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int pa : parentCount.keySet()) {
    		int count = parentCount.get(pa);

    		if(max < count) {
    			max = count;
    		}
    		if(min > count) {
    			min = count;
    		}
    	}
    	answer = Math.min(answer, max - min);
    }
    
    public static void union (int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if(a > b) {
    		// 기존 a를 부모로 하던 자식들의 값도 b로 바꿔준다.
    		// 정렬이 안된 배열 처리법.
    		for(int i=1; i<parent.length; i++) {
    			if(parent[i] == a) {
    				parent[i] = b;
    			}
    		}
    	}
    	else {
    		for(int i=1; i<parent.length; i++) {
    			if(parent[i] == b) {
    				parent[i] = a;
    			}
    		}
    	}
    }
    
    public static int find(int a) {
    	if(a == parent[a]) {
    		return a;
    	}
    	else {
    		return parent[a] = find(parent[a]);
    	}
    }
}
