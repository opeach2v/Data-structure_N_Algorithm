public class Bus {
    public int solution(int seat, String[][] passengers) {
        int count = 0;  // 승차한 사람들의 수 (seat의 수를 넘으면 안 됨)

        for(int i = 0; i < passengers.length; i++) {
            for(int j = 0; j < passengers[i].length; j++) {
                if(!passengers[i][j].equals("-")) { // On과 Off라면
                    if(passengers[i][j].equals("On")) { // 승차함
                        count++;
                    }
                    else {  // 하차함
                        count--;
                    }
                }
            }
        }

        if(count > seat) {
            return 0;
        }
        else {
            return seat - count;
        }
    }

    public static void main(String[] args) {
        int seat = 10;
        //String[][] passengers = {{"On", "On", "On"}, {"Off", "On", "-"}, {"Off", "-", "-"}};
        String[][] passengers = {{"On", "On", "On", "On", "On", "On", "On", "On", "-", "-"}, {"On", "On", "Off", "Off", "Off", "On", "On", "-", "-", "-"}, {"On", "On", "On", "Off", "On", "On", "On", "Off", "Off", "Off"}, {"On", "On", "Off", "-", "-", "-", "-", "-", "-", "-"}};
        int res = 0;

        Bus b = new Bus();
        res = b.solution(seat, passengers);

        System.out.println(res);
    }
}