package week9.data_structures;
import java.util.*;

public class P5_SpiralAudit {
    // Complexity: O(m * n) Time, O(1) Space
    public static List<Integer> auditRoute(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        if (grid == null || grid.length == 0) return res;
        
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) res.add(grid[top][i]);
            top++;
            
            for (int i = top; i <= bottom; i++) res.add(grid[i][right]);
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) res.add(grid[bottom][i]);
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) res.add(grid[i][left]);
                left++;
            }
        }
        return res;
    }
}
