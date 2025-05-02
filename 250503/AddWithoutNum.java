public class AddWithoutNum {
    public int solution(int[] numbers) {
        int answer = 0;
        int count = 0;

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < numbers.length; j++) {
                if(i == numbers[j]) {
                    count++;
                }
            }
            if(count == 0) {   // count가 0이면 같은 게 없다는 뜻
                answer += i;
            }
            count = 0;
        }

        return answer;
    }
}