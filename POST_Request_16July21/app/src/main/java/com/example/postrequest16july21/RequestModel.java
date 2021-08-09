package com.example.postrequest16july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RequestModel implements Serializable {
	public RequestModel(String email, String password, String title, String requestType) {
		this.email = email;
		this.password = password;
		this.title = title;
		this.requestType = requestType;
	}

	@SerializedName("email")
	private String email;

	@SerializedName("password")
	private String password;

	@SerializedName("title")
	private String title;

	@SerializedName("requestType")
	private String requestType;

}