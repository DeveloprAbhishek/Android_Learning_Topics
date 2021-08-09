package com.example.filltheform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView organizationName,customerName, mobileNumber,email, address, manufacturer, taxID, companyID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getIntentData();


    }

    private void getIntentData() {
        this.organizationName = findViewById(R.id.tvOrganizationName);
        this.customerName = findViewById(R.id.tvCustomerName);
        this.mobileNumber = findViewById(R.id.tvMobileNumber);
        this.email = findViewById(R.id.tvEmail);
        this.address = findViewById(R.id.tvAddress);
        this.manufacturer = findViewById(R.id.tvManufacturer);
        this.taxID = findViewById(R.id.tvTaxID);
        this.companyID = findViewById(R.id.tvCompanyID);

        String organizationName = getIntent().getStringExtra("organizationName");
        String customerName = getIntent().getStringExtra("customerName");
        String mobileNumber = getIntent().getStringExtra("mobileNumber");
        String email = getIntent().getStringExtra("email");
        String address = getIntent().getStringExtra("address");
        String manufacturer = getIntent().getStringExtra("manufacturer");
        String taxID = getIntent().getStringExtra("taxID");
        String companyID = getIntent().getStringExtra("companyID");

        this.organizationName.setText(organizationName);
        this.customerName.setText(customerName);
        this.mobileNumber.setText(mobileNumber);
        this.email.setText(email);
        this.address.setText(address);
        this.manufacturer.setText(manufacturer);
        this.taxID.setText(taxID);
        this.companyID.setText(companyID);
    }
}