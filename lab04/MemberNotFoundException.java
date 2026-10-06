import java.util.List;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String message) {
        super(message);
    }

    /** Small demo: looks a member up and fails with a clear message. */
    public static String findMember(List<String> members, String id) throws MemberNotFoundException {
        if (!members.contains(id)) {
            throw new MemberNotFoundException("Member with ID '" + id + "' was not found.");
        }
        return id;
    }

    public static void main(String[] args) {
        List<String> members = List.of("M001", "M002", "M003");
        try {
            System.out.println("Found member: " + findMember(members, "M002"));
            findMember(members, "M999");
        } catch (MemberNotFoundException e) {
            System.out.println("Lookup failed: " + e.getMessage());
        }
    }
}
