package Kursi.P1_Cicles;

// java T6_DrWhite.java 0.052 0.048 0.052 0.043 0.050 0.048 0.049 0.054 0.048 0.045

class T6_DrWhite {
    public static void checkWeight(String[] t) {
        double standard = 0.050 * 0.9;  // наш эталон
        String error = "Not enough substance";  // стринга для вывода ошибки
        double[] d = new double[t.length];  // массив для перевода аргументов в double
        if (t.length == 0) System.out.println(error);   // если аргументов нет, то String error
        else {
            for (int i = 0; i < t.length; i++)
                d[i] = Double.parseDouble(t[i]); // присваиваем значения аргументов в double
            double average = 0.0;   // среднее значение
            int i1 = 0;
            do {
                average += d[i1];
                i1++;
            } while (i1 < d.length);    // кол-во выполнения циклов = количеству принятых аргументов
            average = average / d.length; //// среднее значение double наших принятых аргументов
            System.out.println("average: " + average);
            System.out.println(average < standard ? error : "Ok");
        }
    }

    public static void main(String[] args) {
        checkWeight(args);
    }
}
