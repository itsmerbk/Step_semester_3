package week9.data_structures;
import java.util.*;

public class P1_FootfallReport {
    // Complexity: O(n) preprocessing, O(1) per query. Space: O(n)
    public static List<Integer> footfallReport(int[] visitors, int[][] queries) {
        int[] prefix = new int[visitors.length + 1];
        for (int i = 0; i < visitors.length; i++) {
            prefix[i + 1] = prefix[i] + visitors[i];
        }
        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            result.add(prefix[q[1] + 1] - prefix[q[0]]);
        }
        return result;
    }
}
