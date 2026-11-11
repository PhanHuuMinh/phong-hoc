package phanHuuMinh10;

import java.util.Objects;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    public boolean duAnhSang() {
        return (this.dienTich / 10.0) <= this.soBongDen;
    }

    public abstract boolean datChuan();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhongHoc phongHoc = (PhongHoc) o;
        return Objects.equals(maPhong, phongHoc.maPhong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhong);
    }

    @Override
    public String toString() {
        return String.format("Mã: %-8s | Dãy: %-3s | Diện tích: %6.1fm2 | Đèn: %2d bóng | Đạt chuẩn: %-5s",
                maPhong, dayNha, dienTich, soBongDen, datChuan() ? "Đạt" : "Không");
    }
}