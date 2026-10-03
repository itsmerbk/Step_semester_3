package week7.assignment_problems;
public class WashingMachine extends HomeDevice implements RemoteControllable, EnergyTrackable {
    private double consumptionWatts;
    public WashingMachine(double consumptionWatts) { this.consumptionWatts = consumptionWatts; }
    @Override public String activate() { return "Washing machine " + getSerialNumber() + " started a cycle"; }
    @Override public String connect(String appId) { return getSerialNumber() + " connected to " + appId; }
    @Override public double getConsumptionWatts() { return consumptionWatts; }
}
