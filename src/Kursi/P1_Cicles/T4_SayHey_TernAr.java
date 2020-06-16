package Kursi.P1_Cicles;

/*Приложение можно запускать с параметром "-u" или без параметров. Необходимо реализовать логику приложения по следующим бизнес-правилам.
Если приложение вызвано с параметром "-u", оно должно выдавать приветствие в формате
"Hello, < user_name >!"
Во всех остальных случаях приложение должно выдавать приветствие в формате
"Hello!".
Приведи фрагмент кода, который определяет публичный статичный метод sayHello в соответствии с приведенным описанием задачи.
Используй тернарную условную операцию для реализации заявленной логики.*/

public class T4_SayHey_TernAr {
    public static void sayHello(String[] args) {    // создаем метод для получения аргументов и вывода информации:
        String user = System.getProperty("user.name");    // определяет имя пользователя системы:
        // стринги для вывода
        String s_u = "Hello, " + user + "!";
        String Hello = "Hello!";
        String print;

        // если 1 аргумент
        if (args.length == 1) {
            // если аргумент = '-u', то print = переменной s_u, иначе print = Hello
            print = (args[0].equals("-u")) ? s_u : Hello;
            System.out.println(print);  // выводим наш print
        } else System.out.println(Hello);   // если с аргументом что то не так, выводим переменную Hello
    }

    public static void main(String[] args) {
        sayHello(args);
    }
}
