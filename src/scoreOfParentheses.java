import java.util.*;
public class scoreOfParentheses {
    public static int scoreOfParentheses(String s) {
        int cur = 0, ret = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char  c= s.charAt(i);                 // stack 0 1
            if(c == '('){
                //cur is local variable. This line stores cur so that it could be retrieved later
                q.push(cur);   // we save the value of the current at this position here
                //From here a new function call starts. So reset cur
                cur = 0;  // we reset each layer to having a new current
            } else if( c== ')'){
                //Retrive cur
                cur = q.pop(); // pop to close // we get the value from the previous layer
                //calculate result based on ret
                if(s.charAt(i - 1) == '(') { // check if it is the one before // if it is the layer then we save it
                    cur += 1;  // add one in this case;
                } else{                     // otherwise we multiply by two
                    cur += ret*2;
                }
                //return result
                ret = cur;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        scoreOfParentheses("(()(()))");
    }
}
