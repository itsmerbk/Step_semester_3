package week4.assigment_problems;
public class FoodOrder {
    private final String studentName;
    private final String dishName;
    private boolean delivered;
    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid student name");
        }
        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid dish name");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }
    public void markDelivered() {
        if (!delivered) {
            delivered = true;
            System.out.println("Order for " + studentName + " (" + dishName + ") marked delivered.");
        } else {
            System.out.println("WARNING: Order for " + studentName + " was already marked delivered!");
        }
    }
    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;
        for (String[] raw : rawOrders) {
            if (raw == null || raw.length < 2) {
                rejected++;
                continue;
            }
            try {
                new FoodOrder(raw[0], raw[1]);
                valid++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        System.out.println("Valid: " + valid + " | Rejected: " + rejected);
    }
    public static void main(String[] args) {
        String[][] rawOrders = {
            {"Ravi", "Paneer Butter Masala"},
            {"", "Chole Bhature"},
            {"Meera", "   "},
            {"Divya", "Veg Biryani"}
        };
        processBatch(rawOrders);
    }
}
