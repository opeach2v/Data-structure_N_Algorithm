public class PaintOver {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int startPaint = 0;  // 처음 칠할 벽의 인덱스
        int i = 0;

        if(m == 1) return section.length;
        else if(n == m || section.length == 1) return 1;
        else {
            while(i < section.length) {
                if(startPaint >= n) break;
                else if(startPaint >= section[i]) {
                    i++;
                    continue;
                }
                if(startPaint < section[i]) {
                    startPaint = section[i];
                }
                startPaint += m - 1;    // m만큼 칠했다는 것
                answer++;
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 8;
        int m = 4;
        int[] section = {2, 3, 6}; 
        int res = 0;

        PaintOver p = new PaintOver();
        res = p.solution(n, m, section);
    }
}