package Kursi.P15_Abstract;

public class ManualMicrowave extends DeviceFunction implements DeviceMode {
    @Override
    void deviceOff() {
        System.out.println("Waiting for new task");
    }
}
