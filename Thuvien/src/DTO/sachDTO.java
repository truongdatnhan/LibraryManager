package DTO;

public class sachDTO {
	private String masach;
	private String tensach;
	private long giasach;
	private String maloai;
	private String matacgia;
	private String manxb;
	private int soluong;

	public sachDTO() {
		masach = null;
		tensach = null;
		giasach = 0;
		maloai = null;
		matacgia = null;
		manxb = null;
		soluong = 0;
	}

	public sachDTO(String masach, String tensach, long giasach, String maloai, String matacgia, String manxb,
			int soluong) {
		this.masach = masach;
		this.tensach = tensach;
		this.giasach = giasach;
		this.maloai = maloai;
		this.matacgia = matacgia;
		this.manxb = manxb;
		this.soluong = 0;
	}

	public String getMasach() {
		return masach;
	}

	public void setMasach(String masach) {
		this.masach = masach;
	}

	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public long getGiasach() {
		return giasach;
	}

	public void setGiasach(long giasach) {
		this.giasach = giasach;
	}

	public String getMaloai() {
		return maloai;
	}

	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}

	public String getMatacgia() {
		return matacgia;
	}

	public void setMatacgia(String matacgia) {
		this.matacgia = matacgia;
	}

	public String getManxb() {
		return manxb;
	}

	public void setManxb(String manxb) {
		this.manxb = manxb;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

}
