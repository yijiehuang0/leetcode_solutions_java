public class countBits {

    public static int[] countBits(int num) {
        int[] ret = new int[num +1];
        ret[0] = 0;
        if(num == 0) {
            return ret;
        }
        ret[1] = 1;
        if(num == 1) {
            return ret;
        }
        int curPow = 1;
        int count = 0;
        for(int i = 2; i<= num; i++) {
            ++count;
            if(count == curPow) {
                ret[i] = 1;
                count = 0;
                curPow *=2;
            } else {
                ret[i] = 1  + count;
            }

        }

        return ret;
    }

    public static void main(String[] args) {
        countBits(8);
    }
}
