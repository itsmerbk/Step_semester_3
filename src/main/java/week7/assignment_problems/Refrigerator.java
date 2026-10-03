package week7.assignment_problems;
public class Refrigerator extends HomeDevice implements EnergyTrackable {
    private double consumptionWatts;
    public Refrigerator(double consumptionWatts) { this.consumptionWatts = consumptionWatts; }
    @Override public String activate() { return "Refrigerator " + getSerialNumber() + " cooling"; }
    @Override public double getConsumptionWatts() { return consumptionWatts; }
}
