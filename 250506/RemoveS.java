import java.util.ArrayList;

public class RemoveS {
    public int solution(String s) {
        ArrayList<String> list = new ArrayList<>();

        if(s.isEmpty()) return 1;
        else if(s.length() == 1) return 0;
        else {
            for(String s1 : s.split("")) {
                list.add(s1);
            }
    
            int i = 0;
            while(!list.isEmpty()) {
                int sameCount = 0;  // 2가 되면 제거
                s = list.get(i);
                sameCount++;
                i++;
                if(s.equals(list.get(i))) {
                    sameCount++;
                }
    
                if(sameCount == 2) {    // 둘이 같다는 거
                    i--;
                    list.remove(i);
                    list.remove(i);
                    i = 0;
                }
    
                if(sameCount == 1 && i >= list.size() - 1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        String s = "baab";
        int res = 0;

        RemoveS r = new RemoveS();
        res = r.solution(s);

        System.out.println(res);
    }
}