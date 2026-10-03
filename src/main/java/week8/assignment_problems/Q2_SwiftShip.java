package week8.assignment_problems;
import java.util.*;

enum Status { BOOKED, PICKED_UP, IN_TRANSIT, OUT_FOR_DELIVERY, DELIVERED }
interface ShippingType { double calculateCharge(double weight); }
class Standard implements ShippingType { public double calculateCharge(double weight) { return 40 + (10 * weight); } }
class Express implements ShippingType { public double calculateCharge(double weight) { return 80 + (15 * weight); } }
class Fragile implements ShippingType { 
    Standard std = new Standard(); 
    public double calculateCharge(double weight) { return std.calculateCharge(weight) + 50; } 
}

interface NotificationChannel { void notify(String msg); }
class SmsChannel implements NotificationChannel { public void notify(String msg) { System.out.println("[SMS] " + msg); } }
class EmailChannel implements NotificationChannel { public void notify(String msg) { System.out.println("[Email] " + msg); } }

public class Q2_SwiftShip {
    String id; double weight; ShippingType type; Status status = Status.BOOKED;
    List<NotificationChannel> channels = new ArrayList<>();

    public Q2_SwiftShip(String id, double weight, ShippingType type) {
        this.id = id; this.weight = weight; this.type = type;
        System.out.println("Parcel " + id + " booked. Charge: ₹" + String.format("%.2f", type.calculateCharge(weight)));
    }
    public void subscribe(NotificationChannel c) { channels.add(c); c.notify(id + " is now " + status); }
    public void advanceStatus(Status next) {
        if (next.ordinal() <= status.ordinal() || next.ordinal() - status.ordinal() > 1) {
            System.out.println("Invalid transition: " + status + " -> " + next + " is not allowed."); return;
        }
        this.status = next; channels.forEach(c -> c.notify(id + " is now " + status));
    }
    public void cancel() {
        if (status != Status.BOOKED) System.out.println("Cancellation failed: " + id + " can be cancelled only while BOOKED.");
        else System.out.println("Parcel " + id + " cancelled.");
    }
}
