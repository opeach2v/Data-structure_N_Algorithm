public class Make2Array {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        int num = 0;
        while(num < num_list.length) {
            for(int i = 0; i < num_list.length / n; i++) {
                for(int j = 0; j < n; j++) {
                    answer[i][j] = num_list[num];
                    num++;
                }
            }
        }
        
        return answer;
    }
}