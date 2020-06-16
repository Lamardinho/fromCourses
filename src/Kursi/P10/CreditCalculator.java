package Kursi.P10;
/* Задача реализовать утилиту расчета ежемесячных платежей на основании введенных данных о клиенте и условиях кредитования.
+ Необходимо реализовать класс CreditCalculator в пакете com.intellekta.creditbank, удовлетворяющий следующим условиям:
+ 1. В классе должны быть определены поля: lastName (тип данных - String) – фамилия человека, имеющего кредит; + firstName (тип данных - String) – имя человека, имеющего кредит;
+ secondName (тип данных - String) – отчество человека, имеющего кредит; sum (тип данных - double) – сумма кредита;
+ loanMaturity (тип данных - int) – срок погашения кредита; interestRate (тип данных - double) – процентная ставка по кредиту.

2.  В классе должен быть реализован конструктор без параметров, который будет собирать данные о пользователе с помощью консоли
и заполнять поля объекта данными, введенными пользователем.
3. В классе должен быть реализован метод printCreditAgreement, который не принимает параметры и не возвращает значения.
Метод должен выводить на консоль сумму ежемесячного платежа для клиента в виде действительного числа с точностью до копеек.

Необходимо обеспечить выполнение следующих требований к алгоритму ввода данных:
+ 1) Утилита должна выводить информацию о том, какие данные должен ввести пользователь в следующей последовательности и в формате:
+ «Lastname: »«Firstname: »«Secondname: »«Interest rate: »«Credit amount: »«Loan maturity: »
+ 2) При вводе данных должна осуществляться проверка вводимых данных, и если пользователь ввел некорректные данные,
+ должно выводиться предупреждение и новое приглашение ввода данных (для того поля, значение которого пользователь ввел некорректно)
+ 3) При выводе предупреждений необходимо руководствоваться следующими правилами:
+ если ввел в качестве Lastname пустую строку, выводить предупреждение: «Lastname is incorrect. It must be not empty string»;
+ если ввел в качестве Firstname пустую строку, выводить предупреждение: «Firstname is incorrect. It must be not empty string»;
+ если ввел в качестве Interest rate значение, не являющееся действительным положительным числом, выводить предупреждение:
+ «Interest rate is incorrect. It must be strictly positive number»;
+ если ввел в качестве Credit amount значение, не являющееся действительным положительным числом, выводить предупреждение:
+ «Credit amount is incorrect. It must be strictly positive number»;
+ если ввел в качестве Loan maturity значение, не являющееся целым положительным числом, выводить предупреждение:
+ «Loan maturity is incorrect. It must be strictly positive int».

Примечание:
Кредит выплачивается аннуитетными платежами (т. е. каждый месяц человек, имеющий кредит, должен выплачивать фиксированную сумму,
состоящую из части от общей суммы долга и начисленных процентов). Формула для расчетов данного вида платежей представлена ниже:
// формула
где Pl – размер ежемесячного платежа, S – общая сумма кредита, Pgodovaya – размер годовой процентной ставки,
Т – время выплаты кредита (в месяцах).
Для возведения в степень можно использовать статический метод pow класса Math.
В качестве ответа на задание приведи исходный код разработанного класса CreditCalculator. */

import java.util.Scanner;

class CreditCalculator {
    // объявляем наш сканер:
    static java.util.Scanner Scanner = new Scanner(System.in);

    String lastName;    // фамилия человека, имеющего кредит;
    String firstName;   // имя человека, имеющего кредит;
    String secondName;  // отчество человека, имеющего кредит;
    double sum;         // сумма кредита;
    int loanMaturity;   // срок погашения кредита;
    double interestRate;// процентная ставка по кредиту.
    double Pl; // формула

    // конструктор без параметров, не понял как его можно использовать, сделал по своему
    CreditCalculator() {
        System.out.print("LastName: ");
        lastName = getLastName();
        System.out.print("FirstName: ");
        firstName = getFirstName();
        System.out.print("SecondName: ");
        secondName = getSecondName();
        System.out.print("Interest rate: "); // процентная ставка по кредиту.
        interestRate = getInterestRate();
        System.out.print("Credit amount: "); // сумма кредита;
        sum = getSum();
        System.out.print("Loan maturity: "); // срок погашения кредита;
        loanMaturity = getLoanMaturity();
        // формула вычисления
        Pl = Math.round(((sum * (interestRate / (1200))) / (1 - (Math.pow((1 + (interestRate / (1200))), -loanMaturity)))) * 100.0) / 100.0;
    }

    // Метод выводит на консоль сумму ежемесячного платежа для клиента в виде действительного числа с точностью до копеек.
    void printCreditAgreement() {
        System.out.println("\nMonthly payment for " + lastName + " " + firstName + " " + secondName + "\n= " + Pl);
    }

    // запрос фамилии
    private static String getLastName() {
        String str;
        if (Scanner.hasNextLine()) {
            str = Scanner.nextLine();
            if (str.equals("")) {
                System.out.print("LastName is incorrect. It must be not empty string: ");
                str = getLastName();
            }
            return str;
        } else str = getLastName();
        return str;
    }

    // запрос имени
    private static String getFirstName() {
        String str;
        if (Scanner.hasNextLine()) {
            str = Scanner.nextLine();
            if (str.equals("")) {
                System.out.print("FirstName is incorrect. It must be not empty string: ");
                str = getFirstName();
            }
            return str;
        } else Scanner.next();//рекурсия
        str = getFirstName();
        return str;
    }

    // запрос отчества
    private static String getSecondName() {
        String str;
        if (Scanner.hasNextLine()) {
            str = Scanner.nextLine();
            if (str.equals("")) {
                System.out.print("SecondName is incorrect. It must be not empty string: ");
                str = getSecondName();
            }
            return str;
        } else Scanner.next();//рекурсия
        str = getSecondName();
        return str;
    }

    // запрос процентная ставка по кредиту
    private static double getInterestRate() {
        double num;
        if (Scanner.hasNextDouble()) num = Scanner.nextDouble();
        else {
            System.out.print("a) You made a mistake while entering the number!\nb) Write fractional numbers separated by commas: ");
            Scanner.next();//рекурсия
            num = getInterestRate();
        }
        if (num <= 0.0) {
            System.out.print("Interest rate is incorrect. It must be strictly positive number: ");
            num = getInterestRate();
        }
        //   if (!Scanner.hasNextDouble()) System.out.println("123");
        return num;
    }

    // запрос суммы по кредиту
    private static double getSum() {
        double num;
        if (Scanner.hasNextDouble()) num = Scanner.nextDouble();
        else {
            System.out.print("a) You made a mistake while entering the number!\nb) Write fractional numbers separated by commas: ");
            Scanner.next();//рекурсия
            num = getSum();
        }
        if (num <= 0.0) {
            System.out.print("Credit amount is incorrect. It must be strictly positive number: ");
            num = getSum();
        }
        return num;
    }

    // запрос срока погашения кредита;
    private static int getLoanMaturity() {
        int num;
        if (Scanner.hasNextInt()) num = Scanner.nextInt();
        else {
            System.out.print("Loan maturity is incorrect. It must be strictly positive int: ");
            Scanner.next();     // рекурсия (повтор)
            num = getLoanMaturity();
        }
        if (num <= 0) {
            System.out.print("Loan maturity is incorrect. It must be strictly positive int: ");
            num = getLoanMaturity();
        }
        return num;
    }

    public static void main(String[] args) {
        CreditCalculator obj = new CreditCalculator();
        obj.printCreditAgreement();
    }
}
