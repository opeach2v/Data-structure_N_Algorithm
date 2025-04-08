public class BaboKeyborad {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        int keyIndex = 0;
        int tarCount = 0;
        int targetCount = 0;    // target은 처음부터 시작해서 카운트 나눠씀

        String[] keyS = {}; // keymap의 split
        String[] tarS = {}; // targets의 split
        tarS = targets[tarCount].split("");    // 타켓은 처음 문자열부터 먼저 끝내고 나서 그 뒤 계산함
        

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        int[] result = {};

        for(int z = 0; z < result.length; z++) {
            System.out.print(result +" ");
        }
    }
}