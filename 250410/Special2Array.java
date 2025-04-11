public class Special2Array {
    public int solution(int[][] arr) {
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i == j) {
                    count++;
                    continue;   // i랑 j가 같으면 건너 뜀 (비교할 필요가 없음음)
                }
                if(arr[i][j] == arr[j][i]) {
                    count++;
                }
            }
        }

        if(count == arr.length * arr.length) {
            return 1;
        }
        else {
            return 0;
        }
    }
}