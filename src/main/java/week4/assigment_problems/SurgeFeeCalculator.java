package week4.assigment_problems;
public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;
    public SurgeFeeCalculator(double minimumSurgePercent) {
        if (minimumSurgePercent < 0) {
            throw new IllegalArgumentException("Minimum surge percent cannot be negative");
        }
        this.minimumSurgePercent = minimumSurgePercent;
    }
    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Order value and delay minutes must be non-negative");
        }
        if (delayMinutes == 0) {
            return 0.0;
        }
        int tier1 = Math.min(delayMinutes, 5);
        int tier2 = (delayMinutes > 5) ? Math.min(delayMinutes - 5, 10) : 0;
        int tier3 = (delayMinutes > 15) ? (delayMinutes - 15) : 0;
        double calculatedFee = orderValue * ((tier1 * 0.005) + (tier2 * 0.01) + (tier3 * 0.02));
        double floorFee = orderValue * (minimumSurgePercent / 100.0);
        return Math.max(calculatedFee, floorFee);
    }

    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        System.out.println("Rs " + calc.calculateSurgeFee(500, 0));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 1));
        System.out.println("Rs " + calc.calculateSurgeFee(500, 16));
    }
}
