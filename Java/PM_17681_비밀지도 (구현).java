package problemSolve4;

public class PM_17681 {
	// PM / 17681번 / [1차]비밀지도 / 구현  / Level1 / 2018 카카오 BLIND
	public static void main(String[] args) {
		solution(5, new int[] {9,20,28,18,11}, new int[] {30,1,21,17,28});
	}
	
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0; i<n; i++) {
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            while(str1.length() < n) {
                str1 = "0"+str1;
            }
            while(str2.length() < n) {
                str2 = "0" +str2;
            }
            String ans = "";
            for(int j=0; j<n; j++) {
                char t1 = str1.charAt(j);
                char t2 = str2.charAt(j);
                
                if(t1 == '1' || t2 == '1') {
                    ans+="#";
                }
                else if(t1 == '0' && t2 == '0') {
                    ans += " ";
                }
            }
            answer[i] = ans;
        }
        
        return answer;
    }
}
