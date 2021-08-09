package com.example.retrofitiiiuploadvideo28july21;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataModel implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("deletehash")
	private String deletehash;

	@SerializedName("account_id")
	private Object accountId;

	@SerializedName("account_url")
	private Object accountUrl;

	@SerializedName("ad_type")
	private Object adType;

	@SerializedName("ad_url")
	private Object adUrl;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private Object description;

	@SerializedName("name")
	private String name;

	@SerializedName("type")
	private String type;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("size")
	private int size;

	@SerializedName("views")
	private int views;

	@SerializedName("section")
	private Object section;

	@SerializedName("vote")
	private Object vote;

	@SerializedName("bandwidth")
	private int bandwidth;

	@SerializedName("animated")
	private boolean animated;

	@SerializedName("favorite")
	private boolean favorite;

	@SerializedName("in_gallery")
	private boolean inGallery;

	@SerializedName("in_most_viral")
	private boolean inMostViral;

	@SerializedName("has_sound")
	private boolean hasSound;

	@SerializedName("is_ad")
	private boolean isAd;

	@SerializedName("nsfw")
	private Object nsfw;

	@SerializedName("link")
	private String link;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("processing")
	private ProcessingModel processing;

	@SerializedName("datetime")
	private int datetime;

	@SerializedName("mp4")
	private String mp4;

	@SerializedName("hls")
	private String hls;

	public String getId(){
		return id;
	}

	public String getDeletehash(){
		return deletehash;
	}

	public Object getAccountId(){
		return accountId;
	}

	public Object getAccountUrl(){
		return accountUrl;
	}

	public Object getAdType(){
		return adType;
	}

	public Object getAdUrl(){
		return adUrl;
	}

	public String getTitle(){
		return title;
	}

	public Object getDescription(){
		return description;
	}

	public String getName(){
		return name;
	}

	public String getType(){
		return type;
	}

	public int getWidth(){
		return width;
	}

	public int getHeight(){
		return height;
	}

	public int getSize(){
		return size;
	}

	public int getViews(){
		return views;
	}

	public Object getSection(){
		return section;
	}

	public Object getVote(){
		return vote;
	}

	public int getBandwidth(){
		return bandwidth;
	}

	public boolean isAnimated(){
		return animated;
	}

	public boolean isFavorite(){
		return favorite;
	}

	public boolean isInGallery(){
		return inGallery;
	}

	public boolean isInMostViral(){
		return inMostViral;
	}

	public boolean isHasSound(){
		return hasSound;
	}

	public boolean isIsAd(){
		return isAd;
	}

	public Object getNsfw(){
		return nsfw;
	}

	public String getLink(){
		return link;
	}

	public List<Object> getTags(){
		return tags;
	}

	public ProcessingModel getProcessing(){
		return processing;
	}

	public int getDatetime(){
		return datetime;
	}

	public String getMp4(){
		return mp4;
	}

	public String getHls(){
		return hls;
	}
}