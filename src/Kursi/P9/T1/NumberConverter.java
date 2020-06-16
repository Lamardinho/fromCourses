package Kursi.P9.T1;

/*<val> in BIN: <binary value>
<val> in OCT: <Octal value>
<val> in HEX: <Hexadecimal value>
Например:
12 in BIN: 1100
12 in OCT: 14
12 in HEX: C */

public class NumberConverter {
    public static void printAll(int my_int) {
        System.out.println(my_int + " in BIN: " + Integer.toBinaryString(my_int));
        System.out.println(my_int + " in OCT: " + Integer.toOctalString(my_int));
        System.out.println(my_int + " in HEX: " + Integer.toHexString(my_int));
    }

    public static void main(String[] args) {
        int my_int = 12;
        printAll(my_int);
    }
}
