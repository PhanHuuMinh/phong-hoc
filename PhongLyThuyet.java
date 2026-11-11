package phanHuuMinh10;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;
	
	
	public boolean isCoMayChieu() {
		return coMayChieu;
	}


	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}


	/**
	 * @param maPhong
	 * @param dayNha
	 * @param dienTich
	 * @param soBongDen
	 * @param coMayChieu
	 */
	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}
	
	@Override
	public boolean datChuan() {
		return duAnhSang() && coMayChieu;
	}

	@Override
	public String toString() {
		return "PhongLyThuyet [coMayChieu=" + coMayChieu + "]";
	}


	

}
