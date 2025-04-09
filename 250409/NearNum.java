public class NearNum {
    public int solution(int[] array, int n) {
        int answer = 0;
        int[] sub = new int[array.length];
        int min = 0;

        for(int i = 0; i < array.length; i++) { // 계산 결과 넣고
            if(n > array[i]) {
                sub[i] = n - array[i];
            }
            else {
                sub[i] = array[i] - n;
            }
        }

        // 제일 가까운 수 구하기
        for(int i = 1; i < sub.length; i++) {
            if(sub[min] > sub[i]) {
                min = i;
            }
            else if(sub[min] == sub[i]) {   // 둘이 같으면
                if(array[min] > array[i]) {
                    min = i;
                }
            }
        }
        answer = array[min];

        return answer;
    }
}
