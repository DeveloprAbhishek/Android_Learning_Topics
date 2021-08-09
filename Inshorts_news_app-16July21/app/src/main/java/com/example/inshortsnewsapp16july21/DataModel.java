package com.example.inshortsnewsapp16july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataModel implements Serializable {

	@SerializedName("author")
	private String author;

	@SerializedName("content")
	private String content;

	@SerializedName("date")
	private String date;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("readMoreUrl")
	private String readMoreUrl;

	@SerializedName("time")
	private String time;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	public String getAuthor(){
		return author;
	}

	public String getContent(){
		return content;
	}

	public String getDate(){
		return date;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public String getReadMoreUrl(){
		return readMoreUrl;
	}

	public String getTime(){
		return time;
	}

	public String getTitle(){
		return title;
	}

	public String getUrl(){
		return url;
	}
}