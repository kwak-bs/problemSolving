package problemSolve7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ_1148 {
	// BOJ / 1148번 / 단어 만들기 / 구현 / 실버1
	static int alp[];
	static int[][] dictionary;
	static HashMap<Character, Integer> circleAlp;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dictionary = new int[200000][26];
		int idx = 0;
		while(true) {
			
			String str = br.readLine(); 
			if(str.equals("-")) {
				break;
			}
			for(int i=0; i<str.length(); i++) {
				dictionary[idx][str.charAt(i)-'A']++;
			}
			idx++;
		}
		
		while(true) {
			
			String str = br.readLine();
			alp = new int[26];
			circleAlp = new HashMap<>();
			if(str.equals("#")) {
				break;
			}
			
			for(int i=0; i<str.length(); i++) {
				alp[str.charAt(i)-'A']++;
			}
			setCircle(str);
			calMinMax();
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
	public static void calMinMax() {
		int min = Integer.MAX_VALUE; 
		int max = Integer.MIN_VALUE;
		ArrayList<Character> minAlp = new ArrayList<>();
		ArrayList<Character> maxAlp = new ArrayList<>();
		for(char key : circleAlp.keySet()) {
			int value = circleAlp.get(key);
			if(min > value) {
				min = value;
			}
			if(max < value) {
				max = value;
			}
		}
		for(char key : circleAlp.keySet()) {
			int value = circleAlp.get(key);
			if(min == value) {
				minAlp.add(key);
			}
			// else if 했다가 계속 틀렸습니다 뜸;; 후 
			if(max == value) {
				maxAlp.add(key);
			}
		}
		Collections.sort(minAlp);
		Collections.sort(maxAlp);
		
		for(int i=0; i<minAlp.size(); i++) {
			sb.append(minAlp.get(i));
		}
		sb.append(" ");
		sb.append(min+ " ");

		for(int i=0; i<maxAlp.size(); i++) {
			sb.append(maxAlp.get(i));
		}
		sb.append(" ");
		sb.append(max+ " ");			
		
	}
	
	public static void setCircle(String str) {
		HashSet<Character> set = new HashSet<>();
		
		for(int i=0; i<str.length(); i++) {
			char circle = str.charAt(i);
			if(!set.add(circle)) continue;
			
			int count = 0;
			for(int d=0; d<dictionary.length; d++) {
				boolean zeroChk = true;
				boolean flag = true;
				if(dictionary[d][circle-'A'] == 0) continue;
				for(int j=0; j<dictionary[d].length; j++) {
					if(dictionary[d][j] != 0) zeroChk = false;
					if(dictionary[d][j] > alp[j]) {
						flag = false;
						break;						
					}
				}
				if(zeroChk) break;
				if(flag) count++;
			}
			circleAlp.put(circle, count);
		}
	}
}
