import java.util.*;
public class creditKarma {

    public static void main(String[] args) {
        String string = "v15.0.0";
        // we woudl wnat to store this into an array[3]
        // then we can iterate through this and choose which things
        string = string.substring(1);
        int[] ret = new int[3];
        int index = 0;
        int count = 0;
        int temp = 0;
        for(Character c: string.toCharArray()) {
            if(!Character.isDigit(c) || count == 2) {
                ret[index] = temp;
                index++;
                count++;
            } else {
                temp = temp * 10 + c -'0';
            }
        }
        // should have discussed strategjies first before doing anything else, should have been more aware of those things firsst
    }





}



