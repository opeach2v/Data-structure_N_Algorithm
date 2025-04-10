public class Discount {
    public int solution(int price) {
        int answer = 0;

        if(price < 100000) {
            answer = price;
        }
        else if(price >= 100000 && price < 300000) {   // 10만원 이상
            answer = (int) (price - (price * 0.05));
        }
        else if(price >= 300000 && price < 500000) {  // 30만원 이상
            answer = (int) (price - (price * 0.1));
        }
        else{  // 50만원 이상
            answer = (int) (price - (price * 0.2));
        }

        return answer;
    }

    public static void main(String[] args) {
        int price = 112300;
        int res = 0;

        Discount d = new Discount();
        res = d.solution(price);
    }
}