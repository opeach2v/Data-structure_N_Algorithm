public class NearKan {
    public int solution(String[][] board, int h, int w) {
        int sameColor = 0;  // 같은 색 칸 개수 저장할 변수
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        for(int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if(h_check == -1 || w_check == -1) continue;

            if((h_check >= 0 && h_check < board.length) && (w_check >= 0 && w_check < board.length)) {
                if(board[h][w].equals(board[h_check][w_check])) {
                    sameColor++;
                }
            }
        }

        return sameColor;
    }

    public static void main(String[] args) {
        String[][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        int h = 0;
        int w = 1;
        int res = 0;

        NearKan n = new NearKan();
        res = n.solution(board, h, w);
    }
}