import java.util.ArrayList;

public class CraneGame {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> dalls = new ArrayList<>();   // 뽑은 인형 넣어짐
        int lastDall = 0;   // 마지막에 뽑은 인형
        int dall = 0;   // 이건 그냥 뭐 뽑았는지 볼 거

        for(int m = 0; m < moves.length; m++) { // 움직임 만큼
            for(int i = 0; i < board.length; i++) {
                if(board[i][moves[m] - 1] != 0) {   // 0이 아니면 인형이 들어있다는 것
                    dall = board[i][moves[m] - 1];
                    dalls.add(board[i][moves[m] - 1]);
                    board[i][moves[m] - 1] = 0; // 인형 사라짐

                    if(dalls.get(dalls.size() - 1) == lastDall) {   // 뽑은 인형 중 마지막 인형이랑 마지막 전에 뽑은 인형이 같으면
                        // dalls.removeLast();
                        // dalls.removeLast(); // 마지막 2개 삭제
                        dalls.remove(dalls.size() - 1);
                        dalls.remove(dalls.size() - 1); // 마지막 2개 삭제
                        answer += 2;
                    }
                    break;
                }
            }
            if(dalls.size() == 0) {
                lastDall = 0;
            }
            else {
                lastDall = dalls.get(dalls.size() - 1); // 마지막에 뽑은 인형 업데이트
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0},{0,0,0,0},{0,4,4,0},{1, 2, 2, 1}};
        int[] moves = {2, 3, 1, 4, 2, 3};
        int res = 0;

        CraneGame c = new CraneGame();
        res = c.solution(board, moves);

        System.out.println(res);
    }
}