package week7.assignment_problems;
public abstract class HomeDevice {
    private static int counter = 1000;
    private final String serialNumber;
    public HomeDevice() {
        counter++;
        this.serialNumber = "HD-" + counter;
    }
    public abstract String activate();
    public String getSerialNumber() { return serialNumber; }
}
