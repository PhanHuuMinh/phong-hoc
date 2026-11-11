package phanHuuMinh10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyPhongHoc {
	List<PhongHoc> danhSachPhong;
	
	public QuanLyPhongHoc() {
		this.danhSachPhong = new ArrayList<PhongHoc>();
	}
	
	public boolean themPhong(PhongHoc p) {
		if(danhSachPhong.contains(p))
			danhSachPhong.add(p);
		return false;
	}
	
	public PhongHoc timKiem(String maPhong) {
		for(PhongHoc p : danhSachPhong) {
			if(p.getMaPhong().equalsIgnoreCase(maPhong.trim())) {
				return p;
			}
		}
		return null;
	}
	
	public List<PhongHoc> layDanhSachTatCa() {
        return this.danhSachPhong;
    }

    public List<PhongHoc> layDanhSachDatChuan() {
        List<PhongHoc> dsDatChuan = new ArrayList<>();
        for (PhongHoc p : danhSachPhong) {
            if (p.datChuan()) {
                dsDatChuan.add(p);
            }
        }
        return dsDatChuan;
    }
    
    public void sapXepTangDanTheoDayNha() {
        Collections.sort(danhSachPhong, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return p1.getDayNha().compareToIgnoreCase(p2.getDayNha());
            }
        });
    }

    public void sapXepGiamDanTheoDienTich() {
        Collections.sort(danhSachPhong, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Double.compare(p2.getDienTich(), p1.getDienTich());
            }
        });
    }

    public void sapXepTangDanTheoSoBongDen() {
        Collections.sort(danhSachPhong, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc p1, PhongHoc p2) {
                return Integer.compare(p1.getSoBongDen(), p2.getSoBongDen());
            }
        });
    }

    public boolean capNhatSoMayTinh(String maPhong, int soMayMoi) {
        PhongHoc p = timKiem(maPhong);
        if (p instanceof PhongMayTinh) {
            ((PhongMayTinh) p).setSoMayTinh(soMayMoi);
            return true;
        }
        return false;
    }

    public boolean xoaPhong(String maPhong) {
        PhongHoc p = timKiem(maPhong);
        if (p != null) {
            return danhSachPhong.remove(p);
        }
        return false;
    }

    public int tinhTongSoPhong() {
        return danhSachPhong.size();
    }

    public List<PhongMayTinh> layDanhSachPhongMay60May() {
        List<PhongMayTinh> result = new ArrayList<>();
        for (PhongHoc p : danhSachPhong) {
            if (p instanceof PhongMayTinh) {
                PhongMayTinh pmt = (PhongMayTinh) p;
                if (pmt.getSoMayTinh() == 60) {
                    result.add(pmt);
                }
            }
        }
        return result;
    }
}

