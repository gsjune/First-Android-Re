package com.hckim.myapplicationre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class ExIntent2Activity extends AppCompatActivity {

    public static final int RESULT_OK = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_intent2);

        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("data");
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }

    public void onCustomerManagementButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "고객관리");
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onSalesManagementButtonClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "매출관리");
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onMerchandiseManagementClicked(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "상품관리");
        setResult(RESULT_OK, intent);

        finish();
    }

}
