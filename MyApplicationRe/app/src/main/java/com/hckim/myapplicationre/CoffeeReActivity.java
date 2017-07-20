package com.hckim.myapplicationre;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CoffeeReActivity extends AppCompatActivity {

    public static final int MIN_QUANTITY = 1; // 상수로 바꿀 때 새로 생김
    public static final int DEFAULT_QUANTITY = 1; // 상수로 바꿀 때 새로 생김
    public static final int COFFEE_PRICE = 3000;

    private TextView mQuantityTextView; // 로컬 변수로 전역 변수로 바꿈
    private TextView mPriceTextView; // (b)
    private CheckBox mWhippedCreamCheckBox;
    private EditText mNameEditText;
    private int mQuantity = DEFAULT_QUANTITY; // 메소드에서 1을 내리고 올리기 위해 변수 필요
    // 1을 상수로 바꿈

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
//        mQuantityTextView.setText(String.valueOf(mQuantity)); // 또 다른 방법

//        mQuantityTextView.setText("" + mQuantity); // mQuantity만 있으면 빨간줄
//        mPriceTextView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // (c)
        // 두 줄 메소드로 FInd Action method

        mWhippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check);
        mNameEditText = (EditText) findViewById(R.id.name_edit);

        display();
    }

    private void display() { // 아래 두 줄을 display() 메소드로 바꿈
        mQuantityTextView.setText("" + mQuantity); // mQuantity만 있으면 빨간줄
        String message = "주문자: " + mNameEditText.getText().toString();
        message += "\n====================";
        message += "\n휘핑 크림 추가 여부: " + mWhippedCreamCheckBox.isChecked();
        message += "\n갯수: " + mQuantity;
        message += "\n가격: " + mFormat.format(mQuantity * COFFEE_PRICE) + "원";

//        mPriceTextView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // (c)
        mPriceTextView.setText(message);
    }

    // (2)'
    public void minusButtonClicked(View view) {
//        Toast.makeText(this, "잘 눌림", Toast.LENGTH_SHORT).show(); // 화면 확인
        mQuantity--;
        if (mQuantity < MIN_QUANTITY) { // 최소 수량 1을 상수인 MIN_QUANTITY로 Find Action constant
            mQuantity = MIN_QUANTITY;
        }
//        mQuantityTextView.setText("" + mQuantity);
//        mPriceTextView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // (d)
        display();
    }

    public void plusButtonClicked(View view) {
        mQuantity++;

//        mQuantityTextView.setText("" + mQuantity);
//        mPriceTextView.setText(mFormat.format(mQuantity * COFFEE_PRICE) + "원"); // (e)
        display();

    }

    public void onCheckBoxClicked(View view) {
//        CheckBox checkBox = (CheckBox) view;
//
//        if (checkBox.isChecked()) {
//
//        } else {
//
//        }
        display();
    }
}