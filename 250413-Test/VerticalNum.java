public class VerticalNum {
    public String solution(String my_string, int m, int c) {
        String answer = "";
        String[] mymy_string = my_string.split("");
        String[][] mystring = new String[my_string.length() / m][m];
        int a = 0;

        for(int i = 0; i < my_string.length() / m; i++) {
            for(int j = 0; j < m; j++) {
                mystring[i][j] = mymy_string[a];
                a++;
            }
        }

        for(int i = 0; i < mystring.length; i++) {
            answer += mystring[i][c - 1];
        }

        return answer;
    }
}