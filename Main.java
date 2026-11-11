package phanHuuMinh10;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static QuanLyPhongHoc ql = new QuanLyPhongHoc();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ql.themPhong(new PhongLyThuyet("A101", "A", 50.0, 5, true));
        ql.themPhong(new PhongLyThuyet("A102", "A", 40.0, 3, false));
        ql.themPhong(new PhongMayTinh("B201", "B", 90.0, 10, 60));
        ql.themPhong(new PhongMayTinh("B202", "B", 60.0, 6, 30));
        ql.themPhong(new PhongThiNghiem("C301", "C", 80.0, 8, "Hóa học", 40, true));
        ql.themPhong(new PhongThiNghiem("C302", "C", 70.0, 5, "Sinh học", 35, false));

        int luaChon;
        do {
            inMenu();
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = Integer.parseInt(scanner.nextLine());

            switch (luaChon) {
                case 1:
                    xuatDanhSach("DANH SÁCH TẤT CẢ PHÒNG HỌC", ql.layDanhSachTatCa());
                    break;
                case 2:
                    xuatDanhSach("DANH SÁCH PHÒNG HỌC ĐẠT CHUẨN", ql.layDanhSachDatChuan());
                    break;
                case 3:
                    System.out.print("Nhập mã phòng cần tìm: ");
                    String ma = scanner.nextLine();
                    PhongHoc p = ql.timKiem(ma);
                    if (p != null) {
                        System.out.println("Kết quả: " + p);
                    } else {
                        System.out.println("Không tìm thấy phòng có mã " + ma);
                    }
                    break;
                case 4:
                    ql.sapXepTangDanTheoDayNha();
                    xuatDanhSach("ĐÃ SẮP XẾP TĂNG DẦN THEO DÃY NHÀ", ql.layDanhSachTatCa());
                    break;
                case 5:
                    ql.sapXepGiamDanTheoDienTich();
                    xuatDanhSach("ĐÃ SẮP XẾP GIẢM DẦN THEO DIỆN TÍCH", ql.layDanhSachTatCa());
                    break;
                case 6:
                    ql.sapXepTangDanTheoSoBongDen();
                    xuatDanhSach("ĐÃ SẮP XẾP TĂNG DẦN THEO SỐ BÓNG ĐÈN", ql.layDanhSachTatCa());
                    break;
                case 7:
                    System.out.print("Nhập mã phòng máy cần cập nhật: ");
                    String maCapNhat = scanner.nextLine();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayMoi = Integer.parseInt(scanner.nextLine());
                    if (ql.capNhatSoMayTinh(maCapNhat, soMayMoi)) {
                        System.out.println("Cập nhật thành công!");
                    } else {
                        System.out.println("Không tìm thấy phòng máy hoặc mã không hợp lệ!");
                    }
                    break;
                case 8:
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maXoa = scanner.nextLine();
                    PhongHoc pXoa = ql.timKiem(maXoa);
                    if (pXoa != null) {
                        System.out.print("Bạn có chắc chắn muốn xóa phòng " + maXoa + "? (Y/N): ");
                        String xacNhan = scanner.nextLine();
                        if (xacNhan.equalsIgnoreCase("Y")) {
                            ql.xoaPhong(maXoa);
                            System.out.println("Đã xóa phòng thành công.");
                        } else {
                            System.out.println("Hủy thao tác xóa.");
                        }
                    } else {
                        System.out.println("Không tìm thấy phòng cần xóa!");
                    }
                    break;
                case 9:
                    System.out.println("Tổng số phòng học hiện có: " + ql.tinhTongSoPhong());
                    break;
                case 10:
                    xuatDanhSach("DANH SÁCH PHÒNG MÁY CÓ 60 MÁY", ql.layDanhSachPhongMay60May());
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
            System.out.println();
        } while (luaChon != 0);
    }

    private static void inMenu() {
        System.out.println("============= QUẢN LÝ PHÒNG HỌC =============");
        System.out.println("1. Xuất toàn bộ danh sách phòng học");
        System.out.println("2. Xuất danh sách phòng đạt chuẩn");
        System.out.println("3. Tìm kiếm phòng học theo mã");
        System.out.println("4. Sắp xếp danh sách tăng dần theo dãy nhà");
        System.out.println("5. Sắp xếp danh sách giảm dần theo diện tích");
        System.out.println("6. Sắp xếp danh sách tăng dần theo số bóng đèn");
        System.out.println("7. Cập nhật số máy tính cho phòng máy");
        System.out.println("8. Xóa một phòng học (có xác nhận)");
        System.out.println("9. Tính tổng số phòng học");
        System.out.println("10. Lấy danh sách các phòng có đúng 60 máy tính");
        System.out.println("0. Thoát");
        System.out.println("=============================================");
    }

    private static void xuatDanhSach(String tieuDe, List<?> ds) {
        System.out.println("--- " + tieuDe + " ---");
        if (ds.isEmpty()) {
            System.out.println("Danh sách trống!");
        } else {
            for (Object obj : ds) {
                System.out.println(obj);
            }
        }
    }
}
