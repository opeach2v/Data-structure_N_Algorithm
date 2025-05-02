public class FindKimInSeoul {
    public String solution(String[] seoul) {
        String answer = "";

        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {    // 김서방이 있으면
                answer = "김서방은 " +i +"에 있다";
            }
        }
        
        return answer;
    }
}