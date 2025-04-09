public class ManyCount {
    public int solution(int[] array) {
        int answer = 0;
        int MaxCount = 0;
        int[] count = {};
        int i = 1;

        if(array.length == 1) {
            answer = 1;
            return answer;
        }

        while(i < array.length) {
            if(array[i] == array[i + 1]) {
                count++;
                i++;
            }
            else {
                if(array)
                i++;
            }
            MaxCount = count;   // array[0]이랑 같은 거의 count를 Max에 넣기
            count = 0;
            break;
        }

        answer = MaxCount;
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};
        int result = 0;

        ManyCount m = new ManyCount();
        result = m.solution(array);

        System.out.println(result);
    }
}
