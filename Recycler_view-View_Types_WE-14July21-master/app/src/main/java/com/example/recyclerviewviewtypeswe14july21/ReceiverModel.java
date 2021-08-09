package com.example.recyclerviewviewtypeswe14july21;

public class ReceiverModel extends BaseModel{
    private String receiverMessage;

    public ReceiverModel(String receiverMessage) {
        this.receiverMessage = receiverMessage;
    }

    public String getReceiverMessage() {
        return receiverMessage;
    }

    @Override
    int getViewType() {
        return 1;
    }
}
