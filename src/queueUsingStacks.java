import java.util.Stack;
public class queueUsingStacks {

        /** Initialize your data structure here. */
        private Stack<Integer> first;
        private Stack<Integer> second;

        public queueUsingStacks() {
            first = new Stack<>();
            second = new Stack<>();
        }
        // to make a stack we could use two queues in this case
        // what should we do with these two queues?
                // 1. one queue can hold the new results, and the other can hold the return result.
                // add to the second queue

        /** Push element x to the back of queue. */
        public void push(int x) {
            second.push(x);
            while(!first.isEmpty()) {
                second.push(first.pop());
            }
             Stack<Integer> temp = first;
            first = second;
            second = temp;

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return first.pop();
        }

        /** Get the front element. */
        public int peek() {
            return first.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return first.isEmpty();

        }

}
