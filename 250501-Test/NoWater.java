public class NoWater {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;    // 총 물 사용량

        for(int i = 0; i < change.length; i++) {
            usage = usage + (usage / change[i]);
            total_usage += usage;
            if(total_usage > storage) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int storage = 1000;
        int usage = 2000;
        int[] change = {-10, 25, -33};
        int res = 0;

        NoWater n = new NoWater();
        res = n.solution(storage, usage, change);

        System.out.println(res);
    }
}