public class SmallString {
    public int solution(String t, String p) {
        int answer = 0;
        String[] s = t.split("");
        String smallString = ""; // 부분 문자열 비교할 것
        
        for(int i = 0; i < (s.length - p.length() + 1); i++) {
            for(int j = i; j < p.length() + i; j++) {
                smallString += s[j];
            }
            if(Long.parseLong(smallString) <= Long.parseLong(p)) {
                answer++;
                smallString = "";
            }
            else {
                smallString = "";
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        String t = "4835";
        String p = "305486";
        int res = 0;

        SmallString s = new SmallString();
        res = s.solution(t, p);
    }
}