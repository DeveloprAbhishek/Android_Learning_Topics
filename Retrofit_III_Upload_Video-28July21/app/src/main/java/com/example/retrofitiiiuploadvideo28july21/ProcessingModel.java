package com.example.retrofitiiiuploadvideo28july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ProcessingModel implements Serializable {

	@SerializedName("status")
	private String status;

	public String getStatus(){
		return status;
	}
}