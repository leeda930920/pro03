package kr.go.pohang.dto;

public class Payment {
	 private String pcode;
	 private String id;
	 private String ocode;
	 private String ptype;
	 private String ptnum;
	 private int pprice;
	 private String pdate;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOcode() {
		return ocode;
	}
	public void setOcode(String ocode) {
		this.ocode = ocode;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getPtnum() {
		return ptnum;
	}
	public void setPtnum(String ptnum) {
		this.ptnum = ptnum;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	 
	 
}
