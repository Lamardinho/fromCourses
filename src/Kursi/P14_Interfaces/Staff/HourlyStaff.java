package Kursi.P14_Interfaces.Staff;
/*Первый класс – class HourlyStaff – работники с почасовой зарплатой. В классе должно быть поле private int workTime,
обозначающее количество отработанных в сутки часов, и геттер для него.

Должен быть реализован конструктор, в котором workTime инициализируется значением, лежащим в диапазоне от 4 до 10 часов.
Если значение выходит за рамки диапазона, то присваивать workTime значение 0.

И треб. реализовать метод int calculateSalary(int salary), который возвращает зарплату за отработ.промеж. времени (salary*workTime);*/

class HourlyStaff implements Staff {     //работники с почасовой зарплатой
    private int workTime;

    public int getWorkTime() {
        return workTime;
    }

    public HourlyStaff(int workTime) { // конструктор для почасовый оплаты
        if (workTime > 3 & workTime < 11) this.workTime = workTime;
        else this.workTime = 0;
    }

    @Override
    public int calculateSalary(int salary) {
        return salary > 0 ? salary * workTime : 0;
    } // для расчета зарплаты

    public static void main(String[] args) {
        HourlyStaff ob = new HourlyStaff(100);
        System.out.println(ob.workTime);
        System.out.println(ob.getWorkTime());
    }
}
