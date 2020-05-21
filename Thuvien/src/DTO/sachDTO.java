package DTO;

public class sachDTO {
	private String masach;
	private String tensach;
	private long giasach;
	private String matheloai;
	private String matg;
	private String manxb;
	private String malinhvuc;
	private int soluong;
	private int trangthai;
	
	public sachDTO() {
		masach = null;
		tensach = null;
		giasach = 0;
		matheloai = null;
		matg = null;
		manxb =null;
		malinhvuc = null;
		soluong = 0;
		trangthai = 0;//trạng thái 0 là mặc định , 1 là còn ở bảng ,2 là ẩn khỏi bảng
	}
	
	public sachDTO(String masach, String tensach, long giasach, String matheloai, String matg, String manxb,
			String malinhvuc, int soluong, int trangthai) {
		this.masach = masach;
		this.tensach = tensach;
		this.giasach = giasach;
		this.matheloai = matheloai;
		this.matg = matg;
		this.manxb = manxb;
		this.malinhvuc = malinhvuc;
		this.soluong = soluong;
		this.trangthai = trangthai;
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
	public String getMatheloai() {
		return matheloai;
	}
	public void setMatheloai(String matheloai) {
		this.matheloai = matheloai;
	}
	public String getMatg() {
		return matg;
	}
	public void setMatg(String matg) {
		this.matg = matg;
	}
	public String getManxb() {
		return manxb;
	}
	public void setManxb(String manxb) {
		this.manxb = manxb;
	}
	public String getMalinhvuc() {
		return malinhvuc;
	}
	public void setMalinhvuc(String malinhvuc) {
		this.malinhvuc = malinhvuc;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	
	

}
