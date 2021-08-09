package com.example.retrofitiiiiwy28july21;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class DataModel implements Serializable {

	@SerializedName("id")
	private String id;

	@SerializedName("title")
	private String title;

	@SerializedName("description")
	private Object description;

	@SerializedName("datetime")
	private int datetime;

	@SerializedName("type")
	private String type;

	@SerializedName("animated")
	private boolean animated;

	@SerializedName("width")
	private int width;

	@SerializedName("height")
	private int height;

	@SerializedName("size")
	private int size;

	@SerializedName("views")
	private int views;

	@SerializedName("bandwidth")
	private int bandwidth;

	@SerializedName("vote")
	private Object vote;

	@SerializedName("favorite")
	private boolean favorite;

	@SerializedName("nsfw")
	private Object nsfw;

	@SerializedName("section")
	private Object section;

	@SerializedName("account_url")
	private Object accountUrl;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("is_ad")
	private boolean isAd;

	@SerializedName("in_most_viral")
	private boolean inMostViral;

	@SerializedName("has_sound")
	private boolean hasSound;

	@SerializedName("tags")
	private List<Object> tags;

	@SerializedName("ad_type")
	private int adType;

	@SerializedName("ad_url")
	private String adUrl;

	@SerializedName("edited")
	private String edited;

	@SerializedName("in_gallery")
	private boolean inGallery;

	@SerializedName("deletehash")
	private String deletehash;

	@SerializedName("name")
	private String name;

	@SerializedName("link")
	private String link;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setDescription(Object description){
		this.description = description;
	}

	public Object getDescription(){
		return description;
	}

	public void setDatetime(int datetime){
		this.datetime = datetime;
	}

	public int getDatetime(){
		return datetime;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setAnimated(boolean animated){
		this.animated = animated;
	}

	public boolean isAnimated(){
		return animated;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setViews(int views){
		this.views = views;
	}

	public int getViews(){
		return views;
	}

	public void setBandwidth(int bandwidth){
		this.bandwidth = bandwidth;
	}

	public int getBandwidth(){
		return bandwidth;
	}

	public void setVote(Object vote){
		this.vote = vote;
	}

	public Object getVote(){
		return vote;
	}

	public void setFavorite(boolean favorite){
		this.favorite = favorite;
	}

	public boolean isFavorite(){
		return favorite;
	}

	public void setNsfw(Object nsfw){
		this.nsfw = nsfw;
	}

	public Object getNsfw(){
		return nsfw;
	}

	public void setSection(Object section){
		this.section = section;
	}

	public Object getSection(){
		return section;
	}

	public void setAccountUrl(Object accountUrl){
		this.accountUrl = accountUrl;
	}

	public Object getAccountUrl(){
		return accountUrl;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public int getAccountId(){
		return accountId;
	}

	public void setIsAd(boolean isAd){
		this.isAd = isAd;
	}

	public boolean isIsAd(){
		return isAd;
	}

	public void setInMostViral(boolean inMostViral){
		this.inMostViral = inMostViral;
	}

	public boolean isInMostViral(){
		return inMostViral;
	}

	public void setHasSound(boolean hasSound){
		this.hasSound = hasSound;
	}

	public boolean isHasSound(){
		return hasSound;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setAdType(int adType){
		this.adType = adType;
	}

	public int getAdType(){
		return adType;
	}

	public void setAdUrl(String adUrl){
		this.adUrl = adUrl;
	}

	public String getAdUrl(){
		return adUrl;
	}

	public void setEdited(String edited){
		this.edited = edited;
	}

	public String getEdited(){
		return edited;
	}

	public void setInGallery(boolean inGallery){
		this.inGallery = inGallery;
	}

	public boolean isInGallery(){
		return inGallery;
	}

	public void setDeletehash(String deletehash){
		this.deletehash = deletehash;
	}

	public String getDeletehash(){
		return deletehash;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	@Override
 	public String toString(){
		return 
			"DataModel{" + 
			"id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",description = '" + description + '\'' + 
			",datetime = '" + datetime + '\'' + 
			",type = '" + type + '\'' + 
			",animated = '" + animated + '\'' + 
			",width = '" + width + '\'' + 
			",height = '" + height + '\'' + 
			",size = '" + size + '\'' + 
			",views = '" + views + '\'' + 
			",bandwidth = '" + bandwidth + '\'' + 
			",vote = '" + vote + '\'' + 
			",favorite = '" + favorite + '\'' + 
			",nsfw = '" + nsfw + '\'' + 
			",section = '" + section + '\'' + 
			",account_url = '" + accountUrl + '\'' + 
			",account_id = '" + accountId + '\'' + 
			",is_ad = '" + isAd + '\'' + 
			",in_most_viral = '" + inMostViral + '\'' + 
			",has_sound = '" + hasSound + '\'' + 
			",tags = '" + tags + '\'' + 
			",ad_type = '" + adType + '\'' + 
			",ad_url = '" + adUrl + '\'' + 
			",edited = '" + edited + '\'' + 
			",in_gallery = '" + inGallery + '\'' + 
			",deletehash = '" + deletehash + '\'' + 
			",name = '" + name + '\'' + 
			",link = '" + link + '\'' + 
			"}";
		}
}