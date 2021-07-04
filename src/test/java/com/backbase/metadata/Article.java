package com.backbase.metadata;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Article {
	
	private List<String> tagList = new ArrayList<String>();
	private String title="";
	private String description="";
	private String body="";

	public Article(List<String> tagList, String title, String description, String body) {
		super();
		this.tagList = tagList;
		this.title = title;
		this.description = description;
		this.body = body;
	}
	
	@Override
	public String toString() {
		return "article [tagList=" + tagList + ", title=" + title + ", description=" + description + ", body=" + body
				+ "]";
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String> getTagList() {
		return tagList;
	}
	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}


}
