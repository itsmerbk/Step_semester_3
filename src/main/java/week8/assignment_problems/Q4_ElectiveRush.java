package week8.assignment_problems;
import java.util.*;

enum StudentType { REGULAR(24), HONORS(28), EXCHANGE(20); int limit; StudentType(int limit) { this.limit = limit; } }
class Student { String name; StudentType type; int currentCredits; public Student(String n, StudentType t, int c) { name = n; type = t; currentCredits = c; } }

public class Q4_ElectiveRush {
    String name; int credits; int capacity; 
    List<Student> enrolled = new ArrayList<>(); Queue<Student> waitlist = new LinkedList<>();

    public Q4_ElectiveRush(String n, int cred, int cap) { name = n; credits = cred; capacity = cap; }
    
    public void enroll(Student s) {
        if (s.currentCredits + credits > s.type.limit) {
            System.out.println("Enrollment failed: " + s.name + " would exceed limit (" + (s.currentCredits + credits) + "/" + s.type.limit + ")."); return;
        }
        if (enrolled.contains(s) || waitlist.contains(s)) return;
        if (enrolled.size() < capacity) {
            enrolled.add(s); s.currentCredits += credits;
            System.out.println(s.name + " enrolled in " + name + " (credits: " + s.currentCredits + "/" + s.type.limit + ").");
        } else {
            waitlist.add(s); System.out.println(name + " is full. " + s.name + " added to waitlist.");
        }
    }
    public void drop(Student s) {
        if (enrolled.remove(s)) {
            s.currentCredits -= credits; System.out.println(s.name + " dropped " + name + ".");
            if (!waitlist.isEmpty()) enroll(waitlist.poll());
        }
    }
}
