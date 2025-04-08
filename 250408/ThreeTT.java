public class ThreeTT {
    public String[] solution(String myStr) {
        String[] answer = new String[myStr.length()];
        String[] realAnswer = {};

        String[] str = myStr.split("");
        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("a") || str[i].equals("b") || str[i].equals("c")) {
                str[i] = str[i].replace(str[i], " "); // a, b, c는 공백으로 만들기
            }
        }

        int e = 0;
        while(true) { // 맨 처음 공백 찾기
            if(str[e].equals(" ")) {
                e++;
                if(e >= str.length) {   // 다 공백이라는 뜻
                    e--;
                    realAnswer = new String[1];
                    realAnswer[0] = "EMPTY";
                    return realAnswer;
                }
            }
            else {  // 앞에 공백 다 건너뛰고 문자를 만났을 땐 나오기
                break;
            }
        }

        int a = 0;
        while (true) { 
            while(!str[e].equals(" ")) {  // str[e]가 공백이기 전까지
                answer[a] += str[e];
                e++;
                if(e >= str.length) {
                    e--;
                    break;
                }
            }
            if(str[e - 1].equals(" ") && !(e == str.length - 1)) {
                a--;
            }
            a++;
            e++;
            if(e >= str.length) {
                e--;
                break;
            }
        }
        realAnswer = new String[a];
        for (int i = 0; i < realAnswer.length; i++) {
            realAnswer[i] = answer[i].substring(4);
        }

        return realAnswer;
    }

    public static void main(String[] args) {
        String myStr = "abcd";
        String[] result = {};

        ThreeTT t = new ThreeTT();
        result = t.solution(myStr);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
