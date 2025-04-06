public class Lucky7 {
    public int solution(int[] array) {
        int count = 0;
        int num = 0;
        int i = 0;

        while(i < array.length) {
            if(num == 0) {
                num = array[i]; // 임시 저장
            }
            if(num > 9) { // 인덱스 안의 값이 일의 자리가 아니면서
                if(num % 10 == 7) {    // 떼어낸 1의 자리가 7이면 카운트
                    count++;
                    num /= 10;
                    if(num == 0) {
                        i++;
                    }
                }
                else {
                    if(num == 0) {
                        i++;
                    }
                    num /= 10;
                }
            }
            else {  // 인덱스 안의 값이 일의 자리이면서 7이면 카운트
                if(num == 7) {
                    count++;
                    num = 0;
                    i++;
                }
                else {
                    num = 0;
                    i++;
                    continue;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = {22,23,87,91,38,5388,50,563,2,5,1632,1,94,357,8729 };
        int count = 0;

        Lucky7 l = new Lucky7();
        count = l.solution(array);

        System.out.println(count);
    }
}