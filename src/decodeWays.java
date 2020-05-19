import java.util.*;

public class decodeWays {
    public int recursiveFails(String s) {
        if(s.length() == 0) {
            return 1;
        }
        if(Integer.parseInt(s.substring(0,1)) == 0) {
            return 0;
        }
        int len = s.length();
        String first = null;
        if(len >=1) {
            first = s.substring(len-1, len);
        }
        String second = null;
        if(len > 1) {
            second = s.substring(len -2, len);
        }

        int sumFirst = 0;
        int sumSecond = 0;


        if(second != null){
            String secondFirst = second.substring(0,1);
            int two = Integer.parseInt(second);
            int sf = Integer.parseInt(secondFirst);
            if(two <= 26 && two > 0 && sf >0) {
                sumSecond = recursiveFails(s.substring(0, len -2));
            }
        }

        if(first != null) {
            int one = Integer.parseInt(first);
            if(one <= 26 && one > 0) {
                sumFirst =  recursiveFails(s.substring(0, len -1));
            }
        }
        return sumFirst + sumSecond;
    }



        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        public int numDecodings(String s) {
            if(s.length() == 0) return 0;
            return decode(s,0);
        }

        public int decode(String s,int i){
            if(i == s.length()) return 1;
            if(i == s.length()-1) return s.charAt(i) == '0'?0:1;
            if(map.containsKey(i)) return map.get(i);
            if(s.charAt(i) =='0') return 0;
            int res = decode(s,i+1);
            int val = Integer.parseInt(s.substring(i,i+2));
            if(val > 0 && val <=26){
                res += decode(s,i+2);
            }
            map.put(i,res);
            return res;
        }





}


