/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

import java.util.ArrayList;
import java.util.List;

// Quan hệ kết tập: thiết bị tạo ở ngoài rồi mới add vào, xóa phòng thì thiết bị vẫn còn.
public class LabRoom {
    private String maPhong;
    private String tenPhong;
    private int sucChua; // số chỗ ngồi sv, không phải số thiết bị
    private List<Device> danhSachThietBi;

    public LabRoom(String maPhong, String tenPhong, int sucChua) {
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Suc chua sai");
        }
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.sucChua = sucChua;
        this.danhSachThietBi = new ArrayList<>();
    }

    public String getRoomId() {
        return maPhong;
    }

    public String getRoomName() {
        return tenPhong;
    }

    public int getCapacity() {
        return sucChua;
    }

    public List<Device> getDevices() {
        return danhSachThietBi;
    }

    public void addDevice(Device thietBi) {
        if (findDevice(thietBi.getId()) != null) {
            throw new IllegalArgumentException("Thiet bi co ma " + thietBi.getId()
                    + " da ton tai trong phong " + maPhong);
        }
        danhSachThietBi.add(thietBi);
    }

    public boolean removeDevice(String maThietBi) {
        return danhSachThietBi.remove(findDevice(maThietBi));
    }

    public Device findDevice(String maThietBi) {
        for (Device tb : danhSachThietBi) {
            if (tb.getId().equals(maThietBi)) {
                return tb;
            }
        }
        return null;
    }

    // đa hình: không cần instanceof, mỗi lớp con tự tính
    public double calculateAnnualMaintenanceCost() {
        double tongChiPhi = 0;
        for (Device tb : danhSachThietBi) {
            tongChiPhi += tb.calculateMaintenanceCost();
        }
        return tongChiPhi;
    }

    public List<Device> getDevicesRequiringMaintenance() {
        List<Device> ketQua = new ArrayList<>();
        for (Device tb : danhSachThietBi) {
            if (tb.getStatus() == DeviceStatus.UNDER_MAINTENANCE || tb.getYearsUsed() > 5) {
                ketQua.add(tb);
            }
        }
        return ketQua;
    }

    public void printDevices() {
        System.out.println("Phong " + maPhong + " - " + tenPhong + " (suc chua " + sucChua + " cho):");
        if (danhSachThietBi.isEmpty()) {
            System.out.println("  (chua co thiet bi)");
            return;
        }
        for (Device tb : danhSachThietBi) {
            System.out.println("  " + tb);
        }
    }
}
