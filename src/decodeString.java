import java.util.*;
public class decodeString {
    public static String decodeString(String s) {
        Stack<String> strins = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        char[] array = s.toCharArray();
        int curint = 0;
        StringBuilder retstring = new StringBuilder();
        StringBuilder curstring = new StringBuilder();
        int nested = 0;
        for(int i = 0; i< array.length; i++) {
            if((int) array[i] > 96 && (int) array[i] < 123) {
                curstring.append(Character.toString(array[i]));
            }
            else if((int) array[i] > 48 && (int) array[i] < 58) {
                curint = curint * 10 + Character.getNumericValue((int) array[i]);
            } else if((int) array[i] == 91) {
                nested = nested + 1;
                ints.add(curint);
                curint = 0;
                if(curstring.length() != 0) {
                    strins.push(curstring.toString());
                }
                curstring = new StringBuilder();
            } else if((int) array[i] == 93) {
                nested-=1;
                if(nested == 0) {
                    int count = ints.pop();
                    curstring = stringMultiply(curstring, count);
                    retstring.append(curstring.toString());
                    curstring = new StringBuilder();
                } else {
                    int count = ints.pop();
                    curstring = stringMultiply(curstring, count);
                    curstring.insert(0, strins.pop());
                }
            }
        }


        return retstring.toString() + curstring.toString();
    }



    public static StringBuilder stringMultiply(StringBuilder sas, int n){
        String s = sas.toString();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(s);
        }
        return sb;
    }

    public static String decodeString1(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }


    public static String decodeString3(String s) {
        int num = 0;
        StringBuilder cur = new StringBuilder();
        StringBuilder res = new StringBuilder();
        Deque<StringBuilder> q = new ArrayDeque<>();
        Deque<Integer> digits = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if(c == '['){
                q.push(cur);
                digits.push(num);
                cur = new StringBuilder();
                num = 0;
            } else if(c == ']') {
                cur = q.pop();
                num = digits.pop();
                for(int j = 0; j < num; j++){
                    cur.append(res.toString());
                }
                num = 0;
                //this is necessary whenever the function might return
                res = cur;
            } else{
                cur.append(c);
                //this is necessary whenever the function might return
                res = cur;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        decodeString("100[leetcode]");

    }


}
