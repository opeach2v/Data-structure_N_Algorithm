public class DescendingNum {
    public long solution(long n) {
        String numS = String.valueOf(n);
        String[] numSplit = numS.split("");

        for(int i = 0; i < numSplit.length; i++) {
            for(int j = numSplit.length - 1; j > i; j--) {
                if(Long.parseLong(numSplit[j - 1]) < Long.parseLong(numSplit[j])) {
                    String temp = numSplit[j - 1];
                    numSplit[j - 1] = numSplit[j];
                    numSplit[j] = temp;
                }
            }
        }

        numS = "";  // 문자열 비우고
        for(int i = 0; i < numSplit.length; i++) {
            numS += numSplit[i];
        }

        return Long.parseLong(numS);
    }
}