package Kursi.P9.T3_NoArr;

import java.util.Objects;

class Client {
    long id;    // идентификационный номер клиента
    String type;    // тип клиента;
    final String institution = "institution";
    final String individual = "individual";
    String name;    // название клиента;
    double sum;    // сумма покупок клиента.

    //конструктор класса Client
    public Client(long id, String type, String name, double sum) {
        // если id меньше 100000000000L, то приравниваем к 100000000000L
        // иначе id = указанному значению
        this.id = Math.max(id, 100000000000L);

        if (type == null) this.type = institution;    // если type = null, то пишем "Default"
        else if (!type.equals(individual)) this.type = institution;
        else this.type = type;

        this.name = Objects.requireNonNullElse(name, "Default");
        if (this.name.equals("")) this.name = "Default";

        if (sum < 0) this.sum = 0;    // если sum меньше 0, то приравниваем к 0
        else this.sum = sum;
    }
}