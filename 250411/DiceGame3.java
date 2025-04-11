public class DiceGame3 {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;

        if(a == b && b == c && c == d) {
            answer = 1111 * a;  // 뭐든 다 똑같음
        }

        else if((a == b && b == c)|| (a == c && c == d)
            || (a == b && b == d) || (b == c && c == d)) {  //  세 주사위에서 나온 값만 같다면
                if(a == b && b == c) answer = (10 * a + d) * (10 * a + d);
                if(a == c && c == d) answer = (10 * a + b) * (10 * a + b);
                if(a == b && b == d) answer = (10 * a + c) * (10 * a + c);
                if(b == c && c == d) answer = (10 * b + a) * (10 * b + a);
        }

        else if((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {   // 두 주사위씩 값이 같다면
            if(a == b && c == d) {
                if(a < c) { // 음수일 경우
                    answer = (a + c) * -(a - c);
                }
                else {
                    answer = (a + c) * (a - c);
                }
            }
            if(a == c && b == d) {
                if(a < b) { // 음수일 경우
                    answer = (a + b) * -(a - b);
                }
                else {
                    answer = (a + b) * (a - b);
                }
            }
            if(a == d && b == c) {
                if(a < b) { // 음수일 경우
                    answer = (a + b) * -(a - b);
                }
                else {
                    answer = (a + b) * (a - b);
                }
            }
        }

        else if((a == b) || (a == c) || (a == d) || (b == c) || (b == d) || (c == d)) {    // 두 주사위에 값만 같고 나머지는 다를 경우
            if(a == b) answer = c * d;
            if(a == c) answer = b * d;
            if(a == d) answer = b * c;
            if(b == c) answer = a * d;
            if(b == d) answer = a * c;
            if(c == d) answer = a * b;
        }

        else {  // 다 다르면
            int min = a;
            if(min > b) {
                min = b;
            }
            if(min > c) {
                min = c;
            }
            if(min > d) {
                min = d;
            }
            answer =  min;
        }

        return answer;
    }
}