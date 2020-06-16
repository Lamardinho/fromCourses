package Kursi.P16_Inner_Classes;

public class Transaction {
    private double price;   // цена
    private double tax;

    private double getPrice() { // геттер
        return price;
    }

    private double dealPrice() { //(цена сделки с учетом налога);
        return price * tax;
    }

    Transaction() {  //конструктор по умолчанию;
        this.price = 0;
        this.tax = 1.2;
    }

    void printCheck(double price) {     // для вывода цены
        this.price = price;
        System.out.println(String.format("price: %.2f USD", price));
    }

    public void printCheck() {
        System.out.print("Order ");
        printCheck(price);
        System.out.printf("Total price: %.2f USD", dealPrice());
    }

    public class TransactionItem extends ProductInfo {  // TransactionItem
        private final String name;    // название товара
        private final double price;   // цена единицы товара

        public Transaction getTransaction() {
            return Transaction.this;
        }   // для доступа к внешнему классу

        public TransactionItem(String name, double price) {//конструктор, присваивающий значения
            if (name == null || name.isBlank()) this.name = "Default";
            else this.name = name;
            if (price < 0) this.price = 0;
            else this.price = price;
            getTransaction().price += price;
        }

        public void printInfo() {       // вывод printf
            System.out.printf("\nItem: %s, ", name);
            getTransaction().printCheck(price);
        }
    } // end TransactionItem

    public static void main(String[] args) { // для тестов
        Transaction ob = new Transaction();
        System.out.println("присваиваем price");
        ob.printCheck(300);

        System.out.println("\nпечатаем чек:");
        ob.printCheck();

        Transaction.TransactionItem transactionItem = ob.new TransactionItem("transaction #1", 200);
        transactionItem.printInfo();
    }
}
