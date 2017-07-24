package com.hckim.myapplicationre;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
    }

    public void openWebBrowser(View view) {
        EditText urlEditText = (EditText) findViewById(R.id.url_edit); // 필드에서 하는 게 맞으나 각각 비교할 수 있도록
        openWebPage(urlEditText.getText().toString());
    }

    public void openWebPage(String url) { // Developer에서 복사
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
