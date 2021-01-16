package problemSolve;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_5597 {

	public static void main(String[] args) {
		//BOJ / 5597번 / 과제 안 내신 분..?  / 구현  / 브2
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1; i<=30; i++) {
			al.add(i);
		}
		
		for(int i=0; i<28; i++) {
			int input = sc.nextInt();
			
			al.remove(al.indexOf(input));
		}
		
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}

}
