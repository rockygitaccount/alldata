package com.boggingApp.Payloads;

import java.util.List;

public class PostResponse {
	
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private Long totalElement;
	private int totalPages;
	private boolean lastPage;
	public List<PostDto> getContent() {
		return content;
	}
	public void setContent(List<PostDto> content) {
		this.content = content;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalElement() {
		return totalElement;
	}
	public void setTotalElement(Long totalElement) {
		this.totalElement = totalElement;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public boolean getLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean b) {
		this.lastPage = b;
	}
	public PostResponse() {
		super();
	}
		
	
	
	

}
