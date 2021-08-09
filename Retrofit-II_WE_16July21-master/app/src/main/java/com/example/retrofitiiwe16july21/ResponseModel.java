package com.example.retrofitiiwe16july21;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("name")
	private String name;

	@SerializedName("postId")
	private int postId;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("email")
	private String email;

	public String getName(){
		return name;
	}

	public int getPostId(){
		return postId;
	}

	public int getId(){
		return id;
	}

	public String getBody(){
		return body;
	}

	public String getEmail(){
		return email;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"name = '" + name + '\'' + 
			",postId = '" + postId + '\'' + 
			",id = '" + id + '\'' + 
			",body = '" + body + '\'' + 
			",email = '" + email + '\'' + 
			"}";
		}
}