public class DescendingStr {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");

        // 내림차순으로 정렬
        for(int i = 0; i < str.length - 1; i++) {
            for(int j = str.length - 1; j > i; j--) {
                if(str[j - 1].charAt(0) < str[j].charAt(0)) {
                    String temp = str[j - 1];
                    str[j - 1] = str[j];
                    str[j] = temp;
                }
            }
        }

        for(int i = 0; i < str.length; i++) {
            answer += str[i];
        }

        return answer;
    }
}