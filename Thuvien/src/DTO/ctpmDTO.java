package DTO;

public class ctpmDTO {
	private String mapm;
	private String masach;
	private int soluong;
	private String tinhtrang;
	private String ngaythuctra;
	
	public ctpmDTO() {
		mapm = null;
		masach = null;
		soluong = 0;
		tinhtrang = null;
		ngaythuctra = null;
	}

	public ctpmDTO(String mapm, String masach, int soluong, String tinhtrang, String ngaythuctra) {
		this.mapm = mapm;
		this.masach = masach;
		this.soluong = soluong;
		this.tinhtrang = tinhtrang;
		this.ngaythuctra = ngaythuctra;
	}

	public String getMapm() {
		return mapm;
	}

	public void setMapm(String mapm) {
		this.mapm = mapm;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public String getNgaythuctra() {
		return ngaythuctra;
	}

	public void setNgaythuctra(String ngaythuctra) {
		this.ngaythuctra = ngaythuctra;
	}

}
