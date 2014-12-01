public class Person implements DBObject {
    private int id;
    private Department department;
    private String fio;

    public int getId() {
        return id;
    }

    public Department getDepartment() {
        return department;
    }

    public String getFio() {
        return fio;
    }

    public Person(int id, Department department, String fio) {
        this.id = id;
        this.department = department;
        this.fio = fio;
    }
}
