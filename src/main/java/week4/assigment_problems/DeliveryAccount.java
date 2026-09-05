package week4.assigment_problems;
class PremiumDeliveryAccount extends DeliveryAccount {
    public PremiumDeliveryAccount(String studentId, double orderValue) {
        super(studentId, orderValue);
    }
}
public class DeliveryAccount {
    private static String systemStatus;
    static {
        systemStatus = "RECONCILIATION_READY";
    }
    private final String studentId;
    private final double orderValue;
    private static final SurgeFeeCalculator calculator = new SurgeFeeCalculator(1.0);
    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = Math.max(orderValue, 0.0);
    }
    public DeliveryAccount(String studentId) {
        this(studentId, 0.0);
    }
    public final double calculateSurgeFee(int delayMinutes) {
        return calculator.calculateSurgeFee(this.orderValue, delayMinutes);
    }
    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts == null || amounts == null || delayMinutesArray == null ||
            accounts.length != amounts.length || accounts.length != delayMinutesArray.length) {
            System.out.println("Operational mismatch: parallel input array lengths must match exactly.");
            return;
        }
        int processed = 0;
        int nullSkipped = 0;
        int premiumCount = 0;
        int regularCount = 0;
        double grandTotalSurge = 0.0;
        for (int i = 0; i < accounts.length; i++) {
            DeliveryAccount acc = accounts[i];
            if (acc == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (acc instanceof PremiumDeliveryAccount) {
                premiumCount++;
                // Premium gets 50% surge discount on settlement
                grandTotalSurge += (acc.calculateSurgeFee(delayMinutesArray[i]) * 0.5);
            } else {
                regularCount++;
                grandTotalSurge += acc.calculateSurgeFee(delayMinutesArray[i]);
            }
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " +
                           premiumCount + " premium | " + regularCount + " regular | grand total surge fees = Rs " + grandTotalSurge);
    }
    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumDeliveryAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delayMinutes = {10, 5, 0};
        processBatch(accounts, amounts, delayMinutes);
    }
}
