package Kursi.P9.T3_ArrayList;

import java.util.ArrayList;

public class ClientClassifier {
    // метод для заполнения массива results и сразу же его отображение
    public static void getClientsByType(ArrayList<Client> clients, String type, ArrayList<Client> results) {
        if (clients == null) System.out.println("Clients array is null or empty");
        else if (clients.size() == 0) System.out.println("Clients array is null or empty");
        else if (results == null) System.out.println("Result array is null or empty");
        else if (type == null) type = "institution";
        else for (Client client : clients) {
                if (client.type.equals(type)) results.add(new Client(client.id, client.type, client.name, client.sum));
            }
    }

    //метод для вывода клиентов
    public static void printClients(ArrayList<Client> clients) {
        if (clients == null) return;
        else if (clients.size() == 0) return;
        for (Client cli : clients) {
            if (cli == null) return;
            System.out.println("{" + cli.id + "};" + "{" + cli.name + "};" + "{" + cli.type + "};" + "{" + cli.sum + "}");
        }
    }

    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client(100000000001L, "institution", "1st", 50000));     // institution
        clients.add(new Client(100000000002L, null, "2st", 30000));              // institution
        clients.add(new Client(90000000000L, "individual", "3st", 43000));
        clients.add(new Client(100000000004L, "??? = institution", null, -1));   // institution
        clients.add(new Client(100000000005L, "", "5st", 36000));                // institution
        clients.add(new Client(100000000000L, "individual", "", 21000));

        ArrayList<Client> results = new ArrayList<>();

        getClientsByType(clients, "institution", results);

        System.out.println("\nshowing all clients:");
        printClients(clients);

        System.out.println("\nshowing all results:");
        printClients(results);
    }
}
