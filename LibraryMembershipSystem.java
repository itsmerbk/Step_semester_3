package oop.assigment_problems;
class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;
    public BrokenLibraryMember(String n, String id, int books) {
        name = n;
        memberId = id;
        booksIssued = books;
    }
    public void printName() {
        System.out.println(name);
    }
}
class LibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;
    private static String libraryName = "Central Library";
    private static int memberCount = 1000;
    public LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-" + memberCount;
    }
    public void printMemberCard() {
        System.out.println(name + "  " + memberId);
    }
    public static void printTotalMembers() {
        System.out.println("Total members: " + (memberCount - 1000));
    }
}
public class LibraryMembershipSystem {
    public static void main(String[] args) {
        BrokenLibraryMember m1 = new BrokenLibraryMember("Aditi", "1", 2);
        BrokenLibraryMember m2 = new BrokenLibraryMember("Rohan", "2", 1);
        System.out.println("Broken version output:");
        m1.printName();
        m2.printName();
        System.out.println("\nFixed version output:");
        LibraryMember fixed1 = new LibraryMember("Aditi", 2);
        LibraryMember fixed2 = new LibraryMember("Rohan", 1);
        fixed1.printMemberCard();
        fixed2.printMemberCard();
        LibraryMember.printTotalMembers();
    }
}
