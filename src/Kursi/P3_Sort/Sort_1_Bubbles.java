package Kursi.P3_Sort;
/*Задача, поставленная разработчику, звучит следующим образом:
Компания PineApple анализирует продажи подразделений, расположенных в разных странах, на определенную дату.
Аналитикам компании необходима возможность отсортировать подразделения по убыванию объемов продаж.
Необходимо в приложение добавить статический метод sortSales, который не возвращает значение, но сортирует данные о продажах.
+ В метод sortSales должны передаваться два массива данных:
+ Массив названий стран подразделений (строки);
+ Массив данных о продажах (действительные числа).
Данные, которые будут передаваться в метод, по умолчанию синхронизированы:
(0-й элемент массива данных о продажах соответствует 0-му элементу массива стран, 1-й – 1-му и т. д.).

Необходимо реализовать следующую логику работы метода:
+ if размеры массивов не соответствуют, необходимо вывести на консоль сообщение "Corrupted Data" и не выполнять сортировки;
+ if в метод были переданы пустые массивы, необходимо вывести на консоль сообщение "Empty Data" и не выполнять сортировки;
+ Во всех остальных случаях необходимо выполнить сортировку обоих массивов,с учетом следующих требований:
+ необходимо использовать алгоритм сортировки пузырьком;
+ сортировку необходимо провести синхронно, т. е. если осуществляется перестановка значений в массиве данных о продажах,
+ должна осуществляться аналогичная (по индексам) перестановка в массиве названий стран;
+ после каждой перестановки необходимо выводить на консоль все содержимое обоих массивов с помощью метода printData (см. примечания);
+ после завершения сортировки необходимо вывести на консоль все содержимое обоих массивов с помощью метода printData.

Приведи фрагмент кода, который определяет публичный статичный метод sortSales в соответствии с приведенным описанием задачи.
Примечание 1. Твой фрагмент кода будет проверяться автоматически, поэтому убедись, что в нем не содержатся синтаксические ошибки.
Примечание 2. Не забудь добавить комментарии к фрагменту кода, в которых ты объясняешь суть алгоритма.
Примечание 3. Для вывода содержания массивов в консоль скопируй себе и используй метод printData: */

class Sort_1_Bubbles {
    private static void printData(String[] names, double[] data) {
        System.out.print("{");
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i] + ": " + data[i] + ", ");
        }
        System.out.println("\b\b}");
    }

    public static void sortSales(String[] countries, double[] millions) {
        // если какой-нибудь массив = 0
        if (countries.length == 0 | millions.length == 0) System.out.println("Empty Data");
        else {      // если массивы не равны
            if (countries.length != millions.length) System.out.println("Corrupted Data");
            else {  // в остальных случаях
                // сортировка двух массивов синхронно, сначала прописал сорт для millions, потом сделал вставки countries
                // для реверса меняем знак '<' на '>' в if (millions[b - 1] < millions[b])
                for (int i = 1; i < millions.length; i++)
                    for (int j = 0; j < millions.length - 1; j++) {
                        if (millions[j] < millions[j + 1]) {
                            double t = millions[j];
                            String t2 = countries[j];
                            millions[j] = millions[j + 1];
                            countries[j] = countries[j + 1];
                            millions[j + 1] = t;
                            countries[j + 1] = t2;
                            printData(countries, millions);  // вывод данных при каждой перестановки
                        }
                    }
                System.out.println("\nTotal:");
                printData(countries, millions);    // выводим итоговую сотрировку
            }
        }
    }

    public static void main(String[] args) {
        String[] countries = {"France", "China", "USA", "Russia", "Japan"};
        double[] millions = {9, 15, 19, 23, 13};
        sortSales(countries, millions);
        //printData(countries, millions);
    }
}
