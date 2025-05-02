import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("복숭아", 4000);
        map.put("포도", 2000);

        System.out.println(map.get("복숭아"));
        System.out.println(map.containsKey("포도"));
        System.out.println(map.containsValue(3000));
        System.out.println(map.remove("포도"));
        System.out.println(map.size());
        map.replace("복숭아", 4500);
        System.out.println(map.get("복숭아"));
        System.out.println(map.isEmpty());

        map.clear();
        System.out.println(map.isEmpty());
    }
}
