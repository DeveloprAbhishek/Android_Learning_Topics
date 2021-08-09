package com.example.fragment_iiievents03aug21;

import java.io.Serializable;

public class EventModel implements Serializable {
    String title, description, startDate, endDate, startTime, endTime, currency;
    int price;

    public EventModel(String name, String description, String startDate, String endDate, String startTime, String endTime, String currency, int price) {
        this.title = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.currency = currency;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getCurrency() {
        return currency;
    }

    public int getPrice() {
        return price;
    }
}
