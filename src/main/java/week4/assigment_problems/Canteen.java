package week4.assigment_problems;
public class Canteen implements Comparable<Canteen> {
    private final String canteenCode;
    private final String canteenName;
    private final int trustScore;
    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }
    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }
    @Override
    public int compareTo(Canteen other) {
        if (this.trustScore != other.trustScore) {
            return Integer.compare(other.trustScore, this.trustScore);
        }
        int codeComparison = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeComparison != 0) {
            return codeComparison;
        }
        return Integer.compare(this.canteenName.length(), other.canteenName.length());
    }
    public static Canteen[] rankCanteens(Canteen[] canteens) {
        if (canteens == null) return new Canteen[0];
        int n = canteens.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (canteens[j].compareTo(canteens[j + 1]) > 0) {
                    Canteen temp = canteens[j];
                    canteens[j] = canteens[j + 1];
                    canteens[j + 1] = temp;
                }
            }
        }
        return canteens;
    }
    public static void main(String[] args) {
        Canteen[] list = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats")
        };
        rankCanteens(list);
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print("\"" + list[i].canteenCode + "\"" + (i < list.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
