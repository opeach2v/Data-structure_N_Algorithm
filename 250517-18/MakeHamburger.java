import java.util.ArrayList;

public class MakeHamburger {
    public int solution(int[] ingredient) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int j : ingredient) {
            list.add(j);
        }

        for (int i = 0; i < list.size() - 3; i++) {
            if(list.get(i) == 1 && list.get(i + 1) == 2 && list.get(i + 2) == 3 && list.get(i + 3) == 1){
                answer++;
                for(int j = 0; j < 4; j++) {
                    list.remove(i);
                }
                if(i > 4){
                    i -= 4;
                }
                else {
                    i = -1;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] ingred = {2, 1, 1, 2, 3, 1,2, 3, 1};
        int res = 0;

        MakeHamburger m = new MakeHamburger();
        res = m.solution(ingred);
    }
}