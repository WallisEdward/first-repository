import java.util.ArrayDeque;

public class Solution {
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1){
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '[' || c == '{' || c == '('){
                stack.push(c);
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '('){
                    return false;
                }
                if (c == '}' && top != '{'){
                    return false;
                }
                if (c == ']' && top != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
