public class BigNum {
    public String solution(String number, int k) {
        String answer = "";
        String temp = "";
        String[] numS = number.split("");
        String[] maxStrings = new String[number.length() - k]; // 가장 큰 수들 골라서 저장 (전체 길이 중 k만큼 뺀 수만 존재해야 함.)
        
        int maxIndex = 0;
        int i = 0;
        // 맨 처음부터 큰 수들을 찾아서 저장장
        while(i < numS.length) {
            for(int a = 0; a < numS.length; a++) {
                if(numS[maxIndex] < numS[a]) {
                    
                }
            }
        }
    }

    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        String result = "";

        BigNum b = new BigNum();
        result = b.solution(number, k);

        System.out.println(result);
    }
}