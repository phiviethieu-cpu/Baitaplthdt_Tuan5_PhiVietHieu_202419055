import java.util.*;

public class Main {
    public static void main(String[] args) {
        Computer mt1 = new Computer("PC01", "Dell OptiPlex 7090", 2023, 15000000, 16, "Intel Core i5", false);
        Computer mt2 = new Computer("PC02", "HP Z2 Workstation", 2019, 30000000, 32, "Intel Core i7", true);
        Printer in1 = new Printer("PR01", "Canon LBP2900", 2022, 8000000, PrinterType.LASER, 30000, false);
        NetworkPrinter in2 = new NetworkPrinter("PR02", "HP Color LaserJet", 2020, 12000000, PrinterType.LASER, 150000, true);
        Projector mc = new Projector("PJ01", "Epson EB-X51", 2021, 20000000, 3800, 3500);
        in1.setStatus(DeviceStatus.UNDER_MAINTENANCE);

        LabRoom p1 = new LabRoom("P301", "Phong thuc hanh 1", 40);
        LabRoom p2 = new LabRoom("P302", "Phong thuc hanh 2", 30);
        p1.addDevice(mt1);
        p1.addDevice(mt2);
        p1.addDevice(in2);
        p2.addDevice(in1);
        p2.addDevice(mc);

        // trung ma PC01
        try {
            p1.addDevice(new Computer("PC01", "Asus", 2024, 14000000, 8, "Ryzen 5", false));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        p1.printDevices();
        p2.printDevices();

        System.out.println("Chi phi bao tri P301: " + p1.calculateAnnualMaintenanceCost());
        System.out.println("Chi phi bao tri P302: " + p2.calculateAnnualMaintenanceCost());

        System.out.println("Can bao tri:");
        for (Device tb : p1.getDevicesRequiringMaintenance()) System.out.println(tb.getId() + " " + tb.getName());
        for (Device tb : p2.getDevicesRequiringMaintenance()) System.out.println(tb.getId() + " " + tb.getName());

        List<INetworkable> dsMang = new ArrayList<>();
        for (Device tb : p1.getDevices()) if (tb instanceof INetworkable) dsMang.add((INetworkable) tb);
        for (Device tb : p2.getDevices()) if (tb instanceof INetworkable) dsMang.add((INetworkable) tb);

        int ip = 10;
        for (INetworkable n : dsMang) {
            n.connect("192.168.1." + ip++);
        }
        for (INetworkable n : dsMang) {
            System.out.println(n.getIpAddress() + " " + n.isConnected());
        }
        dsMang.get(0).disconnect();
        System.out.println("sau khi ngat: " + dsMang.get(0).getIpAddress() + " " + dsMang.get(0).isConnected());
    }
}
