public class Year2016 {
    public String solution(int a, int b) {
        String answer = "";
        String[] yo1 = {"SAT", "SUN", "MON", "TUE", "WED", "THU", "FRI"};
        int month = 1;
        int day = 1;    // 1월 1일 부터 시작.

        while(month <= a) {
            day += 7;
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if(day > b) {
                    if(month == a) {
                        break;
                    }
                    day -= 31;
                    month++;
                }
            }
            else if(month == 2) {
                if(day > b) {
                    if(month == a) {
                        break;
                    }
                    day -= 29;
                    month++;
                }
            }
            else if(month == 4 || month == 6 || month == 9 || month == 11) {
                if(day > b) {
                    if(month == a) {
                        break;
                    }
                    day -= 30;
                    month++;
                }
            }
        }
        if(day > 0) {  // day가 0보다 크면
            day -= b;
            if(day >= 7) {
                day -= 7;
            }
            answer = yo1[yo1.length - 1 - day];
        }

        return answer;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 24;
        String res = "";

        Year2016 y = new Year2016();
        res = y.solution(a, b);

        System.out.println(res);
    }
}