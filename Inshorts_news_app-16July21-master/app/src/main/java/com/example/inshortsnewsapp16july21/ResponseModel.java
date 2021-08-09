package com.example.inshortsnewsapp16july21;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("category")
	private String category;

	@SerializedName("data")
	private List<DataModel> data;

	@SerializedName("success")
	private boolean success;

	public String getCategory(){
		return category;
	}

	public List<DataModel> getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}
}