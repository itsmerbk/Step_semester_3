package week4.assigment_problems;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class DeliverySlot {
    private static final String DEFAULT_SLOT = "ASAP";
    private static final Set<String> PEAK_SLOTS = new HashSet<>(Arrays.asList(
        "12:00-13:00", "13:00-14:00", "19:00-20:00", "20:00-21:00"
    ));
    private final String orderId;
    private final String timeSlot;
    public DeliverySlot(String orderId, String timeSlot) {
        this.orderId = orderId;
        this.timeSlot = (timeSlot == null || timeSlot.trim().isEmpty()) ? DEFAULT_SLOT : timeSlot;
    }
    public DeliverySlot(String orderId) {
        this(orderId, DEFAULT_SLOT);
    }
    public boolean isPeakHour() {
        return PEAK_SLOTS.contains(this.timeSlot);
    }
    public static void main(String[] args) {
        DeliverySlot slot1 = new DeliverySlot("ORD101", "13:00-14:00");
        DeliverySlot slot2 = new DeliverySlot("ORD102");
        System.out.println(slot1.isPeakHour());
        System.out.println(slot2.isPeakHour());
    }
}
