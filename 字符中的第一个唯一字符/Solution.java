import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> hashmap = new HashMap<>();
        hashmap.put(s.charAt(0),1);
        for (int i = 1; i < s.length(); i++) {
            if (hashmap.containsKey(s.charAt(i))){
                int a = hashmap.get(s.charAt(i));
                hashmap.put(s.charAt(i),a++);
            }else {
                hashmap.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (hashmap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }



}
