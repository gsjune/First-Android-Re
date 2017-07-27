package com.hckim.myapplicationre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        // 요거 해 줘야 한다
        mWebView.setWebViewClient(new WebViewClient()); // B(2) (7)에서 이동
        // Javascript 사용하는 페이지를 볼 수 있게
        mWebView.getSettings().setJavaScriptEnabled(true); // B(3)
    }

    public void showWebpage(View view) { // manifest 권한 복사 붙여넣기 (1)
        String url = mUrlEditText.getText().toString(); // (6)

        if (url.startsWith("http://") || url.startsWith("https://")) { // B(1)
            mWebView.loadUrl(url);
        } else {
            mWebView.loadUrl("http://" + url);
        }

//        mWebView.loadUrl(url); // mWebView.loadUrl() 문서 참조 (5) (6)' ( ) 안 url

//        // 요거 해 줘야 한다
//        mWebView.setWebViewClient(new WebViewClient()); // (7) 여기서 필요. 중요
    }

    public void goBack(View view) {
        mWebView.goBack();
    }

    public void goForward(View view) {
        mWebView.goForward();
    }

    @Override
    public void onBackPressed() { // onb... Enter
        if (mWebView.canGoBack()) {
            mWebView.canGoBack();
        } else {
            super.onBackPressed();
        }
    }
}
