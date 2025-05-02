public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int firstArea = section[0];
        int lastArea = section[section.length - 1];

        if((lastArea - firstArea + 1) <= m) { // 칠해야 하는 영역이 롤러 길이보다 짧으면
            return 1;
        }
        else {  // 롤러 길이보다 더 길면
            if(((lastArea - firstArea + 1) / m) % 2 == 0) { // 짝수면
                return (lastArea - firstArea + 1) / m;
            }
            else {
                return (lastArea - firstArea + 1) / m + 1;
            }
        }
    }
}