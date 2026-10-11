/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

import java.time.Year;

// abstract vì chưa biết tính chi phí bảo trì thế nào, để lớp con tự cài đặt
public abstract class Device {
    private final String maThietBi;
    private String tenThietBi;
    private int namSuDung;
    private double giaMua; // đồng
    private DeviceStatus trangThai;

    public Device(String maThietBi, String tenThietBi, int namSuDung, double giaMua) {
        if (maThietBi == null || maThietBi.isEmpty()) {
            throw new IllegalArgumentException("Chua nhap ma thiet bi");
        }
        this.maThietBi = maThietBi;
        setName(tenThietBi);
        setYearInUse(namSuDung);
        setPrice(giaMua);
        this.trangThai = DeviceStatus.ACTIVE;
    }

    // mã không cho sửa nên không có setter
    public String getId() {
        return maThietBi;
    }

    public String getName() {
        return tenThietBi;
    }

    public void setName(String tenThietBi) {
        if (tenThietBi == null || tenThietBi.trim().isEmpty()) {
            throw new IllegalArgumentException("Chua nhap ten");
        }
        this.tenThietBi = tenThietBi;
    }

    public int getYearInUse() {
        return namSuDung;
    }

    public void setYearInUse(int namSuDung) {
        if (namSuDung > Year.now().getValue()) {
            throw new IllegalArgumentException("Nam su dung khong hop le");
        }
        this.namSuDung = namSuDung;
    }

    public double getPrice() {
        return giaMua;
    }

    public void setPrice(double giaMua) {
        if (giaMua <= 0) {
            throw new IllegalArgumentException("Gia mua sai");
        }
        this.giaMua = giaMua;
    }

    public DeviceStatus getStatus() {
        return trangThai;
    }

    public void setStatus(DeviceStatus trangThai) {
        if (trangThai == null) {
            throw new IllegalArgumentException("Trang thai null");
        }
        this.trangThai = trangThai;
    }

    public int getYearsUsed() {
        return Year.now().getValue() - namSuDung;
    }

    // chi phí dự kiến cho 1 năm
    public abstract double calculateMaintenanceCost();

    @Override
    public String toString() {
        return String.format("[%s] %-22s | Nam SD: %d | Gia mua: %,.0f d | Trang thai: %s",
                maThietBi, tenThietBi, namSuDung, giaMua, trangThai);
    }
}
