import java.util.ArrayList;
import java.util.HashMap;

public class Reporter {

    Office myOffice;

    public void makeReport(){
        myOffice = new Office();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите действие");
        while (true){
            String answer = scanner.nextLine();
            if (answer.equals("add department")) {
                addDepartment();
            } else if (answer.equals("add person")) {
                addPerson();
            } else if (answer.equals("add salary")) {
                    addSalary();
            } else if (answer.equals("make report")) {
                printSalary();
            } else if (answer.equals("print departments")) {
                printDepartments();
            } else if (answer.equals("print persons")) {
                printPersons();
            } else if (answer.equals("end")) {
                break;
            }
        }



    }

    public void addDepartment(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите имя департамента");
        String answer = scanner.nextLine();
        myOffice.addNewDepartment(answer);
        System.out.println("Департамент добавлен");
    }

    public void addPerson(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите фио");
        String fio = scanner.nextLine();
        System.out.println("Введите ID департамента");
        String depId = scanner.nextLine();
        myOffice.addNewPerson(Integer.parseInt(depId) , fio);
        System.out.println("Работник добавлен");
    }

    public void addSalary(){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Введите ID работника");
        String id = scanner.nextLine();
        System.out.println("Введите месяц");
        String month = scanner.nextLine();
        System.out.println("Введите год");
        String year = scanner.nextLine();
        System.out.println("Введите з/п");
        String salary = scanner.nextLine();
        myOffice.addNewSalary(Integer.parseInt(id), Integer.parseInt(month), Integer.parseInt(year), Integer.parseInt(salary));
        System.out.println("З/п добавлена");
    }

    public void printSalary(){
        HashMap<String, Integer> report = myOffice.getSalaries();
        salaryPrinter(report);
    }

    private void salaryPrinter(HashMap<String, Integer> report){
        System.out.print(report + "\n");
    }

    private void  printDepartments(){
        ArrayList<Department> list = myOffice.getDepartments();
        for (Department aDepartments : list){
            System.out.print(aDepartments.getId() + " " + aDepartments.getName() + "\n");
        }
    }

    private void printPersons(){
        ArrayList<Person> list = myOffice.getPersons();
        for (Person aPerson : list){
            System.out.print(aPerson.getId() + " " + aPerson.getFio() + " " + aPerson.getDepartment().getName() + "\n");
        }
    }

}
