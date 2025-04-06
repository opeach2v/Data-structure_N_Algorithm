public class LengthCalculation {
    public int solution(int[] num_list) {
        int answer = 0;

        if(num_list.length > 10) {  // 리스트 길이가 11 이상이면(10 초과면)
            for(int i = 0; i < num_list.length; i++) {  // 더해야 함
                answer = answer + num_list[i];
            }
        }
        else {  // 10 이하면
            answer = 1;
            for(int i = 0; i < num_list.length; i++) {  // 곱해야 함
                answer = answer * num_list[i];
            }
        }

        return answer;
    }
}
