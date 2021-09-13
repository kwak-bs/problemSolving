package problemSolve6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class PM_84325 {
	// PM / 84325�� / ��Ŭ�� ç���� / ����, ���� / 4���� 
	public static void main(String[] args) {
		
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", 
				"CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", 
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", 
				"PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", 
				"GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7,5,5};
		solution(table, languages, preference);
	}
	// ��ȣ ���, ���� ���� 
	static HashMap<String, Integer> map = new HashMap<>();
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int max = Integer.MIN_VALUE;
        
        setMap(languages, preference);

        // ������ ����.
        Arrays.sort(table, new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				String[] o1_split = o1.split(" ");
				String[] o2_split = o2.split(" ");
				return o1_split[0].compareTo(o2_split[0]);
			}
        });
        
        // �� ������ �� ���� ���.
        for(int i=0; i<table.length; i++) {
        	String []split = table[i].split(" ");
        	String part = split[0];
        	int sum = 0;
        	int point = 5;
        	sum = calculate(split, point, sum);
        	
        	if(sum > max) {
        		max = sum;
        		answer = part;
        	}
        }
        return answer;
    }
    
    public static int calculate(String split[], int point, int sum) {
    	for(int j=1; j<split.length; j++) {
    		String lang = split[j];
    		if(map.containsKey(lang)) {
    			sum += (point * map.get(lang)); 
    		}
    		point--;
    	}
    	
    	return sum;
    }
    
    public static void setMap(String[] languages,int[] preference) {
        for(int i=0; i<languages.length; i++) {
        	map.put(languages[i], preference[i]);
        }
    }
}
