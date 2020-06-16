package Kursi.P16_Inner_Classes;

public class Receipt {
    public static void printReceipt(ProductInfo[] productInfo) {
        Transaction transaction = new Transaction();
        for (ProductInfo p_i : productInfo) { //заполнение чека продуктами
            Transaction.TransactionItem transactionItem = //заполнение элемента транзакции
                    transaction.new TransactionItem(p_i.name, p_i.price);
            transactionItem.printInfo(); //печать имени и цены элемента
        }
        transaction.printCheck(); //печать итоговой стоимости чека и его стоимости с учетом налога
    }

    //печать полной стоимости чека по его элементу
    public static void printTransactionInfo(Transaction.TransactionItem transactionItem) {
        transactionItem.getTransaction().printCheck();
    }
}
