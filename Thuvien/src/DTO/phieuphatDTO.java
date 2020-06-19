package DTO;

public class phieuphatDTO {
	private String mapp;
	private String mapm;
	private String ngaylap;
	private long tongtien;
	
	public phieuphatDTO() {
		mapp = null;
		mapm = null;
		ngaylap = null;
		tongtien = 0;
	}

	public phieuphatDTO(String mapp, String mapm, String ngaylap,long tongtien) {
		super();
		this.mapp = mapp;
		this.mapm = mapm;
		this.ngaylap = ngaylap;
		this.tongtien = tongtien;
	}
	
	public phieuphatDTO(String mapp, String mapm, String ngaylap) {
		super();
		this.mapp = mapp;
		this.mapm = mapm;
		this.ngaylap = ngaylap;
	}

	public String getMapp() {
		return mapp;
	}

	public void setMapp(String mapp) {
		this.mapp = mapp;
	}

	public String getMapm() {
		return mapm;
	}

	public void setMapm(String mapm) {
		this.mapm = mapm;
	}

	public String getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}

	public long getTongtien() {
		return tongtien;
	}

	public void setTongtien(long tongtien) {
		this.tongtien = tongtien;
	}
	
}
