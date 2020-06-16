package Kursi.P13_Packeges.B;

/* Стоимость акции изменяется в зависимости от времени. Данную зависимость описывает функция:
    y = 5*sin(1/2 * t), где y – цена акции, а t – время.
Компания в случайный момент времени продает часть акций. Если значение функции попало в закрашенную область графика,
то компания совершила выгодную продажу, иначе – понесла убыток.

Тебе поставили задачу разработать соответствующее приложение.
+ Требуется создать пакет com.intellekta.randommoney, а в нем класс RandomMoney, удовлетворяющий следующим условиям:
+ 1. В классе определено поле double price с геттером.

+ + 2. В классе определен public void sale(), принимающий количество акций для продажи и время продажи (действительное число).

+ 3. Метод sale() должен соответствовать следующим требованиям:
+ метод вычисляет и сохраняет в поле price текущую стоимость акций, вычисленную по указанной в требованиях формуле (t-time);
+ метод вычисляет финансовый результат сделки на основе произведения числа продаваемых акций на текущую стоимость акций;
+ если финансовый результат положительный, метод должен выводить на экран сообщение:
+ «The company has earned USD» с точностью до двух знаков после запятой, без перевода на новую строку;
+ если финансовый результат нулевой, метод должен выводить на экран сообщение:
+ «The company did not earn anything and did not lose on the sale» без перевода на новую строку;
если финансовый результат отрицательный, метод должен выводить на экран сообщение:
«The company has lost USD» с точностью до двух знаков после запятой, без перевода на новую строку.

4. В классе должен быть определен public void testSale, не принимает параметры, но трижды вызывает метод sale с произвольными
целыми значениями для количества продаваемых акций и произвольными действительными значениями от 0 до 50 для времени продажи. */

import static java.lang.Math.sin;

public class RandomMoney {
    private double price;   // цена акции

    public double getPrice() {  // дать цену
        return price;
    }

    public void sale(int stocks, double time) { // метод для расчета стоимости акций
        price = 5 * sin(0.5 * time);    // посчитать price
        double price_all = stocks * (5 * sin(0.5 * time));  // посчитать сумму по переданным price & time
        if (price_all > 0) System.out.println(String.format("The company has earned %.2f USD", price_all));
        else if (price_all == 0) System.out.println("The company did not earn anything and did not lose on the sale");
        else {
            price_all = price_all * (-1);
            System.out.println(String.format("The company has lost %.2f USD", price_all));
        }
    }

    public void testSale() { // метод для тестировки
        // для рандомизации тоже можно было бы метод создать
        int a = 0; // число для рандома начальное значение диапазона - "от"
        int b = 50; // число для рандома конечное значение диапазона - "до"

        sale(a + (int) (Math.random() * b), a + (int) (Math.random() * b));
        sale(a + (int) (Math.random() * b), a + (int) (Math.random() * b));
        sale(a + (int) (Math.random() * b), a + (int) (Math.random() * b));
    }

    public static void main(String[] args) {
        RandomMoney ob = new RandomMoney();
        ob.testSale();
    }
}