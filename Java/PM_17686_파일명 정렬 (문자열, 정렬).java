package problemSolve5;

import java.util.Arrays;
import java.util.Comparator;

public class PM_17686 {
	// PM / 17686번 / 파일명 정렬 / 문자열, 정렬 / Level2 / 2018 카카오 블라인드 채용 3차
	public static void main(String[] args) {
		solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"});
	}
	
    public static String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>(){
           @Override
           public int compare(String s1, String s2) {
               String[] f1 = detach(s1);
               String[] f2 = detach(s2);
               
               String h1 = f1[0];
               String h2 = f2[0];
               
               // HEAD 가 같으면
               if(h1.equals(h2)) {
                   // NUMBER 오름 차순
                   int n1 = Integer.parseInt(f1[1]);
                   int n2 = Integer.parseInt(f2[1]);
                   
                   return n1 - n2;
               }
               // HEAD가 다르면 사전 순 정렬 
               else {
                   return h1.compareTo(h2);
               }
           }
           
           private String[] detach(String str) {
               String head = "";
               String num = "";
               String tail = "";
               
               int idx = 0;
               // HEAD
               for(; idx<str.length(); idx++) {
                   char ch = str.charAt(idx);
                   if(ch >= '0' && ch <= '9') break;
                   head += ch;
               }
               // NUMBER
               for(; idx<str.length(); idx++) {
                   char ch = str.charAt(idx);
                   if(!(ch >= '0' && ch <= '9')) break;
                   num += ch;
               }
               
               // TAIL
               for(; idx < str.length(); idx++) {
                   char ch = str.charAt(idx);
                   tail += ch;
               }
               
               
               String [] file= {head.toLowerCase(), num, tail};
               return file;
           }
       });
       return files;
   }

}
