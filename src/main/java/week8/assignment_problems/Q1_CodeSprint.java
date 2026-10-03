package week8.assignment_problems;
import java.util.*;

interface ScoringRule { double calculate(double idea, double exec, double pres); }
class InnovationTrack implements ScoringRule { 
    public double calculate(double idea, double exec, double pres) { return (idea * 0.5) + (exec * 0.3) + (pres * 0.2); } 
}
class OpenTrack implements ScoringRule { 
    public double calculate(double idea, double exec, double pres) { return (idea + exec + pres) / 3.0; } 
}

class Team {
    String name; List<String> members; ScoringRule track; String project; double score = -1;
    public Team(String name, List<String> members, ScoringRule track) {
        if (members.size() < 2 || members.size() > 4) throw new IllegalArgumentException("A team must have 2 to 4 members.");
        this.name = name; this.members = members; this.track = track;
    }
}

public class Q1_CodeSprint {
    List<Team> teams = new ArrayList<>();
    boolean published = false;

    public void registerTeam(String name, List<String> members, ScoringRule track) {
        try { teams.add(new Team(name, members, track)); System.out.println("Team " + name + " registered."); } 
        catch (Exception e) { System.out.println("Registration failed: " + e.getMessage()); }
    }
    public void submitProject(String teamName, String project) {
        teams.stream().filter(t -> t.name.equals(teamName)).findFirst().ifPresent(t -> { t.project = project; System.out.println("Project '" + project + "' submitted by " + teamName + "."); });
    }
    public void scoreProject(String project, double idea, double exec, double pres) {
        if (published) { System.out.println("Rescore rejected: Results have already been published."); return; }
        teams.stream().filter(t -> project.equals(t.project)).findFirst().ifPresent(t -> {
            t.score = t.track.calculate(idea, exec, pres);
            System.out.println("Score recorded for '" + project + "'. Final score: " + String.format("%.2f", t.score));
        });
    }
    public void publishResults() { this.published = true; System.out.println("Results published."); }
}
