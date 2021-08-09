package com.example.unit_2c_2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ResponseModel implements Serializable {

	@SerializedName("date")
	private int date;

	@SerializedName("death")
	private int death;

	@SerializedName("totalTestResultsIncrease")
	private int totalTestResultsIncrease;

	@SerializedName("pending")
	private int pending;

	@SerializedName("hospitalizedCurrently")
	private int hospitalizedCurrently;

	@SerializedName("hospitalizedIncrease")
	private int hospitalizedIncrease;

	@SerializedName("states")
	private int states;

	@SerializedName("onVentilatorCumulative")
	private int onVentilatorCumulative;

	@SerializedName("hospitalized")
	private int hospitalized;

	@SerializedName("negative")
	private int negative;

	@SerializedName("total")
	private int total;

	@SerializedName("hospitalizedCumulative")
	private int hospitalizedCumulative;

	@SerializedName("inIcuCumulative")
	private int inIcuCumulative;

	@SerializedName("negativeIncrease")
	private int negativeIncrease;

	@SerializedName("positiveIncrease")
	private int positiveIncrease;

	@SerializedName("deathIncrease")
	private int deathIncrease;

	@SerializedName("totalTestResults")
	private int totalTestResults;

	@SerializedName("inIcuCurrently")
	private int inIcuCurrently;

	@SerializedName("dateChecked")
	private String dateChecked;

	@SerializedName("onVentilatorCurrently")
	private int onVentilatorCurrently;

	@SerializedName("positive")
	private int positive;

	@SerializedName("posNeg")
	private int posNeg;

	@SerializedName("lastModified")
	private String lastModified;

	@SerializedName("hash")
	private String hash;

	public int getDate(){
		return date;
	}

	public int getDeath(){
		return death;
	}

	public int getTotalTestResultsIncrease(){
		return totalTestResultsIncrease;
	}

	public int getPending(){
		return pending;
	}

	public int getHospitalizedCurrently(){
		return hospitalizedCurrently;
	}

	public int getHospitalizedIncrease(){
		return hospitalizedIncrease;
	}

	public int getStates(){
		return states;
	}

	public int getOnVentilatorCumulative(){
		return onVentilatorCumulative;
	}

	public int getHospitalized(){
		return hospitalized;
	}

	public int getNegative(){
		return negative;
	}

	public int getTotal(){
		return total;
	}

	public int getHospitalizedCumulative(){
		return hospitalizedCumulative;
	}

	public int getInIcuCumulative(){
		return inIcuCumulative;
	}

	public int getNegativeIncrease(){
		return negativeIncrease;
	}

	public int getPositiveIncrease(){
		return positiveIncrease;
	}

	public int getDeathIncrease(){
		return deathIncrease;
	}

	public int getTotalTestResults(){
		return totalTestResults;
	}

	public int getInIcuCurrently(){
		return inIcuCurrently;
	}

	public String getDateChecked(){
		return dateChecked;
	}

	public int getOnVentilatorCurrently(){
		return onVentilatorCurrently;
	}

	public int getPositive(){
		return positive;
	}

	public int getPosNeg(){
		return posNeg;
	}

	public String getLastModified(){
		return lastModified;
	}

	public String getHash(){
		return hash;
	}

	@Override
 	public String toString(){
		return 
			"ResponseModel{" + 
			"date = '" + date + '\'' + 
			",death = '" + death + '\'' + 
			",totalTestResultsIncrease = '" + totalTestResultsIncrease + '\'' + 
			",pending = '" + pending + '\'' + 
			",hospitalizedCurrently = '" + hospitalizedCurrently + '\'' + 
			",hospitalizedIncrease = '" + hospitalizedIncrease + '\'' + 
			",states = '" + states + '\'' + 
			",onVentilatorCumulative = '" + onVentilatorCumulative + '\'' + 
			",hospitalized = '" + hospitalized + '\'' + 
			",negative = '" + negative + '\'' + 
			",total = '" + total + '\'' + 
			",hospitalizedCumulative = '" + hospitalizedCumulative + '\'' + 
			",inIcuCumulative = '" + inIcuCumulative + '\'' + 
			",negativeIncrease = '" + negativeIncrease + '\'' + 
			",positiveIncrease = '" + positiveIncrease + '\'' + 
			",deathIncrease = '" + deathIncrease + '\'' + 
			",totalTestResults = '" + totalTestResults + '\'' + 
			",inIcuCurrently = '" + inIcuCurrently + '\'' + 
			",dateChecked = '" + dateChecked + '\'' + 
			",onVentilatorCurrently = '" + onVentilatorCurrently + '\'' + 
			",positive = '" + positive + '\'' + 
			",posNeg = '" + posNeg + '\'' + 
			",lastModified = '" + lastModified + '\'' + 
			",hash = '" + hash + '\'' + 
			"}";
		}
}