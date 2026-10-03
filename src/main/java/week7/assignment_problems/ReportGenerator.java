package week7.assignment_problems;
public class ReportGenerator implements Exportable {
    private String reportName;
    public ReportGenerator(String reportName) { this.reportName = reportName; }
    @Override public String exportData() {
        ExportManager.increment();
        return "Exported report: " + reportName;
    }
}
