package collection.set.member;

public class MemberOnlyHahs {

    private String id;

    public MemberOnlyHahs(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "MemberNoHashNoEq{" +
                "id='" + id + '\'' +
                '}';
    }
}
