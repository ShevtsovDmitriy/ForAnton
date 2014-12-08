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

    public String addNewDepartment(String name){
        departments.add(new Department(departments.size(), name));
        return "Департамент добавлен";
    }

    public String addNewPerson(int departmentId, String fio){
        if (departments.size() > departmentId){
            persons.add(new Person(persons.size(), departments.get(departmentId), fio));
            return "Работник добавлен";
        }
        else return "Ошибка добавления, неверный ID департамента. Для просмотра всех департаментов введите команду print departments";
    }

    public String addNewSalary(int personId, int monthPay, int yearPay, int summPay){
        if(persons.size() > personId) {
            salary.add(new Salary(persons.size(), persons.get(personId), monthPay, yearPay, summPay));
            return "З/п добавлена";
        }
        else return "Ошибка добавления, неверный ID работника. Для просмотра всех работников введите команду print persons";
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
