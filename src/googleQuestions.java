import java.util.*;
public class googleQuestions {
    public static int firstQ(String a, String b) {
        int count = 0;
        String original = b;
        while(!a.equals("")) {
            char c = a.charAt(0);
            a = a.substring(1, a.length());
            if(b.indexOf(c) == -1) {
                return -1;
            }


            int pos = original.indexOf(c,0);
            if(pos != -1) {
                original = original.substring(pos + 1, original.length());
            } else {
                pos = b.indexOf(c,0);
                original = b.substring(pos +1, b.length());
                count++;
            }
        }

        return count;

    }



    public static int efficientJanitor(List<Double> weight) {
        int index = 0;
        int count = 0;
        while(index < weight.size() -1) {
            double cursum = 0;
            while(cursum < 3.00 && index + 1 < weight.size()) {
                cursum+=weight.get(index+1);
                index++;
            }
            count++;
        }
        return count;

    }


    abstract class Car {
        int mileage;
        boolean sedan;
        int seats;
        Car(int miles) {
            mileage = miles;
        }
        abstract int getSeats();
        abstract boolean getIsSedan();
        abstract int getMileage();
    }

    /**
     *   WagonR class
     **/
    class WagonR extends Car {
        WagonR(int miles) {
            super(miles);
            seats = 4;
            sedan = false;
        }

        @Override
        int getSeats() {
            return seats;
        }

        @Override
        boolean getIsSedan() {
            return sedan;
        }

        @Override
        int getMileage() {
            return mileage;
        }
    }

    public static long variantsCount(int n, int s0, int k, int b, int m, long a) {
        // Write your code here
        int[] coins = new int[n];
        coins[0] = s0;
        for(int i = 1; i < n; i++) {
            coins[i] = (k*coins[i-1] + b)%m +1 +coins[i-1];
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            int sum = coins[i] * coins[i];
            if( sum <= a) {
                count++;
            } else {
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(coins[i] * coins[j] <= a) {
                    count++;
                } else{
                    break;
                }
            }
        }
        return count;


    }

    public static void main(String[] args) {
        firstQ("ZAZAZA", "BAZ");
        List<Double> list = new ArrayList<>();
        list.add(1.01);
        list.add(1.01);
        list.add(1.01);
        list.add(1.4);
        list.add(2.4);
        efficientJanitor(list);
        variantsCount(3, 1,1, 1,2, 4);

    }



}
