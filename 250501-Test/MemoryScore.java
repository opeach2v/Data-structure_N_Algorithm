public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int resultNum = 0;

        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                for(int k = 0; k < name.length; k++) {
                    if(name[k].equals(photo[i][j])) {   // photo에 있는 이름이 name에 존재하면
                        answer[resultNum] += yearning[k];
                        break;
                    }
                }
            }
            // photo가 넘어가면 resultNum도 하나 추가
            resultNum++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        int[] res = {};

        MemoryScore m = new MemoryScore();
        res = m.solution(name, yearning, photo);
    }
}