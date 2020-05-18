package DTO;

public class nguoidungDTO {

	private String manv;
	private String mkhau;
	private String quyen;

	public nguoidungDTO(String manv, String mkhau, String quyen) {

		this.manv = manv;
		this.mkhau = mkhau;
		this.quyen = quyen;
	}

	public nguoidungDTO() {
		manv = null;
		mkhau = null;
		quyen = null;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getMkhau() {
		return mkhau;
	}

	public void setMkhau(String mkhau) {
		this.mkhau = mkhau;
	}

	public String getQuyen() {
		return quyen;
	}

	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}

}
