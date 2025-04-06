public class AddString {
    public static void main(String[] args) {
        String input = "12345678";

        String[] split = input.split("");

        int total = 0;

        for (String s : split) {
            total += Integer.parseInt(s);
        }

        System.out.println(total);
    }
}