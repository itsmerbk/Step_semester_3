package week7.assignment_problems;
public class UserProfile implements Exportable {
    private String username;
    public UserProfile(String username) { this.username = username; }
    @Override public String exportData() {
        ExportManager.increment();
        return "Exported profile: " + username;
    }
}
