package problemSolve5;

public class PM_77885 {
   // PM / 77885번 / 2개 이하로 다른 비트 / 구현, 수학, 문자열  / Level2 / 월간 코드 챌린지 시즌2
   public static void main(String[] args) {
      
      solution(new long[] {2,7});
   }
   
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
           answer[i] = solve(numbers[i]);
        }
        return answer;
    }
    
    public static long solve(long number) {
       long result = number;
       
       // 짝수는 +1 (맨 마지막 0만 1로 바꿔주면 됨)
       if(number % 2 == 0) {
          result += 1;
       }
       // 홀수는 0이 있는 경우 -> 가장 낮은 0, 1 -> 1, 0
       // 0이 없는 경우 -> +1 한다음 가장 높은 10을 제외한 0 -> 1
       else {
          String Binary = Long.toBinaryString(result);
          
          int firstZero = Binary.lastIndexOf("0");
          // 0이 있으면
          if(firstZero != -1) {
        	  int lastOne = Binary.indexOf("1", firstZero);
        	  Binary = Binary.substring(0, firstZero) + "1" 
        			  + Binary.substring(firstZero+1, lastOne) + "0"
        			  + Binary.substring(lastOne+1, Binary.length());
          }
          // 0이 없으면 
          else {
        	  result += 1;
        	  Binary = Long.toBinaryString(result);
        	  Binary = Binary.substring(0,2) + Binary.substring(2, Binary.length()).replaceAll("0", "1");
          }
          result = Long.parseLong(Binary, 2);
       }
       return result;
    }
}