public class Water {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage = usage * change[i] / 100;
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int storage = 1000;
        int usage = 2000;
        int[] change = { -10, 25, -33};

        Water w = new Water();
        int result = w.solution(storage, usage, change);
    }
}