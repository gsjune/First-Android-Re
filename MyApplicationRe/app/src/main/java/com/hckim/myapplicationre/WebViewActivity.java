package com.hckim.myapplicationre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWebView; // (2)
    private EditText mUrlEditText; // (4)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        mWebView = (WebView) findViewById(R.id.web_view); // (3)
        mUrlEditText = (EditText) findViewById(R.id.url_edit); // (3)' Alt Enter
    }

    public void showWebpage(View view) { // manifest 권한 복사 붙여넣기 (1)
        String url = mUrlEditText.getText().toString(); // (6)
        mWebView.loadUrl(url); // mWebView.loadUrl() 문서 참조 (5) (6)' ( ) 안 url

        // 요거 해 줘야 한다
        mWebView.setWebViewClient(new WebViewClient()); // (7) 여기서 필요
    }

    public void goBack(View view) {
        mWebView.goBack();
    }

    public void goForward(View view) {
        mWebView.goForward();
    }
}
