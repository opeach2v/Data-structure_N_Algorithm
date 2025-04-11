public class BigNums {
    public String solution(String number, int k) {
        String answer = "";
        String[] nums = number.split("");
        int count = k;  // k번 삭제를 위함

        int max = 0;    // 젤 큰 숫자인 문자 담기
        for(int i = 1; i < nums.length; i++) {   // 젤 큰 숫자 찾기
            if(Integer.parseInt(nums[max]) < Integer.parseInt(nums[i])) { // nums[max]보다 num[i]가 더 크면
                max = i;    // i번째 인덱스로 바뀜
            }
        }
        
        while(count > 0)    // 다 사라지면 빠져나옴
            for(int i = 0; i < max; i++) {  // max 인덱스에 있는 숫자보다 앞에 있는 숫자들이 작으면 삭제하는 과정
            } 

        return answer;
    }

    public static void main(String[] args) {
        String number = "4177252841";
        int k = 4;
        String result = "";

        BigNum b = new BigNum();
        result = b.solution(number, k);

        System.out.println(result);
    }
}