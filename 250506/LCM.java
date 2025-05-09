public class LCM {
    public int solution(int[] arr) {
        int answer = 1;
        int even = 0;   // 짝수
        int div = 0;    // 나눌 숫자

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) even++;
        }
        if(even == arr.length) {
            div = 2;
        }
        else div = 1;
        
        for(int i = 0; i < arr.length; i++) {
            arr[i] /= div;
        }

        for(int i = 0; i < arr.length; i++) {
            answer *= arr[i];
        }

        return answer * div;
    }
}