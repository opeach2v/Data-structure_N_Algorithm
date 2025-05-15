import java.util.Arrays;

public class LCM {
    public int solution(int[] arr) {
        int answer = 0;
        
        Arrays.sort(arr);   // 오름차순 정렬 (혹시 몰라서...)
        int[] arr2 = new int[arr.length];   // 원래 값(배수를 해주기 위함)
        for(int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) {  // 가장 큰 수보다 작으면
                arr[i] += arr2[i];
                i = -1;
            }
            else if(arr[i] == arr[i + 1]) continue;
            else if(arr[i] > arr[i + 1]) {
                arr[i + 1] += arr2[i + 1];
                i = -1;
            }
        }

        answer = arr[arr.length - 1];

        return answer;
    }
}