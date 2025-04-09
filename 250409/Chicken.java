public class Chicken {
    public int solution(int chicken) {
        int answer = 0;
        int service = 0;
        
        for(int i = 1; i <= chicken; i++) {
            if((i + service) % 10 == 0) {
                service++;
            } 
        }
        answer = service;

        return answer;
    }

    public static void main(String[] args) {
        int chicken = 1081;
        int result = 0;

        Chicken c = new Chicken();
        result = c.solution(chicken);

        System.out.println(result);
    }
}