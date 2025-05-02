public class RemoveSmallestNum {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length - 1];
        int min = 0;

        if(arr.length == 1) {   // 배열 길이가 1이면
            return new int[] {-1};  // -1 리턴 
        }
        else {
            // 가장 작은 수 찾아서 0으로 만들기
            for(int i = 1; i < arr.length; i++) {
                if(arr[min] > arr[i]) {
                    min = i;
                }
            }
            arr[min] = 0;
        }

        int idx = 0;
        // 결과 배열에 넣어주기
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                answer[idx] = arr[i];
                idx++;
            }
        }

        return answer;
    }
}