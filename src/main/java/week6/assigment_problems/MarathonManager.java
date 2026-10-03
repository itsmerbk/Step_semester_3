package week6.assigment_problems;

public class MarathonManager {

    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry) {
            return "Multilevel descendant (3 generations deep)";
        } else if (entry instanceof RelayTeamEntry) {
            return "Hierarchical sibling (independent branch)";
        } else if (entry instanceof RunnerEntry) {
            return "Single inheritance descendant (2 generations deep)";
        }
        return "Base Generation";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0.0;
        if (entries != null) {
            for (RaceEntry entry : entries) {
                if (entry != null) {
                    total += entry.getBalanceDue();
                }
            }
        }
        return total;
    }

    public static String announceAll(RaceEntry[] entries) {
        if (entries == null) return "";
        StringBuilder report = new StringBuilder();
        
        for (RaceEntry entry : entries) {
            if (entry == null) continue;
            
            report.append(entry.announce());
            
            if (entry instanceof RelayTeamEntry) {
                RelayTeamEntry relay = (RelayTeamEntry) entry;
                report.append(" [Team size via downcast: ").append(relay.getTeamSize()).append("]");
            }
            report.append(" | ");
        }
        return report.toString();
    }

    public static String settleNight(RaceEntry[] entries) {
        if (entries == null) return "0 processed | 0 null skipped | 0 relay | 0 individual";
        
        int processed = 0;
        int nullSkipped = 0;
        int relay = 0;
        int individual = 0;
        
        for (RaceEntry entry : entries) {
            if (entry == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (entry instanceof RelayTeamEntry) {
                relay++;
            } else {
                individual++;
            }
        }
        
        return processed + " processed | " + nullSkipped + " null skipped | " + 
               relay + " relay | " + individual + " individual";
    }

    public static void main(String[] args) {
        System.out.println(RaceEntry.registerBatch(new String[]{"BIB1", "B1", "BIB2"}, 80));
        RunnerEntry r = new RunnerEntry("BIB2001", 80, "Open 10K");
        r.pay(30);
        
        EliteRunnerEntry eliteEntry = new EliteRunnerEntry("BIB3001", 150, "Elite Full Marathon", 500);
        RelayTeamEntry relayEntry = new RelayTeamEntry("BIB4001", 300, 4);
        System.out.println(classifyGeneration(eliteEntry));
        System.out.println(classifyGeneration(relayEntry));
        System.out.println("Total Balance: " + getTotalBalanceDue(new RaceEntry[]{r, eliteEntry, relayEntry}));

        r.applyLateFee(20);
        double[] history = r.getLateFeeHistory();
        history[0] = 999;
        System.out.println("Runner balance: " + r.getBalanceDue());
        System.out.println("Protected History: [" + r.getLateFeeHistory()[0] + "]");

        RaceEntry[] fleet = { r, relayEntry };
        System.out.println(announceAll(fleet));

        System.out.println("isValid M123A: " + RaceEntry.isValidDiscountCode("M123A"));
        System.out.println("isValid M12A: " + RaceEntry.isValidDiscountCode("M12A"));
        r.pay(10, "UPI");
        System.out.println(settleNight(new RaceEntry[]{eliteEntry, null, relayEntry}));
        System.out.println("Total Valid Bibs Constructed: " + RaceEntry.getBibCounter());
    }
}