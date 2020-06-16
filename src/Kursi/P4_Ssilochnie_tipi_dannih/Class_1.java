package Kursi.P4_Ssilochnie_tipi_dannih;

//Перепиши метод compareStrings, чтобы он выводил на экран результат сравнения строк по значениям.

class Class_1 {
    static void compareStrings() {
        final String HELLO = "Hello";
        String hello1 = HELLO;
        String hello2 = "Hello";
        String hello3 = "Hell" + "o";
        String hello4 = "Hell";
        hello4 += "o";

        System.out.println(hello1.equals(HELLO));
        System.out.println(hello2.equals(HELLO));
        System.out.println(hello3.equals(HELLO));
        System.out.println(hello4.equals(HELLO));
    }

    public static void main(String[] args) {
        compareStrings();
    }
}
