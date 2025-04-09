public class BetweenX {
    public int[] solution(String myString) {
        if(myString.endsWith("x")) {
            myString += "1"; // 임의로 문자열 하나 추가해줌
        }

        String[] str = new String[myString.length()];
        if(myString.endsWith("1")) {    // 1로 끝난다면
            str = myString.split("x");
            str[str.length - 1] = "";   // 맨 마지막 공백으로 바꿔줌
        }
        else {
            str = myString.split("x"); // x를 기준으로 나누기만 함
        }
        int[] answer = new int[str.length];

        for(int i = 0; i < str.length; i++) {
            if(str[i].equals("")) { // 공백이라면
                answer[i] = 0;
            }
            else {
                answer[i] = str[i].length();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String myString = "oxooxoxxox";
        int[] result = {};

        BetweenX b = new BetweenX();
        result = b.solution(myString);

        System.out.println(result);
    }
}
