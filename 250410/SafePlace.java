public class SafePlace {
    public int solution(int[][] board) {
        int count = 0;  // 안전지대 수 세기
        int boardSize = board.length * board.length;

        // 모두 지뢰일 때
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {  // 지뢰 발견!
                    count++;
                }
            }
        }
        if(count == boardSize) {    // 지뢰밭
            return 0;
        }
        else {
            count = 0;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {  // 지뢰 발견!
                    // 만약 board 길이가 2 이하인데 지뢰가 하나라도 발견하면 다 위험지대
                    if(board.length <= 2) { // 지뢰밭
                        return 0;
                    }
                    // 그 주변 2로 만들기
                    // 만약 모서리가 1이면
                    int a = i;
                    int b = j;
                    if(i == 0 && j == 0) {
                        if(board[a][b + 1] != 1) board[a][b + 1] = 2;
                        if(board[a + 1][b + 1] != 1) board[a + 1][b + 1] = 2;
                        if(board[a + 1] [b] != 1) board[a + 1] [b] = 2;
                        continue;
                    }
                    if(i == 0 && j == board[i].length - 1) {
                        if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                        if(board[a + 1][b - 1] != 1) board[a + 1][b - 1] = 2;
                        if(board[a + 1][b] != 1) board[a + 1] [b] = 2;
                        continue;
                    }
                    if(i == board.length - 1 && j == 0) {
                        if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                        if(board[a - 1][b + 1] != 1) board[a - 1][b + 1] = 2;
                        if(board[a + 1][b + 1] != 1) board[a + 1] [b + 1] = 2;
                        continue;
                    }
                    if(i == board.length - 1 && j == board[i].length - 1) {
                        if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                        if(board[a - 1][b - 1] != 1) board[a - 1][b - 1] = 2;
                        if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                        continue;
                    }

                    // 한쪽 벽에만 붙어있을 경우
                    if(i == 0) {
                        if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                        if(board[a][b + 1] != 1) board[a][b + 1] = 2;
                        if(board[a + 1][b - 1] != 1) board[a + 1][b - 1] = 2;
                        if(board[a + 1][b] != 1) board[a + 1][b] = 2;
                        if(board[a + 1][b + 1] != 1) board[a + 1][b + 1] = 2;
                        continue;
                    }
                    if(i == board.length - 1) {
                        if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                        if(board[a][b + 1] != 1) board[a][b + 1] = 2;
                        if(board[a - 1][b - 1] != 1) board[a - 1][b - 1] = 2;
                        if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                        if(board[a - 1][b + 1] != 1) board[a - 1][b + 1] = 2;
                        continue;
                    }
                    if(j == 0) {
                        if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                        if(board[a + 1][b] != 1) board[a + 1][b] = 2;
                        if(board[a - 1][b + 1] != 1) board[a - 1][b + 1] = 2;
                        if(board[a][b + 1] != 1) board[a][b + 1] = 2;
                        if(board[a + 1][b + 1] != 1) board[a + 1][b + 1] = 2;
                        continue;
                    }
                    if(j == board[i].length - 1) {
                        if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                        if(board[a + 1][b] != 1) board[a + 1][b] = 2;
                        if(board[a - 1][b - 1] != 1) board[a - 1][b - 1] = 2;
                        if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                        if(board[a + 1][b - 1] != 1) board[a + 1][b - 1] = 2;
                        continue;
                    }

                    // 주변 8칸이 모두 안전지대가 아닌 경우
                    if(board[a - 1][b - 1] != 1) board[a - 1][b - 1] = 2;
                    if(board[a - 1][b] != 1) board[a - 1][b] = 2;
                    if(board[a - 1][b + 1] != 1) board[a - 1][b + 1] = 2;
                    if(board[a][b - 1] != 1) board[a][b - 1] = 2;
                    if(board[a][b + 1] != 1) board[a][b + 1] = 2;
                    if(board[a + 1][b - 1] != 1) board[a + 1][b - 1] = 2;
                    if(board[a + 1][b] != 1) board[a + 1][b] = 2;
                    if(board[a + 1][b + 1] != 1) board[a + 1][b + 1] = 2;
                }
            }
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) {
                    count++;
                }
            }
        }

        return boardSize - count;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}};
        int res = 0;

        SafePlace s = new SafePlace();
        res = s.solution(board);
    }
}