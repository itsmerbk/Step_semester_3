package week8.assignment_problems;
import java.util.*;

interface PricingPlan { double getPrice(double base); }
class DayScholarPlan implements PricingPlan { public double getPrice(double base) { return base; } }
class HostellerPlan implements PricingPlan { public double getPrice(double base) { return base * 0.9; } }
class StaffPlan implements PricingPlan { public double getPrice(double base) { return base * 0.8; } }

class Transaction { double amount; String desc; public Transaction(double a, String d) { amount = a; desc = d; } }

public class Q5_CanteenCard {
    String id; PricingPlan plan; boolean blocked = false;
    List<Transaction> txns = new ArrayList<>(); Set<String> refunded = new HashSet<>();

    public Q5_CanteenCard(String id, PricingPlan plan) { this.id = id; this.plan = plan; }
    private double getBalance() { return txns.stream().mapToDouble(t -> t.amount).sum(); }

    public void topUp(double amt) {
        if (blocked || amt < 100 || getBalance() + amt > 5000) { System.out.println("Top-up failed."); return; }
        txns.add(new Transaction(amt, "Top-up")); System.out.println(id + " topped up. Balance: ₹" + String.format("%.2f", getBalance()));
    }
    public void purchase(String item, double price) {
        if (blocked) return;
        double finalPrice = plan.getPrice(price);
        if (getBalance() < finalPrice) { System.out.println("Purchase failed: Insufficient balance."); return; }
        txns.add(new Transaction(-finalPrice, item)); System.out.println(item + " purchased. Balance: ₹" + String.format("%.2f", getBalance()));
    }
    public void refund(String item, double basePrice) {
        if (blocked || refunded.contains(item)) { System.out.println("Refund rejected: " + item + " already refunded."); return; }
        double finalPrice = plan.getPrice(basePrice);
        txns.add(new Transaction(finalPrice, "Refund: " + item)); refunded.add(item);
        System.out.println("Refund processed for " + item + ". Balance: ₹" + String.format("%.2f", getBalance()));
    }
}
