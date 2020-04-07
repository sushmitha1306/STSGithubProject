package com.wipro.sample;


public class ProductDTO {

	private Long pid;
	private String pname;
	private String pbrand;
	private String pmadein;
	private double prodprice;
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPmadein() {
		return pmadein;
	}
	public void setPmadein(String pmadein) {
		this.pmadein = pmadein;
	}
	public double getProdprice() {
		return prodprice;
	}
	public void setProdprice(double prodprice) {
		this.prodprice = prodprice;
	}
	
}
