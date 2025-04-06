public class add {
    public static void main(String[] args) {
        String input = "123456789";
        int count = 0;

        String[] split = input.split("");

        for(int i = 0; i < split.length; i++) {
            if(Integer.parseInt(split[i]) % 3 == 1 || Integer.parseInt(split[i]) % 7 == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
