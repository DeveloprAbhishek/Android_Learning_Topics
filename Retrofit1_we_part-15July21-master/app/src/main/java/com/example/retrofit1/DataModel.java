package com.example.retrofit1;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataModel implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("first_name")
	private String firstName;

	@SerializedName("last_name")
	private String lastName;

	@SerializedName("avatar")
	private String avatar;

	public int getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getAvatar(){
		return avatar;
	}

	@Override
 	public String toString(){
		return 
			"DataModel{" + 
			"id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",avatar = '" + avatar + '\'' + 
			"}";
		}
}