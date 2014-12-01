public class Department implements DBObject {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
