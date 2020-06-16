package Kursi.P5;

import java.util.Arrays;
import java.util.Comparator;

/* На данный момент передача данных в таблицах происходит некорректно, т. к. появляются пустые значения.
База данных содержит значения номера клиента, номера компании и количество транзакций этого клиента в этой компании.
Пример:
int [][]array={{0,0,2},{1,1,5}};
где 0 – номер клиента, 0 – номер компании, 2 – количество транзакций.
Необходимо:
+ 1. Привести исходный код публичного статичного свободного метода sort(), который принимает двумерный массив данных целых чисел.
+ 2. Сортировать массив нужно от большего к меньшему по идентификатору клиента.
+ 3. Сортировку можно осуществить любым способом.

4. Если внутри двумерного массива один или несколько массивов содержит больше или меньше трех значений, то сортировка не выполняется,
а на консоль необходимо вывести сообщение “Unavailable data at index #” (# - индекс элемента в двумерном массиве).
5. Если внутри двумерного массива один или несколько массивов содержит null, то сортировка не выполняется, а на консоль выводится
сообщение: “Empty data at index #” (# - индекс элемента в двумерном массиве).
6. Если двумерный массив равен null, то сортировка не выполняется, а на консоль выводится сообщение: “Empty data”.

Примечания:
2.	Не забудь добавить комментарии к фрагменту кода, в которых ты объясняешь суть алгоритма.
3.	Напоминаем, что нумерация в массивах начинается с 0. */

class Data {
    public static void sort(int[][] array) {
        // начинаем проверку:
        // если array = null
        if (array == null) {
            System.out.println("Empty data");
            return;
        }
        // если передали пустой массив array тоже печатаем Empty data
        if (array.length == 0) {
            System.out.println("Empty data");
            return;
        }
        // else {
        for (int i = 0, index = 0; i < array.length; i++, index++) {
            // Если внутри двумерного массива есть массивы с null:
            if (array[i] == null) {
                System.out.println("Empty data at index " + index);
                return;
            }
            // если во внутренних масивах есть менее или более 3х элементов:
            if (array[i].length != 3) {
                System.out.println("Unavailable data at index " + index);
                return;
            }
        }
        // сортируем массив по индексу[0]:
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] sort1, int[] sort2) {
                return Integer.compare(sort2[0], sort1[0]);
            }
        });
        // вывод:
        for (int[] i : array) System.out.println(Arrays.toString(i));
    }

    public static void main(String[] args) {

        int[][] company1 = {null, {1, 1, 5}, {2, 2, 10}, {3, 4, 11}};
        sort(company1);

        int[][] company2 = {{0, 2, 4}, {1, 5, 10}, {}, {3, 4, 11}};
        sort(company2);

        int[][] company3;
        sort(null);

        int[][] company4 = {null};
        sort(company4);

        int[][] company5 = {{0, 0, 2}, {10, 5, 3}, {2, 2, 10},};
        sort(company5);

        int[][] company6 = {};
        sort(company6);
    }
}
