package com.example.retrofitiiiiwy28july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("data")
	private DataModel data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("status")
	private int status;

	public void setData(DataModel data){
		this.data = data;
	}

	public DataModel getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}