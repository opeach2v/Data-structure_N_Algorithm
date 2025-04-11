public class Add_Mul {
    public int solution(int[] num_list) {
        int answer = 0;

        int add = 0;
        int mul = 1;

        for(int num : num_list) {
            add += num;
            mul *= num;
        }
        if(add * add > mul) {
            return 1;
        }
        else {
            return 0;
        }
    }
}