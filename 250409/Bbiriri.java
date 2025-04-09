public class Bbiriri {
    public int solution(String[] spell, String[] dic) {
        int count = 0;

        for(int i = 0; i < dic.length; i++) {
            count = 0;
            for(int j = 0; j < spell.length; j++) {
                if(dic[i].contains(spell[j])) {
                    count++;
                }
            }
            if(count == spell.length) {
                return 1;
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        int result = 0;

        Bbiriri b = new Bbiriri();
        result = b.solution(spell, dic);
        System.out.println(result);
    }
}
