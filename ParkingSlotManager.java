package oop.assigment_problems;
class ParkingSlot {
    String slotNo;
    int capacity;
    int occupiedCount;
    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }
    public boolean allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
            return true;
        }
        return false;
    }
}
public class ParkingSlotManager {
    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        if (slots == null) return null;
        for (ParkingSlot slot : slots) {
            if (slot != null && slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }
        return null;
    }
    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot slot = findAvailableSlot(slots);
        if (slot != null) {
            slot.allot(vehicleNo);
            System.out.println(vehicleNo + " allotted to slot " + slot.slotNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }
    public static void main(String[] args) {
        ParkingSlot[] availableTest = {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(availableTest, "TN09AB1234");
        ParkingSlot[] fullTest = {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(fullTest, "TN09AB1234");
    }
}
