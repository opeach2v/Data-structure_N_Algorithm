public class BingBing {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int a = 1;
        int num = n * n;
        int i = 0, j = 0;   // 순서대로 행, 열
        int left = 0, right = n - 1;    // 열의 왼쪽, 오른쪽
        int up = 0;
        int down = n - 1; // 행의 위, 아래
        while(a <= num) {   // 1 ~ num 까지
            if(a == num) {
                answer[i][j] = a;
                break;
            }
            if(i == up) {   // 행이 위에 있으면
                answer[i][j] = a;
                a++;    // 값 증가
                if(a != num) {
                    j++;    // 열 증가
                }
                if(left == right) {
                    i++;
                    answer[i][j] = a;
                    break;
                }
                if(j == right) {
                    answer[i][j] = a;
                    a++;
                    i++;    // 밑으로 내려가야 하니까 행 증가
                    up++;
                }
            }
            if(j == right) {    // 열이 오른쪽이랑 닿으면
                answer[i][j] = a;
                a++;
                if(a != num) {
                    i++;    // 밑으로 내려가야 하니까 행 증가
                }
                if(up == down) {
                    j--;
                    answer[i][j] = a;
                    break;
                }
                if(i == down) {
                    answer[i][j] = a;
                    a++;
                    j--;  // 왼쪽으로 가야 하니까 행 감소
                    right--;
                }
            }
            if(i == down) { // 행이 아래에 있으면
                answer[i][j] = a;
                a++;
                if(a != num) {
                    j--;  // 왼쪽으로 가야 하니까 행 감소
                }
                if(left == right) {
                    i--;
                    answer[i][j] = a;
                    break;
                }
                if(j == left) {
                    answer[i][j] = a;
                    a++;
                    i--;    // 위로 다시 가야해서 행 감소
                    down--;
                }
            }
            if(j == left) { // 열이 왼쪽에 닿으면
                answer[i][j] = a;
                a++;
                if(a != num) {
                    i--;    // 위로 다시 가야해서 행 감소
                }
                if(up == down) {
                    j++;
                    answer[i][j] = a;
                    break;
                }
                if(i == up) {
                    answer[i][j] = a;
                    a++;    // 값 증가
                    j++;    // 열 증가
                    left++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 1;
        int[][] result = {};

        BingBing b = new BingBing();
        result = b.solution(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(result[i][j] +" ");
            }
            System.out.println();
        }
    }
}
