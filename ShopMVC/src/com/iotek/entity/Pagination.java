package com.iotek.entity;

import java.util.ArrayList;

public class Pagination {
	private ArrayList<Goods> datalist=new ArrayList<>();
	private int pagesize;
	private int currpage;
	private int totalcount;
	private int totalpage;
	public ArrayList<Goods> getDatalist() {
		return datalist;
	}
	public void setDatalist(ArrayList<Goods> datalist) {
		this.datalist = datalist;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getTatalcount() {
		return totalcount;
	}
	public void setTatalcount(int tatalcount) {
		this.totalcount = tatalcount;
	}
	public int getTotalpage() {
		return totalcount / pagesize + (totalcount % pagesize > 0 ? 1 : 0);
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	
	
	
	
	
}
