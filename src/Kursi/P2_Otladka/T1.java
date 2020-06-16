package Kursi.P2_Otladka;

// Приведи исправленную строку, которая устраняет логическую ошибку, не нарушая требования к работе метода:
// в задании было так: после цикла сразу шел
// average = sum / data.length; System.out.println(max / average); else System.out.println("Data Error");

// решение if (average == 0) System.out.println("Data Error"); else System.out.println(max / average);

public class T1 {
    public static void maxAboveAverage(int[] data) {
        if (data.length > 0) {
            double max, sum = max = 0, average;
            for (int i = 0; i < data.length; i++) {
                if (data[i] >= max) max = data[i];
                sum += data[i];
            }
            System.out.println("sum = " + sum);
            System.out.println("max = " + max);
            average = sum / data.length;
            System.out.println("average = " + average);
            if (average == 0) System.out.println("Data Error");
            else System.out.println(max / average);
        } else System.out.println("Data Error");
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, -15, 2, 3, 4, 5};
        maxAboveAverage(arr);
    }
}
