package Kursi_Army;

import Kursi_Army.Units.Base.MiddleEarthUnit;
import Kursi_Army.Units.Base.MordorUnit;
import Kursi_Army.Units.Earth.Human;
import Kursi_Army.Units.Mordor.Orc;

public class Main {    // тестируем:
    public static void main(String[] args) {
        Army<MordorUnit> mordorUnits = new Army<>();
        Army<MiddleEarthUnit> middleEarthUnits = new Army<>();

        Orc orc1 = new Orc();
        mordorUnits.recruit(orc1);
        Orc orc2 = new Orc();
        mordorUnits.recruit(orc2);
        Orc orc3 = new Orc();
        mordorUnits.recruit(orc3);
        Orc orc4 = new Orc();
        mordorUnits.recruit(orc4);

        Human human1 = new Human();
        middleEarthUnits.recruit(human1);
        Human human2 = new Human();
        middleEarthUnits.recruit(human2);
        Human human3 = new Human();
        middleEarthUnits.recruit(human3);

        System.out.println("\nПроверка армии MordorUnit:\n" +
                "\nmordorUnits getArmy:\n" + mordorUnits.getArmy() +
                "\nmordorUnits getInfantry:\n" + mordorUnits.getInfantry() +
                "\nmordorUnits getCavalry:\n" + mordorUnits.getCavalry() +
                "\nrandom mordorUnits unit:\n" + mordorUnits.getRandomUnit());

        System.out.println("\nПроверка армии middleEarth\n" +
                "\nmiddleEarth getArmy:\n" + middleEarthUnits.getArmy() +
                "\nmiddleEarth getInfantry:\n" + middleEarthUnits.getInfantry() +
                "\nmiddleEarth getCavalry:\n" + middleEarthUnits.getCavalry() +
                "\nrandom middleEarth unit:\n" + middleEarthUnits.getRandomUnit()
        );
        System.out.println("------------------------");
        System.out.println("проверка на getRandomUnit(unit) orc1: " + mordorUnits.getRandomUnit(orc1));
        System.out.println("проверка на getRandomUnit(unit) human1: " + middleEarthUnits.getRandomUnit(human1));

        System.out.println("Проверки на релизы");
        System.out.println("удаляем юнита mordorUnits...");
        mordorUnits.release(orc3);
        System.out.println("mordorUnits Army после удаления юнита:");
        mordorUnits.print();
        System.out.println("удаляем юнита middleEarthUnits...");
        middleEarthUnits.release(human3);
        System.out.println("middleEarth Army после удаления юнита:");
        middleEarthUnits.print();
    }
}
