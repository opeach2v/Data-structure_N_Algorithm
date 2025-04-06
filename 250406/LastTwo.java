public class LastTwo {
    public int[] solution(int[] num_list) {
        int len = num_list.length;  // 리스트의 길이 저장
        int[] answer = new int[len + 1];
        
        for(int i = 0; i < len; i++) {
            answer[i] = num_list[i];    // answer에 원래 값 먼저 복사
        }

        if(num_list[len - 1] > num_list[len - 2]) {
            answer[len] = num_list[len - 1] - num_list[len - 2];
        }
        else {
            answer[len] = num_list[len - 1] * 2;
        }
        
        return answer;
    }
}