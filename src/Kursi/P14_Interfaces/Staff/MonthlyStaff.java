package Kursi.P14_Interfaces.Staff;

/* Второй класс – class MonthlyStaff – работники с месячной зарплатой.
+ Класс должен иметь два приватных поля: int workDays, int premium, означающие количество отработанных дней и премию,
+ а также геттеры для этих полей.
+ В конструкторе инициализировать обе переменные передающимися значениями.
+ Если количество отработанных дней меньше или равно нулю или больше 30, то присвоить переменной workDays значение 0.
+ Если премия меньше нуля или больше 10000, то присвоить переменной premium значение 0,
а также реализовать метод int calculateSalary(int salary), чтобы он возвращал зарплату за месяц, т. е. salary*workDays+premium. */

class MonthlyStaff implements Staff {    //работники с месячной зарплатой
    private int workDays;
    private int premium;

    public int getWorkDays() {
        return workDays;
    }

    public int getPremium() {
        return premium;
    }

    public MonthlyStaff(int workDays, int premium) { // конструктор для помесячной оплаты
        if (workDays <= 0 || workDays > 30) this.workDays = 0;
        else this.workDays = workDays;

        if (premium < 0 || premium > 10000) this.premium = 0;
        else this.premium = premium;
    }

    @Override
    public int calculateSalary(int salary) {
        return salary >= 0 ? salary * workDays + premium : premium;
    } // для расчета зарплаты

    /*public static void main(String[] args) { // для теста
        MonthlyStaff ob = new MonthlyStaff(-5, -10000);
        System.out.println(ob.calculateSalary(-500));
    }*/
}
