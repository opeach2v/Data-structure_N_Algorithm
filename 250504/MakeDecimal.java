public class MakeDecimal {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;    // 3개 더했을 때
        int count = 0;

        for(int i = 0; i <= nums.length / 2; i++) {  // 첫 번째 숫자
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    count = 0;
                    sum = nums[i] + nums[j] + nums[k];    // 더했을 때
                    for(int d = 2; d <= sum / 2; d++) {
                        if(sum % d == 0) {  // 나눠지면 소수 안 됨
                            count++;
                            break;
                        }
                    }
                    if(count == 0) {    // 카운트가 0이면
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        int res = 0;

        MakeDecimal m = new MakeDecimal();
        res = m.solution(nums);
    }
}