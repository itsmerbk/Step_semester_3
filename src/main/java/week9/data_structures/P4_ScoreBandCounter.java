package week9.data_structures;

public class P4_ScoreBandCounter {
    // Complexity: O(log n) Time, O(1) Space
    public static int countInBand(int[] scores, int low, int high) {
        return findFirst(scores, high + 1) - findFirst(scores, low);
    }
    
    private static int findFirst(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
