public class P_YCount {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        
        for(String sSplit : s.split("")) {
            if(sSplit.equals("p") || sSplit.equals("P")) {
                pCount++;
            }
            else if(sSplit.equals("y") || sSplit.equals("Y")) {
                yCount++;
            }
            else continue;
        }

        if(pCount == yCount) return true;
        else return false;
    }
}