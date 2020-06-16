package Kursi.P1_Cicles;

/* Приведи фрагмент кода, в котором происходит определение массива months,
содержащего названия месяцев года на английском языке.
После определения массива на экран должны быть выведены названия месяцев с индексами 4, 8, 11  */

class T1_Months {
    public static void main(String[] args) {
        String[] month = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println("индекс 4: " + month[4] + "\nиндекс 8: " + month[8] + "\nиндекс 11: " + month[11]);
    }
}