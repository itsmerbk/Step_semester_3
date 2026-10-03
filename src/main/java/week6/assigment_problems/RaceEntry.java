package week6.assigment_problems;

import java.util.Arrays;

public class RaceEntry {
    private static int bibCounter = 0;
    private final String entryCode;
    private String bibNumber;
    private double entryFee;
    private double balanceDue;
    private double[] lateFeeHistory;
    private int lateFeeCount;

    public RaceEntry(String bibNumber, double entryFee) {
        if (bibNumber == null || bibNumber.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.bibNumber = bibNumber.trim();
        this.entryFee = entryFee;
        this.balanceDue = entryFee;
        this.lateFeeHistory = new double[10];
        this.lateFeeCount = 0;
        
        bibCounter++;
        this.entryCode = "ENTRY-" + bibCounter;
    }

    public void pay(double amount) {
        if (amount > 0) {
            this.balanceDue -= amount;
        }
    }

    public void pay(double amount, String mode) {
        System.out.println("Paying via " + mode);
        pay(amount);
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String getBibNumber() {
        return bibNumber;
    }

    protected void applyLateFee(double amount) {
        if (amount > 0 && lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount++] = amount;
            balanceDue += amount;
        }
    }

    public double[] getLateFeeHistory() {
        return Arrays.copyOf(lateFeeHistory, lateFeeCount);
    }

    public String announce() {
        return "Race Entry | Bib: " + bibNumber + " | Balance: " + balanceDue;
    }

    public static int getBibCounter() {
        return bibCounter;
    }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5) return false;
        if (code.charAt(0) != 'M') return false;
        if (!Character.isDigit(code.charAt(1))) return false;
        if (!Character.isDigit(code.charAt(2))) return false;
        if (!Character.isDigit(code.charAt(3))) return false;
        if (!Character.isUpperCase(code.charAt(4))) return false;
        return true;
    }

    public static String registerBatch(String[] bibNumbers, double entryFee) {
        int registered = 0;
        int rejected = 0;
        if (bibNumbers != null) {
            for (String bib : bibNumbers) {
                try {
                    new RaceEntry(bib, entryFee);
                    registered++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }
        return "Registered: " + registered + " | Rejected: " + rejected;
    }
}