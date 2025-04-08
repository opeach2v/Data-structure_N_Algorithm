
public class KthNum {
    public int[] solution(int[] array, int[][] commands) {
        int i = 0, j = 0, k = 0;
        int a = 0;
        int[] answer = new int[commands.length];
        while(a < commands.length) {
            i = commands[a][0]; // i번째부터
            j = commands[a][1]; // j번째까지 자른 후
            k = commands[a][2]; // 정렬 후 k번째 인덱스 값 설정
            int len = j - i + 1;
            int[] num = new int[len];
            for(int b = 0; b < len; b++) {
                num[b] = array[i - 1];
                i++;
            }

            // 작은 수에서 큰 수로 정렬
            int temp = 0;
            for(int c = 0; c < num.length - 1; c++) {
                for(int d = num.length - 1; d > c; d--) {
                    if(num[d - 1] > num[d]) {
                        temp = num[d - 1];
                        num[d - 1] = num[d];
                        num[d] = temp;
                    }
                }
            }

            answer[a] = num[k - 1];
            a++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = {};

        KthNum k = new KthNum();
        result = k.solution(array, commands);

    }
}
