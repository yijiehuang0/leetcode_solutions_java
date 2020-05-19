import java.util.*;
public class calculator2 {
    public static int calculate(String s) {

        HashSet<Character> set = new HashSet<>();
        set.add('+');
        set.add('*');
        set.add('/');
        set.add('-');

        Stack<Integer> stack = new Stack<>();
        s = s.replaceAll(" ", "");
        Character sign = null;
        int nums = 0;
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(Character.isDigit(c)) {
                nums = nums * 10 + c - '0';
            }

            if(!Character.isDigit(c) || i == s.length() -1){
                if(sign == null){
                    stack.push(nums);
                } else if(sign == '*') {
                    stack.push(nums * stack.pop());
                } else if(sign == '/') {
                    stack.push(stack.pop() / nums);
                } else if(sign == '-') {
                    stack.push(-1 * nums);
                } else {
                    stack.push(nums);
                }

                nums = 0;
                sign =c;
            }
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
        }

    public static void main(String[] args) {
        calculate("3+5/2");
    }
}
