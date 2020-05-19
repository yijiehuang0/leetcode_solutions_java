import java.util.*;

// TODO: develop better understanding of backtracking algorithms

public class generateParathese {

    public static List<String> generateParenthasese(int n){
        List<String> ret = new ArrayList<>();
        backtrack(ret, "", 0 , 0, n);
        return ret;
    }

    public static void backtrack(List<String> ans, String curr, int open, int close, int max) {
        if(curr.length() == max*2) {
            ans.add(curr);
            return;      // after this returns then we are left with two paraenthases.
        }
        if(open < max) {
            backtrack(ans, curr+"(", open+1, close, max);
        }
        if (close < open)
            backtrack(ans, curr+")", open, close+1, max);
    }
    // this is just really cleve recursion so that it enables for us to keep on going back to past solutions and then moving foreward
    // to find new solutions and we cna do this recursively.

    public static void main(String[] args) {
       generateParenthasese(3);
    }

}

// a thought about how to solve this problem: we can attempt to use a stack or the recursion stack in order to back generate some paranthese for us
// for instance we can solve with computing all possible combinations that gives use 2 and then we can use that to formulate all combinations that give use more than that




/*
Problem 22:
Based off more general backtracking algorithms
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
