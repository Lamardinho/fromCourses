package Kursi.P1_Cicles;
/*Приведи фрагмент исходного кода, содержащего определение публичного статичного метода checkWeight.
В метод должен передаваться массив чисел типа double. В методе должен вычисляться средний вес таблеток с исходным
веществом и, если средний вес меньше, чем эталонный на 10% и более,
на экран должно выводиться сообщение "Not enough substance", в противном случае — должно выводиться сообщение "Ok".*/

// Задание принято

public class T7 {
    public static void checkWeight(double[] t) {
        double reference = 0.050 * 0.9; // эталонный минимум
        String error = "Not enough substance"; // стринга для вывода предупреждения

        if (t.length == 0) {
            System.out.println(error);
            System.exit(0);// если массив пустой то 'error'
        } else { // в остальных случаях считаем:
            for (int i = 0; i < t.length; i += 3) {
                if (t[i] < reference) {
                    System.out.println(error);
                    System.exit(0);
                }
            }
        }
        System.out.println("Ok");
    }

    public static void main(String[] args) {
        double[] tablets = {0.052, 0.048, 0.052, 0.043, 0.050, 0.048, 0.049, 0.054, 0.048, 0.045};
        checkWeight(tablets);
    }
}
