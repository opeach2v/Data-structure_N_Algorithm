public class NoNum {
    public int solution(int[] numbers) {
        int answer = 0;
        int i = 0, j = 0;
        int count = 0;
        while(i <= 9) {
            count = 0;
            for(j = 0; j < numbers.length; j++) {
                if(i == numbers[j]) {   // 둘이 같으면 숫자 존재한다는 뜻
                    i++;
                    continue;
                }
                count++;
            }
            if(count == numbers.length) {
                answer += i;
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        int result = 0;

        NoNum n = new NoNum();
        result = n.solution(numbers);

        System.out.println(result);
    }
}