package Kursi.P20_Collections.P1_ArrayList;

import java.util.ArrayList;

public class CardCustomer extends Customer {
    String cardNumber = "0000 0000 0000 0000";  // поле отвечающее за данные по картам покупателей

    public String getCardNumber() {
        return cardNumber;
    }

    public ArrayList<CardCustomer> getCardCustomers() {
        return cardCustomers;
    }

    public CardCustomer() {
    } // к. по умолчанию

    public CardCustomer(String name, String cardNumber, int purchaseCount) { // к. с параметрами
        super(name, purchaseCount);  // "импорт" полей с основного класса
        if (name == null) { // эти условия я добавлял при создани класса для тестировки
            System.out.println("name error");
            return;
        } else if (cardNumber == null) {
            System.out.println("documentNumber error");
            return;
        }
        if (purchaseCount < 5) discountSize = 0;
        else if (purchaseCount < 10) discountSize = 5;
        else if (purchaseCount < 15) discountSize = 10;
        else discountSize = 20;

        this.cardNumber = cardNumber;
    }

    ArrayList<CardCustomer> cardCustomers = new ArrayList<>();

    public void customerInfo() {
        System.out.print("Customer " + name + " (card: " + cardNumber + ") has a discount " + discountSize + " %\n");
    }
}
