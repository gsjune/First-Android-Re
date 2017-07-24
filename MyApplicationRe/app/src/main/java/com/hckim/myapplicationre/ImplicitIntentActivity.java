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

    public void openWebBrowser(View view) { // Xml on click Alt Enter -> 메소드
        EditText urlEditText = (EditText) findViewById(R.id.url_edit); // A(2) 필드에서 하는 게 맞으나 각각 비교할 수 있도록
        openWebPage(urlEditText.getText().toString());
    }

    public void openWebPage(String url) { // Developer에서 복사 A(1)
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) { // B(1)
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhone(View view) { // B(2) Xml on click Alt Enter -> 메소드
        EditText phoneEditText = (EditText) findViewById(R.id.phone_edit);
        dialPhoneNumber(phoneEditText.getText().toString()); // dialPhoneNumber 위의 메소드에서 가져와 쓰면 됨
    }

    public void sendTextMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void sendMessage(View view) {
        EditText messageEditText = (EditText) findViewById(R.id.message_edit);
        sendTextMessage(messageEditText.getText().toString());
    }
}
