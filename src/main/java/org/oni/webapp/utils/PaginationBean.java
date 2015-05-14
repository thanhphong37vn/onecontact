package org.oni.webapp.utils;

public class PaginationBean {

	private static final int DEFAULT_PAGE_SIZE = 3;
	public transient int numberPageOnOneScreen = 4;
	private transient int pageSize = DEFAULT_PAGE_SIZE;
	private transient int currentPage = 1;
	private transient int totalRecords;
	private transient int totalPages;
	
	public PaginationBean() {
	}

	public PaginationBean(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartIndex() {
		return (currentPage - 1) * pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	
	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	

	public int getTotalPages() {
		int totalPages = totalRecords / pageSize;
		if (totalRecords % pageSize != 0) {
			totalPages++;
		}
		return totalPages;
	}
}
