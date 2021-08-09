package com.example.retrofitiiiuploadvideo28july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("status")
	private int status;

	@SerializedName("success")
	private boolean success;

	@SerializedName("data")
	private DataModel data;

	public int getStatus(){
		return status;
	}

	public boolean isSuccess(){
		return success;
	}

	public DataModel getData(){
		return data;
	}
}