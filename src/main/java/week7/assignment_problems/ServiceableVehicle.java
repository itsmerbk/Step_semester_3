package week7.assignment_problems;
public abstract class ServiceableVehicle {
    private double mileage = 0.0;
    public abstract String performMaintenance();
    public double getMileage() { return mileage; }
    public void addMileage(double km) { if(km >= 0) this.mileage += km; }
}
