package com.example.recyclerviewviewtypeswe14july21;

public class SenderModel extends BaseModel{
    private String senderMessage;

    public SenderModel(String senderMessage) {
        this.senderMessage = senderMessage;
    }

    public String getSenderMessage() {
        return senderMessage;
    }

    @Override
    int getViewType() {
        return 0;
    }
}
