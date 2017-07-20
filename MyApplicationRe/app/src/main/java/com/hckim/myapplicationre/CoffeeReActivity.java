package com.hckim.myapplicationre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeReActivity extends AppCompatActivity {

    private TextView mQuantityTextView; // 로컬 변수로 전역 변수로 바꿈
    private TextView mPriceTextView; // (b)
    private int mQuantity = 1; // 메소드에서 1을 내리고 올리기 위해 변수 필요

    private DecimalFormat mFormat = new DecimalFormat("#,##0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_re);

        // (1) xml에 있는 View의 레퍼런스를 가져오는 방법
        // TextView quantityTextView = (TextView) findViewById(R.id.quantity_text);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text);
        // (1)과 (2)' -> 변수 quantityTextView를 필드로 뺌.
        // 변수 위에서 Find Action field Enter m 붙이고 Q로 바꿈

        // (2) (2)'의 방법으로 바꿈
//        Button minusButton = (Button) findViewById(R.id.minus_button);
//        Button plusButton = (Button) findViewById(R.id.plus_button);

        // (a)
        mPriceTextView = (TextView) findViewById(R.id.price_text);

        // quantityTextView.setText("10");
//        mQuantityTextView.setText("10");
        mQuantityTextView.setText("" + mQuantity); // mQuantity만 있으면 빨간줄
//        mQuantityTextView.setText(String.valueOf(mQuantity)); // 또 다른 방법

        mPriceTextView.setText("3000원"); // (c)
    }

    // (2)'
    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show(); // 화면 확인
        mQuantity--;
        if (mQuantity < 1) {
            mQuantity = 1;
        }
        mQuantityTextView.setText("" + mQuantity);

        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원"); // (d)
    }

    public void plusButtonClicked(View view) {
        mQuantity++;
        mQuantityTextView.setText("" + mQuantity);

        mPriceTextView.setText(mFormat.format(mQuantity * 3000) + "원"); // (e)

    }
}