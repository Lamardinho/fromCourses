package Kursi.P14_Interfaces.Staff;

/*От второго класса унаследовать класс WeeklyStaff – работники, которые работают две недели из четырех в месяц.
+ В нем добавить приватную переменную workWeeks и геттер для нее.
+ Реализовать конструктор, вызывающий базовый конструктор и инициализирующий переменную workWeeks значением в диапазоне от 2 до 4.
+ При выходе значения из данного диапазона переменной присваивать значение 0.
+ Переопределить метод int calculateSalary(int salary), чтобы тот возвращал зарплату за неделю, т. е. workWeeks*salary,
+ а также добавить метод void printYearSalary, выводящий методом println годовую  зарплату работника,
т. е. workWeeks*salary*26 (Количество недель в году -52, из них половина рабочих).*/

public class WeeklyStaff extends MonthlyStaff implements Staff {
    private int workWeeks; // кол-во рабочих недель

    public int getWorkWeeks() {
        return workWeeks;
    } // геттер

    public WeeklyStaff(int workDays, int premium, int workWeeks) { // конструктор для понедельной оплаты
        super(workDays, premium); // наследование от главного класса
        this.workWeeks = workWeeks > 1 & workWeeks < 5 ? workWeeks : 0;
    }

    @Override
    public int calculateSalary(int salary) {
        return salary > 0 ? workWeeks * salary : 0;
    }// для расчета зарплаты

    public void printYearSalary(int salary) {
        salary = salary > 0 ? workWeeks * salary * 26 : 0;
        System.out.println(salary);
    }

    public static void main(String[] args) {
        WeeklyStaff ob = new WeeklyStaff(4, 50, 4);
        // ob.calculateSalary(5);
        ob.printYearSalary(100);
    }
}
