package Kursi.P9.T3_NoArr;

import java.util.Arrays;
import java.util.Objects;

public class ClientClassifier {
    public static void getClientsByType(Client[] clients, String type, Client[] results) {
        int s = 0;        // int i = 0;        // int incrementLength = 1;
        if (clients == null) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (type == null) {
            System.out.println("Enter type");
        }
        if (clients.length == 0) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (results == null) System.out.println("Result array is null or empty");
        for (Client client : clients) {
            if (client.type.equals(type)) {                //  results = Arrays.copyOf(clients, i + incrementLength);// increment by +1
                /* System.out.println("results.length: " + results.length);                System.out.println("s: " + s);*/
                results[s] = client;                //   i++;
                s++;
            }
        }
        System.out.println("вывод results в методе: ");
        printClients(Objects.requireNonNull(results));
    }

    public static void getClientsByType2(Client[] clients, String type, Client[] results) {
        int s = 0;
        int i = 0;
        int incrementLength = 1;
        if (clients == null) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (type == null) {
            System.out.println("Enter type");
        }
        if (clients.length == 0) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (results == null) System.out.println("Result array is null or empty");
        for (Client client : clients) {
            if (client.type.equals(type)) {
                results = Arrays.copyOf(clients, i + incrementLength);// increment by +1
                System.out.println("results.length: " + results.length + " s: " + s);
                // results[s] = client;
                results[s].equals(client);
                i++;
                s++;
            }
        }
        System.out.println("вывод results в методе: ");
        printClients(Objects.requireNonNull(results));
    }

    public static void getClientsByType3(Client[] clients, String type, Client[] results) {

       /* if (clients == null) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (type == null) {
            System.out.println("Enter type");
        }
        if (clients.length == 0) {
            System.out.println("Clients array is null or empty");
            return;
        }
        if (results == null) System.out.println("Result array is null or empty");
        // System.arraycopy(results, 0, clients, 0, results.length();*/


        results = Arrays.copyOf(clients, clients.length);

        System.out.println("проверка getClientsByType3");
        System.out.println(clients.length);

        printClients(results);
    }


    //метод для вывода клиентов
    public static void printClients(Client[] arr) {
        //  System.out.println("123");
        if (arr == null) return;
        if (arr.length == 0) return;
        // System.out.println("arr.length = " + arr.length);
        for (Client cli : arr) {
            if (cli == null) return;
            System.out.println("{" + cli.id + "};" + "{" + cli.name + "};" + "{" + cli.type + "};" + "{" + cli.sum + "}");
        }
    }

    public static void main(String[] args) {
        String institution = "institution";
        String individual = "individual";
        Client[] Arr_clients = {
                new Client(100000000001L, "institution", "1st", 50000), // institution 1
                new Client(100000000002L, null, "2st", 30000),  // institution 2
                new Client(90000000000L, "individual", "3st", 43000),
                new Client(100000000004L, "??? = institution", null, -1),   // institution 4
                new Client(100000000005L, "", "5st", 36000),    // institution 5
                new Client(100000000006L, "individual", "", 21000)};

        Client[] Arr_results2 = new Client[Arr_clients.length];
        Client[] Arr_results = {null};

        /*getClientsByType(Arr_clients, "institution", Arr_results2);

        System.out.println("\nвывод всех килентов: ");
        System.out.println("Arr_clients");
        printClients(Arr_clients);
        System.out.println("\nArr_results2");
        printClients(Arr_results2);

        System.out.println("--------------------");
        getClientsByType2(Arr_clients, "institution", Arr_results);
        System.out.println("\nArr_results");
        printClients(Arr_results);*/

        getClientsByType3(Arr_clients, individual, Arr_results);
        System.out.println("\nArr_results");
        printClients(Arr_results);
    }
}
