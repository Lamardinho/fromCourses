package Kursi.P9.T1;

/*
2. В целях повышения производительности приложения, потребляющего большое количество памяти, необходимо реализовать
публичный класс TypeSelector. В классе TypeSelector реализовать метод selectClass, удовлетворяющий следующему набору требований:
a. метод должен быть публичным;
b. метод должен быть статическим;
c. метод должен принимать в качестве аргумента экземпляр класса Long;
d. метод должен возвращать экземпляр класса Class, к которому нужно привести аргумент, чтобы снизить объем памяти
для ее хранения, сохранив исходное значение;
e. если в качестве параметра было передано значение null, метод должен возвращать экземпляр класса Class для класса
Object (Object.class).

Примечание: для получения экземпляра класса Class используйте конструкцию <Имя класса>.class, например: Object.class; Integer.class; и т. д.
 short 16 бит от -32768 до 32767 */

public class TypeSelector {
    // метод который оптимизирует наши значения на подходящие:
    public static Class selectClass(Long long_1) {
        if (long_1 == null) {   // если null, то возвращаем Object.class
            System.out.println("возвращаем Object.class");
            return Object.class;
        } else if (long_1 >= (-128) & long_1 <= 127) {  // если аргумент в диапазоне -128 to 127
            System.out.println("Byte: " + long_1.byteValue());
            return Byte.class;       // то возвращаем Byte.class
        } else if (long_1 >= (-32768) & long_1 <= 32767) { // если аргумент в диапазоне -32768 to 32767
            System.out.println("Short: " + long_1.shortValue());
            return Short.class;      // то возвращаем Short.class
        } else if (long_1 >= (-2147483648) & long_1 <= 2147483647) { // если аргумент в диапазоне -2147483648 to 2147483647
            System.out.println("Integer: " + long_1.intValue());
            return Integer.class;    // то возвращаем Integer.class
        } else {        // иначе возвращаем Long
            System.out.println("Long: " + long_1);
            return Long.class;
        }
    }

    public static void main(String[] args) {
        // далее идут наши проверки
        Long l1 = 127L;
        selectClass(l1);

        Long l2 = 32767L;
        selectClass(l2);

        Long l3 = 2147483627L;
        selectClass(l3);

        Long l4 = -9223372036754775808L;
        selectClass(l4);
    }
}