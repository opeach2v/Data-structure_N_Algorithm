public class TurnB {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        if(direction.equals("right")) { // 오른쪽으로 돌리기기
            for(int i = 1; i <= numbers.length; i++) {   // 배열 길이만큼 돌리기
                if(i == numbers.length) {   // numbers의 맨 마지막 배열에 도착하면
                    answer[0] = numbers[i - 1];    // 결과의 맨 첫 배열로
                }
                else {
                    answer[i] = numbers[i - 1];
                }
            }
        }
        else {  // 왼쪽으로 돌리기
            for(int i = 0; i <= numbers.length - 1; i++) {   // 배열 길이 - 1만큼 돌리기
                if(i == 0) {   // numbers의 맨 앞 배열은
                    answer[numbers.length - 1] = numbers[i];    // 맨 마지막 결과 배열에 넣기
                }
                else {
                    answer[i - 1] = numbers[i];
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        String direction = "right";
        int[] result = {};

        TurnB t = new TurnB();
        result = t.solution(numbers, direction);

        System.out.println(result);
    }
}
