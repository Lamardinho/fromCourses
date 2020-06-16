package Kursi.P7;

/* Т. к. тарифы ЖКХ очень часто изменяются, в ТСЖ дома 88 по улице Красноармейской бухгалтеру Людмиле надоело постоянно
пересчитывать размер квартплаты для каждой квартиры вручную. К счастью, в этом доме жил программист Толик, который был готов
прийти на выручку ТСЖ. Он написал метод, который бы принимал на вход матрицу цен на коммунальные услуги, которая бы имела вид:
x1, x2, x3, x4, x5, x6,
где x1 – тариф на холодное водоснабжение, x2 – тариф на водоотведение, x3 – тариф на горячее водоснабжение,
x4 – тариф на отопление, x5 – тариф на электроэнергию, x6 – тариф на газоснабжение.
Данный метод на вход принимает матрицу следующего вида:
где n – общее количество квартир-должников по коммунальным услугам. Каждый столбик данной матрицы отображает показатели счетчиков
i-ой квартиры за список услуг, оговоренный ранее. Метод, который в итоге написал Толик, приведен ниже:
Однако чуть позже Толик решил, что данный метод можно немного изменить, а именно – выделить алгоритм нахождения суммы долга
для квартиры в отдельный метод. Помоги Толику сделать это:
выдели данный алгоритм в метод findDebitum() при помощи тех знаний, которые ты получил из данного урока.

Загрузи исходный код метода findDebitum().
 */
class С2 {
    public static void multiplication(int count_of_services,
                                      int count_of_debitores, double[] services, double[][] debitors, double[] result) {
        if (services.length == debitors[0].length)
            findDebitum(count_of_services, count_of_debitores, services, debitors, result);
        else System.out.println("Cannot multiply matrix data!");
    }

    private static void findDebitum(int count_of_services, int count_of_debitores, double[] services, double[][] debitors, double[] result) {
        for (int j = 0; j < count_of_debitores; j++) {
            double sum = 0;
            for (int k = 0; k < count_of_services; k++) {
                sum += services[k] * debitors[k][j];
            }
            result[j] = sum;
        }
        for (int l = 0; l < count_of_debitores; l++) System.out.println(result[l]);
    }

    public static void main(String[] args) {
        int count_of_services;
        int count_of_debitores;
        double[] services;
        double[][] debitors;
        double[] result;
    }
}
