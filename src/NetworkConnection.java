/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

// Computer và NetworkPrinter khác lớp cha nên không gom lên cha được, dùng chung class này
public class NetworkConnection {
    private String diaChiIp; // null khi chưa kết nối
    private boolean dangKetNoi;

    public String getIpAddress() {
        return diaChiIp;
    }

    // moTaThietBi chỉ để in lỗi, vd "May tinh PC01"
    public void connect(String diaChiIp, String moTaThietBi) {
        if (diaChiIp == null || diaChiIp.trim().isEmpty()) {
            throw new IllegalArgumentException("IP rong");
        }
        if (dangKetNoi) {
            throw new IllegalStateException(moTaThietBi + " dang ket noi, khong the ket noi lai");
        }
        this.diaChiIp = diaChiIp.trim();
        this.dangKetNoi = true;
    }

    public void disconnect() {
        this.diaChiIp = null;
        this.dangKetNoi = false;
    }

    public boolean isConnected() {
        return dangKetNoi;
    }
}
