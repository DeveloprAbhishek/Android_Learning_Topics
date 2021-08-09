package com.example.recyclerviewviewtypeswe14july21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText mEtOption, mEtSendMessage;
    private ImageView mIvSend;

    private ArrayList<BaseModel> messageList = new ArrayList<>();
    private ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void setRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        chatAdapter = new ChatAdapter(messageList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(chatAdapter);
    }

    private void buildList() {
        if(mEtOption.getText().toString().equals("0")) {
            messageList.add(new SenderModel(mEtSendMessage.getText().toString()));
        } else if(mEtOption.getText().toString().equals("1")) {
            messageList.add(new ReceiverModel(mEtSendMessage.getText().toString()));
        }
        chatAdapter.notifyDataSetChanged();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        mEtOption = findViewById(R.id.etChoice);
        mEtSendMessage = findViewById(R.id.etSendMessage);
        mIvSend = findViewById(R.id.ivSend);
        mIvSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildList();
            }
        });
    }
}
