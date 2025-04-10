public class Bus {
    public int solution(int seat, String[][] passengers) {
        int num_passenger = 0;
        for(int i=0; i<passengers.length; i++){
            num_passenger += func3(passengers[i]);
            num_passenger -= func4(passengers[i]);
        }
        int answer = func1(num_passenger);
        return answer;
    }

    public int func1(int num){
        if(0 > num){
            return 0;
        }
        else{
            return num;
        }
    }
    public int func2(int num){
        if(num > 0){
            return 0;
        }
        else{
            return num;
        }
    }

    public int func3(String[] station){
        int num = 0;
        for(int i=0; i<station.length; i++){
            if(station[i].equals("Off")){
                num += 1;
            }
        }
        return num;
    }

    public int func4(String[] station){
        int num = 0;
        for(int i=0; i<station.length; i++){
            if(station[i].equals("On")){
                num += 1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String[][] passen = {{"On", "On", "On"}, {"Off", "On", "-"}, {"Off", "-", "-"}};
        int seat = 5;
        int res = 0;

        Bus bus = new Bus();
        res = bus.solution(seat, passen);
    }
}
