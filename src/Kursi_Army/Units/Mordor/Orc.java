package Kursi_Army.Units.Mordor;

import Kursi_Army.Units.Base.Cavalry;
import Kursi_Army.Units.Base.MordorUnit;

import java.util.Random;

public class Orc implements MordorUnit, Cavalry {    // Орки
    int powerMin = 8;
    int powerMax = 10;
    int totalPower;

    public Orc() { // вычисление рандомом для итоговой силы:
        int diff = powerMax - powerMin;
        Random random = new Random();
        int totalPow = random.nextInt(diff + 1);
        totalPow += powerMin;
        this.totalPower = totalPow;
// вывод реализован чисто для тестов, на этапе создания программы
        System.out.println("Orc power: " + this.powerMin + "-" + this.powerMax + ", totalPower: " + this.totalPower);
    }
}
