/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

public class Computer extends Device implements INetworkable {
    private int dungLuongRam; // GB
    private String loaiCpu;
    private boolean coGpuRoi;
    private final NetworkConnection ketNoi = new NetworkConnection();

    public Computer(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                    int dungLuongRam, String loaiCpu, boolean coGpuRoi) {
        super(maThietBi, tenThietBi, namSuDung, giaMua);
        setRam(dungLuongRam);
        setCpuType(loaiCpu);
        this.coGpuRoi = coGpuRoi;
    }

    public int getRam() {
        return dungLuongRam;
    }

    public void setRam(int dungLuongRam) {
        if (dungLuongRam <= 0) {
            throw new IllegalArgumentException("RAM phai > 0");
        }
        this.dungLuongRam = dungLuongRam;
    }

    public String getCpuType() {
        return loaiCpu;
    }

    public void setCpuType(String loaiCpu) {
        this.loaiCpu = loaiCpu;
    }

    public boolean hasDedicatedGpu() {
        return coGpuRoi;
    }

    @Override
    public double calculateMaintenanceCost() {
        double chiPhi = getPrice() * 0.05;
        if (coGpuRoi) {
            chiPhi += getPrice() * 0.02;
        }
        if (getYearsUsed() > 5) {
            chiPhi += getPrice() * 0.01;
        }
        return chiPhi;
    }

    @Override
    public String getIpAddress() {
        return ketNoi.getIpAddress();
    }

    @Override
    public void connect(String diaChiIp) {
        ketNoi.connect(diaChiIp, "May tinh " + getId());
    }

    @Override
    public void disconnect() {
        ketNoi.disconnect();
    }

    @Override
    public boolean isConnected() {
        return ketNoi.isConnected();
    }

    @Override
    public String toString() {
        return "May tinh  " + super.toString()
                + String.format(" | RAM: %dGB | CPU: %s | GPU roi: %s",
                dungLuongRam, loaiCpu, coGpuRoi ? "Co" : "Khong");
    }
}
