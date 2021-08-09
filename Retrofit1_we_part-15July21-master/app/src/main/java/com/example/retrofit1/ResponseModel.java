package com.example.retrofit1;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("data")
	private DataModel data;

	@SerializedName("support")
	private SupportModel support;

	public DataModel getData(){
		return data;
	}

	public SupportModel getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}