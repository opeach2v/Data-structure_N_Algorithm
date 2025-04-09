public class Empty {
    public int[] solution(int[] arr, boolean[] flag) {
        int[] answer = {};
        int count = 0;
        int[] array = new int[15];
        int j = 0;
        for(int i = 0; i < arr.length; i++) {
            if(flag[i] == true) {
                count += (arr[i] * 2);
                while (j < count) {
                    array[j] = arr[i];
                    j++;
                }
            }
            else {  // false
                for(int k = count - 1; k >= count - arr[i]; k--) {
                    array[k] = 0;
                    j--;
                }
                count -= arr[i];
            }
        }

        answer = new int[count];
        for(int i = 0; i < count; i++) {
            answer[i] = array[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3};
        boolean[] falg = {true, false, true, false, false};
        int[] result = {};

        Empty e = new Empty();
        result = e.solution(arr, falg);

        System.out.println(result);
    }
}
