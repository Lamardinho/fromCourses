package Kursi.P7;
// Чему будет равно значение переменной a в результате выполнения следующего блока кода?

// ответ = 187;

class С1 {
    private static void letsChangeAB(int a, int b) {
        a = b;
    }

    private static int letsChangeABC(int a, int b, int c) {
        c = a * b - c;
        System.out.println(c);
        return c;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 15;
        int c = -7;

        a = letsChangeABC(a, b, c); // с = 187 , а = с получается = 187
        letsChangeAB(a, b);
        System.out.println(a);
    }
}
