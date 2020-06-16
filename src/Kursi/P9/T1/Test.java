package Kursi.P9.T1;

class Test {
    public static void main(String[] args) {
        short a = 128;
        short b = 128;
        if (a == b) System.out.println("true");
        else System.out.println("false");

        short c = -128;
        Short d = -128;
        if (c == d) System.out.println("true");
        else System.out.println("false");

        Short e = 128;
        Short f = 128;
        if (e.equals(f)) System.out.println("true");
        else System.out.println("false");

        Short g = -128;
        Short h = -128;
        if (g == h) System.out.println("true");
        else System.out.println("false");
    }
}
