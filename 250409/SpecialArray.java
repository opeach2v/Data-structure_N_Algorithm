public class SpecialArray {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[] nums = new int[numlist.length];

        // n과 가까운 수 구하기 위한 배열
        for(int i = 0; i < numlist.length; i++) {
            if(n > numlist[i]) {
                nums[i] = n - numlist[i];
            }
            else {
                nums[i] = numlist[i] - n;
            }
        }

        int temp = 0;
        // 단순 선택 정렬 사용.(<자료구조와 함께 배우는 알고리즘 입문> 책에서 참고)
        // 최소 거리 순으로 정렬(비교는 nums로 하되, numlist도 같이 정렬해야함)
        for(int i = 0; i < nums.length - 1; i++) {
            int min = i;    // 아직 정렬되지 않은 부분에서 가장 작은 요소를 교환하는 것.
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            // nums정렬
            temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;

            // numlist도 정렬
            temp = numlist[i];
            numlist[i] = numlist[min];
            numlist[min] = temp;
        }
        
        // 다 정렬하고 나서 nums에서 겹치는 숫자를 가진 numlist들끼리의 교환도 필요
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {    // 둘이 같으면
                    if(numlist[i] < numlist[j]) { // 뒤에 있던 numlist 값이 더 크면 
                        temp = numlist[i];
                        numlist[i] = numlist[j];
                        numlist[j] = temp;

                        // nums도 바꿔줘야 함
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }

        for (int i = 0; i < numlist.length; i++) {
            answer[i] = numlist[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numlist = {10000,20,36,47,40,6,10,7000};
        int n = 30;
        int[] result = {};

        SpecialArray s = new SpecialArray();
        result = s.solution(numlist, n);
    }
}