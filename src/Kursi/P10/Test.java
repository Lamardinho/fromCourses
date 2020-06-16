package Kursi.P10;

class Test {
    public static void main(String[] args) {
        double P1_1 = 34.393429;
        double roundOffP1_1 = Math.round(P1_1 * 100.0) / 100.0;

        System.out.println(roundOffP1_1);
        //or
        System.out.println(String.format("P1_1: %.2f USD", P1_1));
    }
}
