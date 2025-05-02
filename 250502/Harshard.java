public class Harshard {
    public boolean solution(int x) {
        int sum = 0;    // x의 자릿수의 합
        int copyX = x;  // x 복사본(나중에 하샤드인지 아닌지를 확인할 때 쓸 것)

        if(x >= 10) {   // 일의 자리가 아니면
            while(x > 0) {
                sum += x % 10;  // 일의 자리 더해주기
                x /= 10;    // 일의 자리 떼주기
            }
        }
        else {
            sum = x;
        }

        if(copyX % sum == 0) {  // 나누어 떨어지면
            return true;
        }
        else {
            return false;
        }
    }
}