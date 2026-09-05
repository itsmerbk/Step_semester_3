package week5.assigment_problems;
public class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String hashedSecurityAnswer;
    private boolean idSet = false;
    public LibraryMemberBean() {
        this(null, null);
    }
    public LibraryMemberBean(String name) {
        this(null, name);
    }
    public LibraryMemberBean(String membershipId, String name) {
        if (membershipId != null) {
            this.membershipId = membershipId;
            this.idSet = true;
        }
        this.name = name;
    }
    public String getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(String id) {
        if (!idSet && id != null) {
            this.membershipId = id;
            this.idSet = true;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isPremiumMember() {
        return premiumMember;
    }
    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }
    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            this.hashedSecurityAnswer = "HASH_" + answer.hashCode();
        }
    }
    public static void main(String[] args) {
        System.out.println(new LibraryMemberBean("Priya Nair").getMembershipId());
        System.out.println(new LibraryMemberBean("LIB-8841", "Priya Nair").getMembershipId());
        LibraryMemberBean m = new LibraryMemberBean();
        m.setMembershipId("LIB-8841");
        m.setMembershipId("FAKE-0000");
        System.out.println(m.getMembershipId());
    }
}
