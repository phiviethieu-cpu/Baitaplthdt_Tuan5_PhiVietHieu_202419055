/****************/
// Mã sinh viên: 202419055
// Họ tên: Phí Việt Hiếu
/****************/

// Kết nối mạng là khả năng chứ không phải loại thiết bị nên dùng interface,
// máy tính với máy in mạng nằm ở 2 nhánh kế thừa khác nhau vẫn dùng chung được.
public interface INetworkable {
    String getIpAddress();

    void connect(String diaChiIp);

    void disconnect();

    boolean isConnected();
}
