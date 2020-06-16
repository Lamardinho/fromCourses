package Kursi_Army.tests;

import Kursi_Army.Army;
import Kursi_Army.Units.Earth.Human;
import Kursi_Army.Units.Mordor.Orc;
import Kursi_Army.Units.Base.MiddleEarthUnit;
import Kursi_Army.Units.Base.MordorUnit;

public class test_randoms_plus {
    public static void main(String[] args) {
        Army<MordorUnit> mordorUnits = new Army<>(); // плохие дяди
        Army<MiddleEarthUnit> middleEarthUnits = new Army<>(); // хорошие дяди

        Orc orc1 = new Orc(); // создаем объекты и ниже тоже
        Orc orc2 = new Orc();
        Orc orc3 = new Orc();
        Orc orc4 = new Orc();
        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();

        System.out.println();
        mordorUnits.recruit(orc1); // добавляем объекты и ниже тоже
        mordorUnits.recruit(orc2);
        mordorUnits.recruit(orc3);
        mordorUnits.recruit(orc4);
        middleEarthUnits.recruit(human1);
        middleEarthUnits.recruit(human2);
        middleEarthUnits.recruit(human3);

        System.out.println("Проверка армии MordorUnit:\n" +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" + mordorUnits.getRandomUnit() +
                "\n" +
                "\n" + middleEarthUnits.getRandomUnit() +
                "\n" + middleEarthUnits.getRandomUnit() +
                "\n" + middleEarthUnits.getRandomUnit() +
                "\n" + middleEarthUnits.getRandomUnit());
    }
}
