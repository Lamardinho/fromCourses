package Kursi.P20_Collections.P1_ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

class Shop extends Customer {
    private String shoppers_name; // имя
    private String shoppers_into; // документ инфо
    private int shoppers_discountSize; // скидка

    public Shop() {
    }   // конструктор пустой

    public Shop(String name, String cardNumber, int purchaseCount) {    // основной конструктор
        shoppers_name = name;
        shoppers_into = cardNumber;
        // ниже идут наши условия для скидки
        if (purchaseCount < 5) shoppers_discountSize = 0;
        else if (purchaseCount < 10) shoppers_discountSize = 5;
        else if (purchaseCount < 15) shoppers_discountSize = 10;
        else shoppers_discountSize = 20;
    }

    public void customerInfo() {
        //System.out.println("проверка кол-ва покупок: " + purchaseCount);
        System.out.print("Customer " + shoppers_name + " (document: " + shoppers_into + ") has a discount " +
                shoppers_discountSize + " %\n");
    }

    static CashCustomer ob_cash = new CashCustomer(); // ссылка на CashCustomer
    static CardCustomer ob_card = new CardCustomer(); // сылка на CardCustomer

    static private final ArrayList<Shop> shoppers = new ArrayList<>(); // создаем массив для возврата всех покупателей

    public static CashCustomer getOb_cash() { // ссылка на CashCustomer, правда я вместо неё использовал объекты выше созданные
        return ob_cash;
    }

    public static CardCustomer getOb_card() { // сылка на CardCustomer
        return ob_card;
    }

    //«< type >,< name >,< purchaseCount >,< documentNumber >,< cardNumber >»,
    public static ArrayList<Shop> createShopInfo() { // криейт шоппер
        int exit = 0;
        while (exit == 0) { // пока exit на нуле, продолжаем выполнять наш цикл
            System.out.println("Shop data format: Type,name,purchaseCount,documentNumber,cardNumber" +
                    "\nenter 'exit' for exit");
            Scanner scanner = new Scanner(System.in).useDelimiter("\\s*[,\\n]\\s*"); // используем делимитр
            String cashName = ob_cash.name;
            String cardName = ob_card.name;
            int cash_purchaseCount = 0;
            String documentNumber = ob_cash.documentNumber;
            String cardNumber = ob_card.cardNumber;
            //«< type >,< name >,< purchaseCount >,< documentNumber >,< cardNumber >»,
            if (scanner.hasNextInt()) { // type
                int type = scanner.nextInt();
                if (type == 2) {  // card для cardкостумеров
                    System.out.println("type: " + type + " - CardCustomer");
                    if (scanner.hasNextLine()) { // name
                        cardName = scanner.next();
                        if (cardName.equals("")) cardName = "No-name";
                        System.out.println("name: " + cardName);
                    } else {
                        System.out.println("name: " + cardName);
                        createShopInfo();
                        scanner.next();
                    }
                    if (scanner.hasNextInt()) { // purchaseCount
                        cash_purchaseCount = scanner.nextInt();
                        System.out.println("purchaseCount: " + cash_purchaseCount);
                    } else {
                        System.out.println("purchaseCount: " + cash_purchaseCount);
                        // createShopInfo();
                        scanner.next();
                    }
                    if (scanner.hasNextLine()) { // cardNumber
                        cardNumber = scanner.next();
                        if (cardNumber.equals("")) cardNumber = ob_card.cardNumber;
                        System.out.println("cardNumber: " + cardNumber);
                    } else {
                        System.out.println("cardNumber: " + cardNumber);
                        createShopInfo();
                        scanner.next();
                    }
                    if (scanner.hasNextLine()) { // cardNumber
                        cardNumber = scanner.next();
                        if (cardNumber.equals("")) cardNumber = ob_card.cardNumber;
                        System.out.println("cardNumber: " + cardNumber);
                    } else {
                        System.out.println("cardNumber: " + cardNumber);
                        createShopInfo();
                        scanner.next();
                    }
                    System.out.println();
                    ArrayList<String> str = new ArrayList<>();
                    ob_card.cardCustomers.add(new CardCustomer(cardName, cardNumber, cash_purchaseCount));
                    shoppers.add(new Shop(cardName, cardNumber, cash_purchaseCount));
                    // --------------------------------------------------------------------------
                } else if (type == 1) {  // card для cashкостумеров
                    System.out.println("type: " + type + " - CashCustomer");
                    if (scanner.hasNextLine()) { // name
                        cashName = scanner.next();
                        if (cashName.equals("")) cashName = "No-name";
                        System.out.println("name: " + cashName);
                    } else {
                        System.out.println("name: " + cashName);
                        createShopInfo();
                        scanner.next();
                    }
                    if (scanner.hasNextInt()) { // purchaseCount
                        cash_purchaseCount = scanner.nextInt();
                        System.out.println("purchaseCount: " + cash_purchaseCount);
                    } else {
                        System.out.println("purchaseCount: " + cash_purchaseCount);
                        // createShopInfo();
                        scanner.next();
                    }
                    if (scanner.hasNextLine()) { // documentNumber
                        documentNumber = scanner.next();
                        if (documentNumber.equals("")) documentNumber = ob_cash.documentNumber;
                        System.out.println("documentNumber: " + documentNumber);
                    } else {
                        System.out.println("documentNumber: " + documentNumber);
                        createShopInfo();
                        scanner.next();
                    }
                    System.out.println();
                    ob_cash.cashCustomers.add(new CashCustomer(cashName, documentNumber, cash_purchaseCount));
                    shoppers.add(new Shop(cashName, documentNumber, cash_purchaseCount));
                } else System.out.println("Type must be 1 or 2. Try again.");
            } else if (scanner.nextLine().equals("exit")) exit = 1;
            else System.out.println("Type must be 1 or 2. Try again.");
        }
        return shoppers;
    }

    public static void printShopSummary() {     // вывод инфы о покупателях
        if (ob_card.cardCustomers.size() > 0) {
            System.out.println("\nCard customers:");
            for (int i = 0; i < ob_card.cardCustomers.size(); i++) ob_card.cardCustomers.get(i).customerInfo();
        }
        if (ob_cash.cashCustomers.size() > 0) {
            System.out.println("\nCash customers:");
            for (int i = 0; i < ob_cash.cashCustomers.size(); i++) ob_cash.cashCustomers.get(i).customerInfo();
        }
        if (shoppers.size() > 0) {   // проверка на вывод всех сразу и заполнение массива shopers
            System.out.println("\nshopers:");
            for (Shop shoper : shoppers) shoper.customerInfo();
        }
    }

    public static void main(String[] args) { // тестируем
        Shop sh = new Shop();
        createShopInfo();
        printShopSummary();
    }
}
/* для тестировки:
1,Marcus,4,0000 000000,0000 0000 0000 0000
2,Jamal,6,1111 000000,0000 0000 0000 1111
1,Mike,10,2222 000000,0000 0000 0000 2222
2,Sofia,16,3333 000000,0000 0000 0000 3333
 */