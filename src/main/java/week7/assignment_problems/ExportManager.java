package week7.assignment_problems;
public class ExportManager {
    private static int totalExports = 0;
    public static void increment() { totalExports++; }
    public static int getTotalExports() { return totalExports; }
    public static void exportAll(Exportable[] items) {
        if(items != null) {
            for(Exportable e : items) { if(e != null) System.out.println(e.exportData()); }
        }
    }
}
