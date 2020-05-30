package DTO;

public class phieumuonDTO {
	private String mapm;
	private String manv;
	private String mathe;
	private String ngaymuon;
	private String ngayquidinhtra;

	public phieumuonDTO() {
		mapm = null;
		manv = null;
		mathe = null;
		ngaymuon = null;
		ngayquidinhtra = null;
	}

	public phieumuonDTO(String mapm, String manv, String mathe, String ngaymuon, String ngayquidinhtra) {

		this.mapm = mapm;
		this.manv = manv;
		this.mathe = mathe;
		this.ngaymuon = ngaymuon;
		this.ngayquidinhtra = ngayquidinhtra;
	}

	public String getMapm() {
		return mapm;
	}

	public void setMapm(String mapm) {
		this.mapm = mapm;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getMathe() {
		return mathe;
	}

	public void setMathe(String mathe) {
		this.mathe = mathe;
	}

	public String getNgaymuon() {
		return ngaymuon;
	}

	public void setNgaymuon(String ngaymuon) {
		this.ngaymuon = ngaymuon;
	}

	public String getNgayquidinhtra() {
		return ngayquidinhtra;
	}

	public void setNgayquidinhtra(String ngayquidinhtra) {
		this.ngayquidinhtra = ngayquidinhtra;
	}

}
