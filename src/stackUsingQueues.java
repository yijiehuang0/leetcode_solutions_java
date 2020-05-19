import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueues {
    Queue<Integer> primary;
    Queue<Integer> secondary;
    public stackUsingQueues() {
        primary =  new LinkedList<>();
        secondary =  new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        secondary.add(x);
        while(!primary.isEmpty()) {
            secondary.add(primary.poll());
        }
        Queue<Integer> temp = primary;
        this.primary = this.secondary;
        this.secondary = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return primary.poll();
    }

    /** Get the top element. */
    public int top() {
        return primary.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return primary.isEmpty();
    }
}
