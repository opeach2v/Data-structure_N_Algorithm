public class Polynomial {
    public String solution(String polynomial) {
        String answer = "";

        String[] poly = polynomial.split(" ");
        int xsum = 0;
        int sum = 0;
        
        for(int i = 0; i < poly.length; i++) {
            if(poly[i].charAt(0) != '+') {
                if(poly[i].contains("x")) {
                    if(poly[i].equals("x")) {
                        xsum += 1;
                    }
                    else {
                        String[] num = poly[i].split("x");
                        xsum += Integer.parseInt(num[0]);
                    }
                }
                else {
                    sum += Integer.parseInt(poly[i]);
                }
            }
        }

        if(sum == 0) {
            if (xsum == 1) {
                answer = "x";
            }
            else {
                answer = xsum +"x";
            }
        }
        else {
            if (xsum == 1) {
                answer = "x + " +sum;
            }
            else if(xsum == 0) {
                answer = String.valueOf(sum);
            }
            else {
                answer = xsum +"x + " +sum;
            }
        }

        return answer;
    }
}