package com.ceva.bank.common.beans;

public class Record {

	private String r1c1;
	private String r1c2;
	private String r1c3;
	private String r1c4;
	private String r1c5;
	private String r1c6;
	private String postingDate;
	
	public String getR1c1() {
		return r1c1;
	}
	public void setR1c1(String r1c1) {
		this.r1c1 = r1c1;
	}
	public String getR1c2() {
		return r1c2;
	}
	public void setR1c2(String r1c2) {
		this.r1c2 = r1c2;
	}
	public String getR1c3() {
		return r1c3;
	}
	public void setR1c3(String r1c3) {
		this.r1c3 = r1c3;
	}
	public String getR1c4() {
		return r1c4;
	}
	public void setR1c4(String r1c4) {
		this.r1c4 = r1c4;
	}
	public String getR1c5() {
		return r1c5;
	}
	public void setR1c5(String r1c5) {
		this.r1c5 = r1c5;
	}
	public String getR1c6() {
		return r1c6;
	}
	public void setR1c6(String r1c6) {
		this.r1c6 = r1c6;
	}
	
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	
	@Override
	public String toString() {
		return "Record [r1c1=" + r1c1 + ", r1c2=" + r1c2 + ", r1c3=" + r1c3
				+ ", r1c4=" + r1c4 + ", r1c5=" + r1c5 + ", r1c6=" + r1c6
				+ ", postingDate=" + postingDate + "]";
	}
}
