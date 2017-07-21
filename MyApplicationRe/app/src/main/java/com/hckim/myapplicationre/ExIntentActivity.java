package com.hckim.myapplicationre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ExIntentActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;
    public static final int REQUEST_CODE_MANAGEMENT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_intent);

        findViewById(R.id.management_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "android, " + "java" + 2017;
                Intent intent = new Intent(ExIntentActivity.this, ExIntent2Activity.class);
                intent.putExtra("data", message);
                startActivityForResult(intent, REQUEST_CODE_MANAGEMENT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MANAGEMENT && resultCode == RESULT_OK && data != null) {

        }
    }
}
