import java.util.ArrayList;
import java.util.HashMap;

public class Office {
    private ArrayList<Department> departments;
    private ArrayList<Person> persons;
    private ArrayList<Salary> salary;

    public Office(){
        departments = new ArrayList<Department>();
        persons = new ArrayList<Person>();
        salary = new ArrayList<Salary>();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public ArrayList<Salary> getSalary() {
        return salary;
    }

    public void addNewDepartment(String name){
        departments.add(new Department(departments.size(), name));
    }

    public void addNewPerson(int departmentId, String fio){
        persons.add(new Person(persons.size(), departments.get(departmentId), fio));
    }

    public void addNewSalary(int personId, int monthPay, int yearPay, int summPay){
        salary.add(new Salary(persons.size(), persons.get(personId), monthPay, yearPay, summPay));
    }

    public int getPersonSalary(int personId){
        int result = 0;
        for (Salary aSalary : salary) {
            if (aSalary.getPerson().getId() == personId) {
                result += aSalary.getSummPay();
            }
        }
        return result;
    }

    public int getDepartmentSalary(int departmentId){
        int result = 0;
        for (Person aPerson : persons) {
            if (aPerson.getDepartment().getId() == departmentId) {
                result += getPersonSalary(aPerson.getId());
            }
        }
        return result;
    }

    public HashMap<String, Integer> getSalaries(){
        HashMap<String, Integer> salaries = new HashMap<String, Integer>();
        for (Department aDepartment : departments){
            salaries.put(aDepartment.getName(), getDepartmentSalary(aDepartment.getId()));
        }
        return salaries;
    }


}
