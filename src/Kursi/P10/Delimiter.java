package Kursi.P10;

import java.util.Scanner;

public class Delimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("/"); /*разделитель*/
        /*Цикл While*/
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}

