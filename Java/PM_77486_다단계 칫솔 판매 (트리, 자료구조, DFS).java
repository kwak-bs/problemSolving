package problemSolve5;

import java.util.HashMap;

public class PM_77486 {
	// PM / 77486번 / 다단계 칫솔 판매 / 자료구조, Tree, DFS / Level3 / 2021 Dev-Matching: 웹 백엔드 개발
	public static void main(String[] args) {

		solution(new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
				new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
				new String[] {"young", "john", "tod", "emily", "mary"},
				new int[] {12, 4, 2, 5, 10});
	}

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    	int[] answer = new int[enroll.length];
    	HashMap<String, Person> people = new HashMap<>();
    	
    	people.put("-", new Person("-"));
    	for(int i=0; i<enroll.length; i++) {
    		people.put(enroll[i], new Person(enroll[i]));
    	}
    	for(int i=0; i<referral.length; i++) {
    		people.get(enroll[i]).parent = people.get(referral[i]);
    	}

    	for(int i=0; i<seller.length; i++) {
    		//System.out.println(people.get(seller[i]).name + " 휴 " + amount[i]*100);
    		addProfit(people.get(seller[i]), amount[i] * 100);
    	}
    	
    	for(int i=0; i<answer.length; i++) {
    		answer[i] = people.get(enroll[i]).profit;
    		System.out.println(answer[i]);
    	}
        return answer;
    }
    
    public static void addProfit(Person person, int profit) {

    	int profit_for_parent = profit / 10;
    	if(profit_for_parent != 0) {
    		person.profit += (profit - profit_for_parent);
    		if(person.parent != null) addProfit(person.parent, profit_for_parent);
    	}
    	else {
    		person.profit += profit;
    	}
    }
    static class Person {
    	String name; 
    	Person parent;
    	int profit;
    	public Person(String name) {
    		this.name = name;
    		this.parent = null;
    		this.profit = 0;
    	}
    }
}
