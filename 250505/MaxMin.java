import java.util.ArrayList;
import java.util.Collections;

public class MaxMin {
    public String solution(String s) {
        ArrayList<Integer> num = new ArrayList<>();
        
        for(String n : s.split(" ")) {
                int nums = Integer.parseInt(n);
                num.add(nums);
        }

        Collections.sort(num);

        return String.valueOf(num.get(0)) +" " +String.valueOf(num.get(num.size() - 1));
    }

    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";
        String res = "";

        MaxMin m = new MaxMin();
        res = m.solution(s);

        System.out.println(res);
    }
}