package week7.assignment_problems;
public class HeavyDutyForklift extends Forklift {
    public HeavyDutyForklift(String assetTag) { super(assetTag); }
    @Override public String performMaintenance() { return super.performMaintenance() + " | high-pressure hydraulic check complete"; }
}
