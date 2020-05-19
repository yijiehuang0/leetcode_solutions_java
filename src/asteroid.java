import java.util.*;
public class asteroid {
    public static int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for(int i : a) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            int top = i;
            int bottom = stack.peek();
            boolean collide = top < 0 && bottom > 0;
            if(!collide) {
                stack.push(top);
                continue;
            } else {
                while(top < 0 && bottom > 0) {
                    if(Math.abs(top) == bottom) {
                        stack.pop();
                        break;
                    } else if(Math.abs(top) > bottom) {
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.push(top);
                            break;
                        }
                        bottom = stack.peek();
                    } else {
                        break;
                    }
                }
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while(!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        int[] ret = new int[list.size()];
        int index = 0;
        for(int i : list) {
            ret[index] = i;
            index++;
        }
        return ret;

    }

    public static void main(String[] args) {
        asteroidCollision(new int[]{-2, -2 ,1, -2});
    }
}
