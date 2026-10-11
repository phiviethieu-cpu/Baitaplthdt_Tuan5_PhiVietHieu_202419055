# Bài tập tuần 5 - Hệ thống quản lý thiết bị phòng thực hành

- Ngôn ngữ: Java

## Cách chạy

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

## Giai thich thiet ke

Ve may in co mang: em chon cach tach NetworkPrinter ke thua Printer va implements INetworkable. Cach nay de hieu, nhin ten lop la biet may in nao co mang, va kieu INetworkable kiem tra duoc luc bien dich. Nhuoc diem la neu sau nay may chieu cung co mang thi lai phai them 1 lop con nua, so lop se tang len. Con cach ket tap 1 thanh phan mang vao Device thi linh hoat hon (bat/tat mang luc chay duoc) nhung khi dung phai kiem tra null va phai viet them cac ham goi lai sang thanh phan mang.

LabRoom va Device la ket tap vi thiet bi duoc tao ra truoc roi moi add vao phong, xoa phong hoac chuyen phong thi thiet bi van ton tai.
