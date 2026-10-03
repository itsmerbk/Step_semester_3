package week9.data_structures;
import java.util.*;

public class P3_PeriodCounter {
    // Complexity: O(n) Time, O(n) Space
    public static int countPeriods(int[] transactions, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int sum = 0, result = 0;
        
        for (int t : transactions) {
            sum += t;
            result += counts.getOrDefault(sum - k, 0);
            counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
