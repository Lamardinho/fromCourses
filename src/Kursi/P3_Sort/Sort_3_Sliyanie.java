package Kursi.P3_Sort;

/*метод sortSales работает крайне медленно, если объем данных о продажах превышает 1000 элементов.
метод sortSales недостаточно производителен.
Необходимо в приложение добавить метод: static void sortStoresSales(), который сортирует данные о продажах.
В метод sortSales должны передаваться 2 массива данных:
Массив идентификаторов магазинов (строки);
Массив данных о продажах (действительные числа).
Данные, которые будут передаваться в метод, по умолчанию синхронизированы
(0-й элемент массива данных о продажах соответствует 0-му элементу массива магазинов, 1-й - 1-му и т.д.).

Необходимо реализовать следующую логику работы метода:
+ Если размеры массивов не соответствуют друг другу, необходимо вывести сообщение "Corrupted Data" и не выполнять сортировки;
+ Если в метод были переданы пустые массивы, необходимо вывести на консоль сообщение "Empty Data" и не выполнять сортировки;
Во всех остальных случаях необходимо выполнить сортировку обоих массивов с учетом следующих требований:
необходимо использовать * * * алгоритм сортировки слиянием * * * ;
необходимо, чтобы алгоритм выполнялся полностью не дольше 1,2 секунд;
сортировку необходимо провести синхронно, т. е. если осуществляется перестановка значений в массиве данных о продажах,
должна осуществляться аналогичная (по индексам) перестановка в массиве идентификаторов магазинов;
после завершения сортировки каждого из массивов на каждом из этапов слияния на экран должен выводиться результат сортировки
на этом этапе; для вывода на экран используйте метод printData (см. ниже). */

class Sort_3_Sliyanie {
    private static void printData(String[] names, double[] data) {
        System.out.print("{");
        for (int i = 0; i < names.length; i++) System.out.print(names[i] + ": " + data[i] + ", ");
        System.out.println("\b\b}");
    }

    static void sortStoresSales(String[] countries, double[] money) {
        // если какой-нибудь массив = 0
        if (countries.length == 0 | money.length == 0) System.out.println("Empty Data");
        else {// если массивы не равны
            if (countries.length != money.length) System.out.println("Corrupted Data");
            else { // в остальных случаях сортируем алгоритмом слияния
                // для деления массива money
                double[] leftArray = new double[money.length / 2];
                double[] rightArray = new double[money.length - leftArray.length];
                // для деления массива countries
                String[] leftArray_C = new String[countries.length / 2];
                String[] rightArray_C = new String[countries.length - leftArray.length];

                for (int i = 0; i < money.length; i++) {
                    if (i < leftArray.length) {
                        leftArray[i] = money[i];
                        leftArray_C[i] = countries[i];
                    } else {
                        rightArray[i - leftArray.length] = money[i];
                        rightArray_C[i - leftArray_C.length] = countries[i];
                    }
                }

                if (rightArray.length > 1) { // если длина массива больше 1, то рекурсируем
                    sortStoresSales(leftArray_C, leftArray);
                    sortStoresSales(rightArray_C, rightArray);
                }

                int leftId = 0;
                int rightId = 0;
                for (int i = 0; i < money.length; i++) {
                    if (leftId == leftArray.length && rightId < rightArray.length) {
                        money[i] = rightArray[rightId];
                        countries[i] = rightArray_C[rightId];
                        rightId++;
                    } else if (rightId == rightArray.length && leftId < leftArray.length) {
                        money[i] = leftArray[leftId];
                        countries[i] = leftArray_C[leftId];
                        leftId++;
                    } else {
                        if (leftArray[leftId] < rightArray[rightId]) {
                            money[i] = leftArray[leftId];
                            countries[i] = leftArray_C[leftId];
                            leftId++;
                        } else {
                            money[i] = rightArray[rightId];
                            countries[i] = rightArray_C[rightId];
                            rightId++;
                        }
                    }
                }
                // выводим данные в консоль на каждом из этапов слияния
                printData(countries, money);
            }
        }
    }

    public static void main(String[] args) {
        String[] countries = {"F6", "D4", "B2", "C3", "E5", "A1", "G7"}; //
        double[] money = {6, 4, 2, 3, 5, 1, 7};
        sortStoresSales(countries, money);
        //printData(countries, money);
    }
}