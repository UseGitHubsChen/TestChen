package com.gxa.model;

import java.util.List;

public class PageBean {

	private int pageNum; 		// 页码
	private int currentPage; 	// 每页条数
	private int totalPage; 		// 总页数
	private int totalCount; 	// 总条数
	private List<Course> list; 	// 每页数据
	private List<Orders> listorder; 	// 每页数据
	

	public List<Orders> getListorder() {
		return listorder;
	}

	public void setListorder(List<Orders> listorder) {
		this.listorder = listorder;
	}

	public List<Course> getList() {
		return list;
	}

	public void setList(List<Course> list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


}
