package com.hckim.myapplicationre.fragment.color;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hckim.myapplicationre.R;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
    }

//    public void onCreateFragmentButtonClicked(View view) { // xml Alt Enter로부터
//        // 새로운 프래그먼트 생성
//
//        ColorFragment fragment = new ColorFragment();
//
//        // R.id.container 영역에 프래그먼트를 교체하겠다
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, fragment).commit();
//    }

//    public void onCreateRedFragmentButtonClicked(View view) { // l(3) xml onClick 후
//        ColorFragment fragment = new ColorFragment();
//        Bundle bundle = new Bundle(); // l(4)
//        bundle.putInt("color", Color.RED);
//        bundle.putString("name", "어쩌구");
//        fragment.setArguments(bundle);
    public void onCreateRedFragmentButtonClicked(View view) { // l(7)
        ColorFragment fragment = ColorFragment.newInstance(Color.RED);

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit(); // l(1)
    }

    public void onCreateBlueFragmentButtonClicked(View view) {
//        ColorFragment fragment = new ColorFragment();
        ColorFragment fragment = ColorFragment.newInstance(Color.BLUE); // l(7)'

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
    }

    public void onCreateYellowFragmentButtonClicked(View view) {
//        ColorFragment fragment = new ColorFragment();
        ColorFragment fragment = ColorFragment.newInstance(Color.YELLOW); // l(7)"

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
    }

    public void onCreateRandomFragmentButtonClicked(View view) { // 추가
        ColorFragment fragment = ColorFragment.newInstance(); // l(7)"

        // R.id.container 영역에 프래그먼트를 교체하겠다
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).commit();
    }
}
