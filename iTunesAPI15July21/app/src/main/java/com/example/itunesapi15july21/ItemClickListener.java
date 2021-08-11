package com.example.itunesapi15july21;

public interface ItemClickListener {
    void onItemPlayButtonClicked(String url);
    void onItemPauseButtonClicked();
    void onItemDeleteButtonClicked(ResultsModel resultsModel);
}
