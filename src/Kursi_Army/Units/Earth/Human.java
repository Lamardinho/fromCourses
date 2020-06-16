package Kursi_Army.Units.Earth;

import Kursi_Army.Units.Base.Infantry;
import Kursi_Army.Units.Base.MiddleEarthUnit;

import java.util.Random;

public class Human implements MiddleEarthUnit, Infantry { // люди
    int powerMin = 7;
    int powerMax = 8;
    int totalPower;

    public Human() { // вычисление рандомом для итоговой силы:
        getTotalPower();
    }

    private void getTotalPower() {
        int diff = powerMax - powerMin;
        Random random = new Random();
        int totalPow = random.nextInt(diff + 1);
        totalPow += powerMin;
        this.totalPower = totalPow;
// вывод реализован чисто для тестов, на этапе создания программы
        System.out.println("Human power: " + this.powerMin + "-" + this.powerMax + ", totalPower: " + this.totalPower);
    }
}
