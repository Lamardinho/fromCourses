package Kursi.P15_Abstract;

public class AutomaticMicrowave extends DeviceFunction implements DeviceMode {
    @Override
    void deviceOff() {
        System.out.println("Done");
    }
}
