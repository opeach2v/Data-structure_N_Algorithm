public class ConnectNum {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";

        for(int num : num_list) {
            if(num % 2 == 1) {  // 홀수
                odd += String.valueOf(num);   // 홀수만 odd에 붙이기
            }
            else {
                even += String.valueOf(num);  // 짝수만 붙이기
            }
        }
        answer = Integer.parseInt(odd) + Integer.parseInt(even);

        return answer;
    }
}