package com.myproject.Blogappapi.payloads;

import javax.validation.constraints.NotNull;

public class PostDto {
	
	@NotNull
	private String title;
	
	@NotNull
	private String content;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostDto(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	@Override
	public String toString() {
		return "PostDto [title=" + title + ", content=" + content + "]";
	}
	
	

}
