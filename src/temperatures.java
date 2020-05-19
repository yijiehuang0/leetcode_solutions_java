import java.util.*;
public class temperatures {
    public static int[] dailyTemperatures(int[] t) {
        int[] ret = new int[t.length];
        if(t.length == 0) {
            return ret;
        }
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<t.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int top = t[i];
            int bottom = t[stack.peek()];
            int bottomi = stack.peek();
            int count = 0;
            if(top < bottom) {
                stack.push(i);
                continue;
            }
            while(top > bottom) {

                ret[stack.pop()] = i - bottomi;
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                } else {
                    bottom = t[stack.peek()];
                    bottomi = stack.peek();
                    if(top < bottom) {
                        stack.push(i);
                        break;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }
}
