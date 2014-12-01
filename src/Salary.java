public class Salary implements DBObject {
    private  int id;
    private Person person;
    private int monthPay;
    private int yearPay;
    private int summPay;

    public int getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public int getMonthPay() {
        return monthPay;
    }

    public int getYearPay() {
        return yearPay;
    }

    public int getSummPay() {
        return summPay;
    }

    public Salary(int id,Person person, int monthPay, int yearPay, int summPay) {
        this.id = id;
        this.person = person;
        this.monthPay = monthPay;
        this.yearPay = yearPay;
        this.summPay = summPay;
    }
}
