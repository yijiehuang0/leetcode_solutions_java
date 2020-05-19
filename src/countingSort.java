public class countingSort {
    public void countingSort(int[] a) {
        int[] ret = new int[a.length];
        int[] counts = new int[11];
        for(int i = 0; i < a.length; i++) {
            counts[a[i]]++; // we get the counts of each character
        }
        for(int i = 1; i < counts.length; i++) {
            counts[i] =  counts[i] + counts[i-1];
        }
        for(int i = 0; i<a.length; i++) {
            int cur = a[i];
        }


    }
}
