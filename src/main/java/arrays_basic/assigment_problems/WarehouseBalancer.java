package arrays_basic.assigment_problems;
public class WarehouseBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "Section A";
        int maxIndex = 1;
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }
        String balanceStatus = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)%n",
                totalA, totalB, balanceStatus, maxQty, maxSection, maxIndex);
    }
    public static void main(String[] args) {
        int[] secA = {20, 15, 30};
        int[] secB = {25, 10, 30};
        analyzeInventory(secA, secB);
        int[] secA2 = {10, 20, 15};
        int[] secB2 = {5, 15, 10};
        analyzeInventory(secA2, secB2);
    }
}
