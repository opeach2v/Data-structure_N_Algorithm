public class NextBigNum {
    public int solution(int n) {
        int answer = 0;
        int count = 0;   // n의 2진수 변환 후 1의 개수
        int count2 = 0; // 다음 수의 2진수 변환 후 1의 개수 (계속 업데이트)
        int up = 0;
        String n2 = ""; // n을 2진수로 변환 (계속 업데이트)
        
        // 2진수 만들기
        while(n > 0) {
            if(n % 2 == 0) {
                n2 = "0" + n2;
            }
            else {
                n2 = "1" + n2;
                count++;    // 1이 몇 개인지
            }
            n /= 2;
        }
        
        while(true) {   // n보다 크면서 1 카운트가 같아질 때까지
            String[] ns = n2.split("");
            n2 = "";
            count2 = 0;
            for(int i = ns.length - 1; i >= 0; i--) {
                if(i == ns.length - 1) {    // 맨 끝에만 1 더해줌
                    if(Integer.parseInt(ns[i]) + 1 == 2) {  // 1을 더했을 때 2가 되면
                        ns[i] = "0";
                        up++;   // 1 올렸다는 뜻으로
                        continue;
                    }
                    else {  // 1이면
                        ns[i] = "1";
                        break;
                    }
                }
                if(up == 1) {   // 1이 올려진 상태면
                    if(i == 0 && ns[i].equals("1")) {   // up이 1인데 i가 0이고, ns[i]가 이미 1이면
                        ns[i] = "0";
                        up--;
                        n2 += "1";
                        count2++;
                        break;
                    }
                    if(Integer.parseInt(ns[i]) + up == 2) { // 올린 거랑 더했을 때 2가 되면
                        ns[i] = "0";
                    }
                    else {  // 1이 되면
                        ns[i] = "1";
                        up--;   // 올림 수 없어짐
                        break;  // 그리고 멈춤
                    }
                }
            }
            // n2로 다시 만들어줌
            for(int i = 0; i < ns.length; i++) {
                n2 += ns[i];
                if(ns[i].equals("1")) count2++;
            }

            if(count2 == count) break;
        }

        int mul2 = 1; 
        for(int i = n2.length() - 1; i >= 0; i--) {
            answer += Integer.parseInt(String.valueOf(n2.charAt(i))) * mul2;
            mul2 *= 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 78;
        int res = 0;

        NextBigNum b = new NextBigNum();
        res = b.solution(n);
    }
}