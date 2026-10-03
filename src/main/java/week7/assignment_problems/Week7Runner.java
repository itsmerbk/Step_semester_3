package week7.assignment_problems;
public class Week7Runner {
    public static void printArea(Shape s) { System.out.println(s.calculateArea()); }
    
    public static String getInsuranceIfApplicable(ServiceableVehicle v) {
        if (v instanceof Insurable) return ((Insurable) v).getInsuranceInfo();
        return "No insurance record exists";
    }
    
    public static void resolveDefense(Defendable[] combatants) {
        if (combatants != null) {
            for (Defendable d : combatants) { if (d != null) System.out.println(d.defend()); }
        }
    }
    
    public static void connectAll(RemoteControllable[] items, String appId) {
        if (items != null) {
            for (RemoteControllable rc : items) { if (rc != null) System.out.println(rc.connect(appId)); }
        }
    }
    
    public static double getConsumptionIfTrackable(HomeDevice d) {
        if (d instanceof EnergyTrackable) return ((EnergyTrackable) d).getConsumptionWatts();
        return 0.0;
    }
    
    public static void main(String[] args) {
        // Run tests here if needed
    }
}
