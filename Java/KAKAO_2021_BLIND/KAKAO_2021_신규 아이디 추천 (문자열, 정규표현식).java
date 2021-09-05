package problemSolve6;

import java.io.IOException;

public class PM_72410 {
	// PM / 72410번 / 신규 아이디 추천 / 구현, 문자열 / Level1 / 2021 KAKAO BLIND
	
	public static void main(String[] args) throws IOException {
		
		String new_id = "abcdefghijklmn.p";
		
		solution(new_id);
	}
	
	public static String solution(String new_id) {
		
		// 1단계
		new_id = new_id.toLowerCase();
		
		// 2단계
		new_id = new_id.replaceAll("[^-_0-9a-z.]", "");
		
		// 3단계
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		// 4단계
		new_id = new_id.replaceAll("^[.]|[.]$", "");

		// 5단계
		if(new_id.length() == 0) {
			new_id = "a";
		}
		
		// 6단계
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			new_id = new_id.replaceAll("^[.]|[.]$", "");
		}

		// 7단계
		char last = new_id.charAt(new_id.length()-1);
		while(new_id.length() <= 2) {
			new_id += last;
		}

		return new_id;
	}

}
