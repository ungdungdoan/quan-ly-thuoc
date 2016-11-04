package thuocForm;

public class Thuoc {
	private int mathuoc;
	private String tenthuoc;
	private String donvitinh;
	private int soluong;
	private int dongia;
	
	
	public Thuoc() {
		
	}
	public Thuoc(int mathuoc, String tenthuoc, String donvitinh, int soluong, int dongia) {
		this.mathuoc = mathuoc;
		this.tenthuoc = tenthuoc;
		this.donvitinh = donvitinh;
		this.soluong = soluong;
		this.dongia = dongia;
	}
	public int getMathuoc() {
		return mathuoc;
	}
	public void setMathuoc(int mathuoc) {
		this.mathuoc = mathuoc;
	}
	public String getTenthuoc() {
		return tenthuoc;
	}
	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}
	public String getDonvitinh() {
		return donvitinh;
	}
	public void setDonvitinh(String donvitinh) {
		this.donvitinh = donvitinh;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getDongia() {
		return dongia;
	}
	public void setDongia(int dongia) {
		this.dongia = dongia;
	}
	
}
