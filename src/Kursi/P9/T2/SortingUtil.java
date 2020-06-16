package Kursi.P9.T2;

/* Реализуй класс SortingUtil, который будет содержать публичные статические методы, необходимые для сортировки значений массивов.
 Класс должен удовлетворять следующим требованиям:

+ должен быть публичный статичный свободный метод sortInts, который принимает в качестве параметров массив
целых чисел типа int. Метод должен выполнять сортировку массива по возрастанию. Алгоритм сортировки может быть любым.

+ должен быть публичный статичный свободный метод sortDoubles, который принимает в качестве параметров массив
элементов класса-обертки Double.
+Метод должен выполнять сортировку массива по возрастанию. Алгоритм сортировки может быть любым.
+Все элементы null должны перемещаться в конец массива.

Для обоих методов, в случае если в качестве параметра передан пустой массив или не инициализированный массив,
на экран должно выводиться сообщение: “Empty data” */

import java.util.Arrays;

class SortingUtil {

    // метод сортировки массива int[]
    public static void sortInts(int[] array_int) {
        if (array_int == null) {    // если передан массив null
            System.out.println("Empty data");
            return;
        }
        if (array_int.length == 0) {    // если массив пуст
            System.out.println("Empty data");
            return;
        }
        // в остальных случаях сортируем
        Arrays.sort(array_int);
        // для добства реализовал вывод в методе
        System.out.println(Arrays.toString(array_int));
    }

    // метод сортировки массива Double[]
    public static void sortDoubles(Double[] array_D) {
        if (array_D == null) {    // если передан массив null
            System.out.println("Empty data");
            return;
        }
        if (array_D.length == 0) {  // если массив пуст
            System.out.println("Empty data");
            return;
        }
        // использовал приемчик из недавнего урока Refactor Extr.method
        sortDoubles_sort(array_D);
        // для добства реализовал вывод в методе
        System.out.println(Arrays.toString(array_D));
    }

    // в остальных случаях сортируем методом слияния:
    private static void sortDoubles_sort(Double[] array_D_s) {
        // делим на 2 массива:
        Double[] leftArray = new Double[array_D_s.length / 2];
        Double[] rightArray = new Double[array_D_s.length - leftArray.length];
        for (int i = 0; i < array_D_s.length; i++) {
            if (i < leftArray.length) {
                leftArray[i] = array_D_s[i];
            } else {
                rightArray[i - leftArray.length] = array_D_s[i];
            }
        }
        if (rightArray.length > 1) { // если длина массива больше 1, то рекурсируем
            sortDoubles_sort(leftArray);
            sortDoubles_sort(rightArray);
        }
        int leftId = 0;
        int rightId = 0;
        for (int i = 0; i < array_D_s.length; i++) {
            if (leftId == leftArray.length && rightId < rightArray.length) {
                array_D_s[i] = rightArray[rightId];
                rightId++;
            } else if (rightId == rightArray.length && leftId < leftArray.length) {
                array_D_s[i] = leftArray[leftId];
                leftId++;
            } else if (leftArray[leftId] == null) {     // если в левом массиве элемент = null
                array_D_s[i] = rightArray[rightId];
                rightId++;
            } else if (rightArray[rightId] == null) {    // если в правом массиве элемент = null
                array_D_s[i] = leftArray[leftId];
                leftId++;
            } else if (leftArray[leftId] < rightArray[rightId]) {  //
                array_D_s[i] = leftArray[leftId];
                leftId++;
            } else {
                array_D_s[i] = rightArray[rightId];
                rightId++;
            }
        }
    }


    public static void main(String[] args) {
        int[] array_int = {2, 5, 1, 7, 3, 4, 6};
        sortInts(array_int);

        int[] array_int2 = {};
        sortInts(array_int2);   // Empty data

        // проверка на массив null
        sortInts(null);    // Empty data

        Double[] array_double1 = {null, null, null, 2.0, null, null, 5.0, null, null, 1.0, null, 7.0, null, null, 3.0, 4.0, null, null, 6.0, null, null,};
        sortDoubles(array_double1);

        Double[] array_double2 = {};
        sortDoubles(array_double2);     // Empty data

        // проверка на массив null
        sortDoubles(null);      // Empty data
    }
}
