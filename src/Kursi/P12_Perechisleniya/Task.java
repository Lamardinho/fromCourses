package Kursi.P12_Perechisleniya;

/*Существует несколько самолетов, обладающих следующими характеристиками:
1.	Boeing 001 – пролетает расстояние, равное 8000 км, за 10 часов;
2.	Ил 90 – пролетает расстояние, равное 5400 км, за 9 часов;
3.	Ту-153 – пролетает расстояние, равное 14000 км, за 15 часов.
Требуется:
+ 1.	В Task создать перечисление Planes, в котором указать названия самолетов (BOEING, IL90, TU153) и реализовать следующие требования:
+ a.	создать поля, отвечающие за пройденное расстояние и время пути (целочисленные поля distance и time);
+ b.	создать публичный метод speed, не принимающий на вход ничего и возвращающий целочисленное значение скорости самолета (distance/time);
+ c.	создать конструктор, в котором будут инициализироваться сначала расстояние, пройденное самолетом, а затем его время в пути.
+ 2.	В этом же классе создать метод int maxSpeed(), в котором сравнить скорости всех самолетов и вернуть наибольшую из них.
 */

import java.util.Arrays;

class Task {
    public enum Transport {
        BOEING(8000, 10), IL90(5400, 9), TU153(14000, 15);
        final int distance;
        final int time;

        Transport(int distance, int time) {
            this.distance = distance;
            this.time = time;
        }

        int speed() {
            return distance / time;
        }
    }

    public int maxSpeed() {
        int[] speed_arr = {Transport.BOEING.speed(), Transport.IL90.speed(), Transport.TU153.speed()};
        Arrays.sort(speed_arr);
        System.out.println(speed_arr[speed_arr.length - 1]);
        return speed_arr[speed_arr.length - 1];
    }

    public static void main(String[] args) {
        Task ob = new Task();
        ob.maxSpeed();
    }
}
