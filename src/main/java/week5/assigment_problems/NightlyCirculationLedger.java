package week5.assigment_problems;
import java.util.Arrays;
import java.util.regex.Pattern;
class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;
    private static final Pattern BOOK_ID_PATTERN = Pattern.compile("^BK-\\d{3}$");

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || bookIds == null) {
            throw new IllegalArgumentException("Parameters cannot be null.");
        }
        for (String id : bookIds) {
            if (id == null || !BOOK_ID_PATTERN.matcher(id).matches()) {
                throw new IllegalArgumentException("Invalid book ID format: " + id);
            }
        }
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }
    public String getMemberId() {
        return memberId;
    }
    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }
    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        String[] updated = Arrays.copyOf(bookIds, bookIds.length);
        updated[index] = newId;
        return new LoanReceipt(this.memberId, updated);
    }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
    public String getRoomNumber() {
        return roomNumber;
    }
}
public class NightlyCirculationLedger {
    private static String systemStatus;
    static {
        systemStatus = "LEDGER_INITIALIZED";
    }
    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        if (receipts == null) return "0 processed | 0 null skipped | 0 reference-only | 0 regular";
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;
        for (LoanReceipt r : receipts) {
            if (r == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " +
               referenceOnly + " reference-only | " + regular + " regular";
    }
    public static void main(String[] args) {
        try {
            new LoanReceipt("LIB-8841", new String[]{"BK-100", "bad"});
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println(r.getBookIds()[0]);
        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(processNightlyCirculation(batch));
    }
}
