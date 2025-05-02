public class DivNumArray {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        int[] div = new int[arr.length];

        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % divisor == 0) { // 나누어 떨어진다는 뜻
                div[count] = arr[i];
                count++;
            }
        }
        
        if(count == 0) {    // 나누어 떨어진 게 없다는 거
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else if(count > 0) {
            answer = new int[count];
            for(int i = 0; i < answer.length; i++) {
                answer[i] = div[i]; // 있는 수만큼 복사
            }

            // 그리고 버블 정렬
            for(int i = 0; i < answer.length - 1; i++) {
                for(int j = answer.length - 1; j > i; j--) {
                    if(answer[j - 1] > answer[j]) {
                        int temp = answer[j - 1];
                        answer[j - 1] = answer[j];
                        answer[j] = temp;
                    }
                }
            }
        }

        return answer;
    }

    // 20분 44초

    public static void main(String[] args) {
        int[] arr = {2, 36, 1, 3};
        int div = 1;

        int[] result = {};

        DivNumArray d = new DivNumArray();
        result = d.solution(arr, div);
    }
}