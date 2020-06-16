package Kursi_Army;

import Kursi_Army.Units.Base.Cavalry;
import Kursi_Army.Units.Base.Infantry;
import Kursi_Army.Units.Base.Race;
import Kursi_Army.Units.Base.Unit;

import java.util.ArrayList;
import java.util.Objects;

public class Army<T extends Unit & Race> { // класс для хранения армий
    final private ArrayList<Cavalry> cavalry = new ArrayList<>(); // массив кавалерий
    final private ArrayList<Infantry> infantry = new ArrayList<>(); // массив пеших

    public ArrayList<Cavalry> getCavalry() {
        return new ArrayList<>(cavalry);
    } // для возврата Кавалерии войска

    public ArrayList<Infantry> getInfantry() {
        return new ArrayList<>(infantry);
    }  // для пехоты Кавалерии войска

    public ArrayList<Unit> getArmy() {  // для возврата всей армии войска
        ArrayList<Unit> units = new ArrayList<>();
        units.addAll(cavalry); // добавляем массив cavalry в units
        units.addAll(infantry); // добавляем массив infantry в units
        return units;
    }

     public boolean recruit(T unit) { // добавление юнита в массив army и в (Infantry or Cavalry)
        if (unit instanceof Infantry) {
            return infantry.add((Infantry) unit);
        }
        if (unit instanceof Cavalry) {
            return cavalry.add((Cavalry) unit);
        }
        return false;
    }

    public boolean release(T unit) { // удаление юнита из массива army и из (Infantry or Cavalry)
        if (unit instanceof Cavalry) {
            return cavalry.remove(unit);
        }
        if (unit instanceof Infantry) {
            return infantry.remove(unit);
        }
        return false;
    }

    public void print() {   // для вывода на экран нашего определенного войска
        cavalry.stream().filter(Objects::nonNull).forEach(x -> System.out.print(x.toString() + "\n"));
        infantry.stream().filter(Objects::nonNull).forEach(x -> System.out.print(x.toString() + "\n"));
    }

    public T getRandomUnit() {
        ArrayList<Unit> units = new ArrayList<>();
        units.addAll(cavalry);
        units.addAll(infantry);
        return units.isEmpty() ? null : (T) units.get((int) (Math.random() * units.size()));
    }

    public T getRandomUnit(T unit) {
        // if (unit == null) return null;
        if (unit instanceof Cavalry) {
            if (cavalry.size() > 0) return (T) cavalry.get((int) (Math.random() * cavalry.size()));
        }
        if (unit instanceof Infantry) {
            if (infantry.size() > 0) return (T) infantry.get((int) (Math.random() * infantry.size()));
        }
        return null;
    }
}