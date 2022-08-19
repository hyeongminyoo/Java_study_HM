package com.hm.start.board;

import java.sql.Timestamp;

public class BoardDTO {
	private Integer postNum;
	private String title;
	private String contents;
	private String userName;
	private Timestamp postDate;
	private Integer hit;
	
	public BoardDTO() {
		
	}
	
	public Timestamp getPostDate() {
		return postDate;
	}
	
	
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getHit() {
		return hit;
	}
	public void setHit(Integer hit) {
		this.hit = hit;
	}
	
	
	
}
