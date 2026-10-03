package week9.data_structures;

public class P2_BudgetStreak {
    // Complexity: O(n) Time, O(1) Space
    public static int[] longestStreak(int[] costs, int budget) {
        int maxLen = 0, bestStart = -1, currentSum = 0, left = 0;
        
        for (int right = 0; right < costs.length; right++) {
            currentSum += costs[right];
            while (currentSum > budget && left <= right) {
                currentSum -= costs[left];
                left++;
            }
            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
                bestStart = left;
            }
        }
        return new int[]{maxLen, bestStart};
    }
}
