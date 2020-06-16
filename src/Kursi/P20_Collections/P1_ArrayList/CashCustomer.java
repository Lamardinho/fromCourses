package Kursi.P20_Collections.P1_ArrayList;

import java.util.ArrayList;

public class CashCustomer extends Customer {
    String documentNumber = "0000 000000"; //    значение по умолчанию «0000 000000»

    public String getDocumentNumber() {
        return documentNumber;
    }

    public ArrayList<CashCustomer> getCashCustomers() {
        return cashCustomers;
    }

    CashCustomer() {
    }

    public CashCustomer(String name, String documentNumber, int purchaseCount) {
        super(name, purchaseCount);
        if (name == null) {
            System.out.println("name error");
            return;
        } else if (documentNumber == null) {
            System.out.println("documentNumber error");
            return;
        }
        if (purchaseCount < 5) discountSize = 0;
        else if (purchaseCount < 10) discountSize = 5;
        else if (purchaseCount < 15) discountSize = 10;
        else discountSize = 20;

        this.documentNumber = documentNumber;
    }

    ArrayList<CashCustomer> cashCustomers = new ArrayList<>();

    public void customerInfo() {
        //System.out.println("проверка кол-ва покупок: " + purchaseCount);
        System.out.print("Customer " + name + " (passport: " + documentNumber + ") has a discount " + discountSize + " %\n");
    }
}
