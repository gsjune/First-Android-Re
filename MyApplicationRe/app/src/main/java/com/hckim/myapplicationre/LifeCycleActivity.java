package com.hckim.myapplicationre;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LifeCycleActivity extends AppCompatActivity {

    private static final String TAG = LifeCycleActivity.class.getSimpleName(); // (2)

    private int mNum = 0; // B(1)
    private Button mButton; // C(3)

    // 액티비티 실행될 때
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        mButton = (Button) findViewById(R.id.number_button); // C(3)'

        // 초기화
        Log.d(TAG, "onCreate: "); // (1) Enter 후 Alt Enter 상수 만들기 Enter

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    // 재개, 화면이 보이기 직전
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");

        SharedPreferences setting = PreferenceManager.getDefaultSharedPreferences(this); // C(2) 복원
        mNum = setting.getInt("number", 0);

        mButton.setText("" + mNum); // C(4) 여기까지 복원

        Log.d(TAG, "onResume: 복원");
    }

    // 일시 정지, 화면에서 안 보이기 직전
    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this); // C(1) 저장
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("number", mNum);

        editor.apply();

        Log.d(TAG, "onPause: 저장");
    }

    // 정지, 화면에서 안 보이게 되면
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // 액티비티 종료될 때
    @Override
    protected void onDestroy() { // (3) ond... Enter
        super.onDestroy();

        // 메모리 해제
        Log.d(TAG, "onDestroy: "); // (4)
    }

    public void showDialog(View view) { // (5) xml에서 on click Alt Enter로
        AlertDialog.Builder builder = new AlertDialog.Builder(this); // (6)
        builder.setTitle("test");
        builder.setMessage("test");
        builder.show();
    }

    public void increment(View view) { // B(2) xml에서 on click Alt Enter로
        mNum++;
        ((Button) view).setText("" + mNum);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { // D(1)
        Log.d(TAG, "onSaveInstanceState: ");
        // 저장

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) { // D(2)
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");

        // 복원
    }
}

