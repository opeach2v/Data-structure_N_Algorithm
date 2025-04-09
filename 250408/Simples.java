public class Simples {
    public int solution(String binomial) {
        int answer = 0;

        int op = 0; // op 인덱스 저장
        String a = "";
        String b = "";
        for(int i = 0; i < binomial.length(); i++) {
            if(!(binomial.charAt(i) >= '0' && binomial.charAt(i) <= '9')) {    // 숫자가 아님(op라는 뜻)
                op = i + 1; // 숫자 뒤 공백 한 번 뛰어넘고고 같이 저장
                break;
            }
        }

        for(int i = 0; i < op - 1; i++) {   // 계산하는 for문 (op 앞 뒤 공백 제외하고)
            a += binomial.charAt(i);   // op 앞 쪽 숫자 넣어주기
        }
        for(int j = op + 1; j < binomial.length(); j++) {
            b += binomial.charAt(j);    // op 뒤 쪽 숫자 넣어주기기
        }

        String c = "";
        c += binomial.charAt(op);
        switch(c.charAt(0)) {
            case '+':
                answer = Integer.parseInt(a) + Integer.parseInt(b.trim());
                break;
            case '-':
                answer = Integer.parseInt(a) - Integer.parseInt(b.trim());
                break;
            case '*':
                answer = Integer.parseInt(a) * Integer.parseInt(b.trim());
                break;
            case '/':
                answer = Integer.parseInt(a) / Integer.parseInt(b.trim());
                break;
            default:
                break;
        }

        return answer;
    }

    public static void main(String[] args) {
        String binomial = "43 + 12";
        int result = 0;

        Simples s = new Simples();
        result = s.solution(binomial);

        System.out.println(result);
    }
}
