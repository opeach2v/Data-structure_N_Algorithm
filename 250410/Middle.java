public class Middle {
    public int solution(int[] array) {
        int answer = 0;
        int temp = 0;

        // 오름차순으로 정렬하기
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = array.length - 1; j > i; j--) {
                if(array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        answer = array[array.length / 2];   // 중앙에 있는 값값

        return answer;
    }
}