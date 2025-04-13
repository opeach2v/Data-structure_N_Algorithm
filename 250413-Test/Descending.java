public class Descending {
    public long solution(long n) {
        long answer = 0;
        String nums = String.valueOf(n);
        int[] num = new int[nums.length()];

        for(int i = 0; i < nums.length(); i++) {
            num[i] = Integer.parseInt(nums.substring(i, i + 1));    // 배열에 하나씩 담기
        }

        // 버블 정렬
        for(int i = 0; i < nums.length() - 1; i++) {
            for(int j = nums.length() - 1; j > i; j--) {
                if(num[j - 1] < num[j]) {
                    int temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                }
            }
        }

        nums = "";  // 비우고
        for(int i = 0; i < num.length; i++) {
            nums += String.valueOf(num[i]); // 문자열로 붙이기
        }

        answer = Long.parseLong(nums);

        return answer;
    }
}