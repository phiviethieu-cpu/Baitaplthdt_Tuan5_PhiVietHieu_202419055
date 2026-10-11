/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

// Thêm laMayInMau vì đề có phụ phí 300k cho máy in màu, mà loại laser hay phun thì không biết có màu hay không.
public class Printer extends Device {
    private PrinterType loaiMayIn;
    private int soTrangDaIn;
    private boolean laMayInMau;

    public Printer(String maThietBi, String tenThietBi, int namSuDung, double giaMua,
                   PrinterType loaiMayIn, int soTrangDaIn, boolean laMayInMau) {
        super(maThietBi, tenThietBi, namSuDung, giaMua);
        setType(loaiMayIn);
        setPagesPrinted(soTrangDaIn);
        this.laMayInMau = laMayInMau;
    }

    public PrinterType getType() {
        return loaiMayIn;
    }

    public void setType(PrinterType loaiMayIn) {
        this.loaiMayIn = loaiMayIn;
    }

    public int getPagesPrinted() {
        return soTrangDaIn;
    }

    public void setPagesPrinted(int soTrangDaIn) {
        if (soTrangDaIn < 0) {
            throw new IllegalArgumentException("So trang < 0");
        }
        this.soTrangDaIn = soTrangDaIn;
    }

    public boolean isColor() {
        return laMayInMau;
    }

    public boolean isNetworkSupported() {
        return this instanceof INetworkable;
    }

    @Override
    public double calculateMaintenanceCost() {
        double chiPhi = getPrice() * 0.04;
        if (soTrangDaIn > 100000) {
            chiPhi += 500000;
        }
        if (laMayInMau) {
            chiPhi += 300000;
        }
        return chiPhi;
    }

    @Override
    public String toString() {
        return "May in    " + super.toString()
                + String.format(" | Loai: %s | Da in: %,d trang | In mau: %s | Mang: %s",
                loaiMayIn, soTrangDaIn, laMayInMau ? "Co" : "Khong", isNetworkSupported() ? "Co" : "Khong");
    }
}
