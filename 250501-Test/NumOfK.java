public class NumOfK {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int a = 0; a < commands.length; a++) {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            int[] newArr = new int[j - i + 1];
            int count = 0;
            for(int b = i - 1; b < j; b++) {
                newArr[count] = array[b];
                count++;
            }

            // 오름차순 정렬
            for(int c = 0; c < newArr.length; c++) {
                for(int d = newArr.length - 1; d > c; d--) {
                    if(newArr[d - 1] > newArr[d]) {
                        int temp = newArr[d - 1];
                        newArr[d - 1] = newArr[d];
                        newArr[d] = temp;
                    }
                }
            }

            answer[a] = newArr[k - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] res = {};

        NumOfK k = new NumOfK();
        res = k.solution(array, command);
    }
}