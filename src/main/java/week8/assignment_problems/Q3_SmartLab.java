package week8.assignment_problems;
import java.util.*;

interface Capability { void apply(Object value); }
class PowerCapability implements Capability { 
    boolean on; 
    public void apply(Object value) { this.on = (Boolean) value; System.out.print((on ? "ON" : "OFF")); } 
}
class BrightnessCapability implements Capability { 
    int level; 
    public void apply(Object value) { 
        int v = (Integer) value; 
        if (v < 0 || v > 100) throw new IllegalArgumentException("brightness out of bounds"); 
        this.level = v; System.out.print("brightness set to " + v + "%"); 
    } 
}
class TemperatureCapability implements Capability { 
    int temp; 
    public void apply(Object value) { 
        int v = (Integer) value; 
        if (v < 16 || v > 30) throw new IllegalArgumentException("temperature must be between 16C and 30C"); 
        this.temp = v; System.out.print("temperature set to " + v + "C"); 
    } 
}

class Device {
    String name; Map<Class<?>, Capability> caps = new HashMap<>();
    public Device(String name) { this.name = name; }
    public void addCapability(Capability c) { caps.put(c.getClass(), c); System.out.println(name + ": " + c.getClass().getSimpleName() + " added."); }
    public void execute(Class<?> type, Object val) {
        if (caps.containsKey(type)) {
            try { System.out.print(name + ": "); caps.get(type).apply(val); System.out.println("."); } 
            catch (Exception e) { System.out.println("\nRejected: " + name + " " + e.getMessage()); }
        }
    }
}
