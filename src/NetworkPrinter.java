// Chỉ một số máy in có mạng nên em tách riêng lớp này, máy in thường vẫn dùng Printer.
public class NetworkPrinter extends Printer implements INetworkable {
    private final NetworkConnection ketNoi = new NetworkConnection();

    public NetworkPrinter(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                          PrinterType loaiMayIn, int soTrangDaIn, boolean laMayInMau) {
        super(maThietBi, tenThietBi, namSuDung, giaMua, loaiMayIn, soTrangDaIn, laMayInMau);
    }

    @Override
    public String getIpAddress() {
        return ketNoi.getIpAddress();
    }

    @Override
    public void connect(String diaChiIp) {
        ketNoi.connect(diaChiIp, "May in " + getId());
    }

    @Override
    public void disconnect() {
        ketNoi.disconnect();
    }

    @Override
    public boolean isConnected() {
        return ketNoi.isConnected();
    }
}
