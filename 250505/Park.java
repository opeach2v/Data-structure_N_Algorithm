
import java.util.ArrayList;
import java.util.Arrays;

public class Park {
    public int solution(int[] mats, String[][] park) {
        ArrayList<Integer> cols = new ArrayList<>();    // column들 넣기(중간에 끊길 수도 있으니까?)
        int matCount = mats.length - 1;    // mats의 인덱스 0부터 시작함.

        Arrays.sort(mats);

        for(int  i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length; j++) {
                int count = 0;
                if(park[i][j].equals("-1")) {   // 빈공간
                    count++;
                }
                else {  // 돗자리 구간을 만나면
                    if(count != 0) {    // count가 0이 아닐 때
                        cols.add(count);    // cols에 임시로 넣어주기
                    }
                }
            }
            if(cols.isEmpty()) {    // 비어있지 않으면
                int max = 0;
                for(int c = 0; c < cols.size(); c++) {
                    if(max < cols.get(c) && cols.get(c) <= mats[matCount]) {
                        max = cols.get(c);
                    }
                }
                if(max < mats[matCount]) {
                    matCount--;    // 다음 돗자리 사이즈로
                    if(matCount == -1) return -1;
                }
            }
        }

        return mats[matCount];
    }
}