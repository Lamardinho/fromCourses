package Kursi.P13_Packeges;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        double[] first_arr = {12.2, 34.2, 36.32, 11.0, 43.3, 12.9};
        double[] second_arr = {12.2, 34.2, 36.32, 11.0, 43.3, 12.9};

        Array.setDouble(first_arr, 4, 12.33);
        Array.setDouble(first_arr, 5, 8.09);

        Array.setDouble(second_arr, 5, 12.33);
        Array.setDouble(second_arr, 4, 8.09);

        System.out.println(Arrays.equals(first_arr, second_arr));
        System.out.println(Arrays.compare(first_arr, second_arr));
    }
}
