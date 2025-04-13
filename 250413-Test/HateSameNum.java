public class HateSameNum {
    public int[] solution(int []arr) {
        int[] nums = new int[arr.length];
        int[] answer = {};
        int count = 0;
        int n = 0;

        for(int i = 0; i < arr.length; i++) {
            if(n == 0) {
                nums[i] = arr[i];
                n = arr[i];
                count++;
            }
            else if(n == arr[i]) {
                nums[i] = 10;    // 0~9까지 숫자만 있기 때문에 나중에 10만 빼고 넣으려고
            }
            else if(n != arr[i]) {  // 달라지면 연속된 숫자가 아니게 된 것.
                nums[i] = arr[i];
                n = arr[i];
                count++;
            }
        }
        int j = 0;
        answer = new int[count];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 10) {
                answer[j] = nums[i];
                j++;
            }
        }

        return answer;
    }
}