package DTO;

public class phieuphatDTO {
	private String mapp;
	private String mapm;
	private String maqd;
	private long tienphat;
	private String ngaylap;
	
	public phieuphatDTO() {
		mapp = null;
		mapm = null;
		maqd = null;
		tienphat = 0;
		ngaylap = null;
	}

	public phieuphatDTO(String mapp, String mapm, String maqd, long tienphat, String ngaylap) {
		super();
		this.mapp = mapp;
		this.mapm = mapm;
		this.maqd = maqd;
		this.tienphat = tienphat;
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

	public String getMaqd() {
		return maqd;
	}

	public void setMaqd(String maqd) {
		this.maqd = maqd;
	}

	public long getTienphat() {
		return tienphat;
	}

	public void setTienphat(long tienphat) {
		this.tienphat = tienphat;
	}

	public String getNgaylap() {
		return ngaylap;
	}

	public void setNgaylap(String ngaylap) {
		this.ngaylap = ngaylap;
	}
	
	
}
