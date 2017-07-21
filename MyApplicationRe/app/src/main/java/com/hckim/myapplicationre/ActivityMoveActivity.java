package com.hckim.myapplicationre;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMoveActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1000;
    public static final int REQUEST_CODE_AGE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        View.OnClickListener listener = new MyClickListener(); // (3) 객체 만들어야 함. android.view.View 선택 클릭해야 함. (5)'
//        View.OnClickListener listener2 = new MyClickListener2(); // (6)'' 하나 더에 따름
//        View.OnClickListener listener2 = new View.OnClickListener() { // new 다음 OnClickListener Enter // B(1)
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(ActivityMoveActivity.this, "잘 된다", Toast.LENGTH_SHORT).show(); // B(2)
//            }
//        }; // B(2) ; 무명 클래스

        Button button = (Button) findViewById(R.id.coffee_button); // (1) on click 외 다른 방법 레퍼런스 가져와서
        button.setOnClickListener(listener); // (2) 전역변수로 빼지 않고 여기에. set. () 안 OnClickListener라는 객체를 받는다 (5)'' listener 삽입
        // Xml on click하고 메소드 이름 적은 것과 같은 것

//        Button button2 = (Button) findViewById(R.id.button2); // (6) 하나 더
////        button2.setOnClickListener(listener2);
//        button2.setOnClickListener(new View.OnClickListener() { // B(4) new하고 OnClickListener Enter
        findViewById(R.id.basketball_button).setOnClickListener(new View.OnClickListener() { // B(6) 코드로 하는 가장 간단한 방법. cf. Xml on click 방법
            @Override
            public void onClick(View view) {
//                Toast.makeText(ActivityMoveActivity.this, "잘 된다", Toast.LENGTH_SHORT).show(); // B(5): B(2)과 B(1) 6줄 없앰 B(6)'
                // 의도
                Intent intent = new Intent(ActivityMoveActivity.this, ScoreboardReActivity.class);
                startActivity(intent); // intent에 new Intent(ActivityMoveActivity.this, ScoreboardReActivity.class) 넣어도 됨
            }
        });

        findViewById(R.id.send_data_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "축하합니다";
                Intent intent = new Intent(ActivityMoveActivity.this, TargetActivity.class);
                intent.putExtra("data", message);
//                startActivity(intent); // C(1) 데이터만 보내려고 할 때
                startActivityForResult(intent, REQUEST_CODE_AGE); // C(2) 데이터를 보내고 결과를 받으려고 할 때
            }
        });
    }

    // startActivityForResult 결과 받는 곳
    @Override // D(1) onac... Enter
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_AGE && resultCode == RESULT_OK && data != null) { // D(2) 예
            int age = data.getIntExtra("age", 0);
            Toast.makeText(this, "" + age, Toast.LENGTH_SHORT).show();
        }
    }

    //    class MyClickListener implements View.OnClickListener { // (4) OnClickListener는 인터페이스. onClick 메소드 구현해야

    class MyClickListener implements View.OnClickListener { // (5) Alt Enter -> method Override됨

        @Override
        public void onClick(View view) {
            Toast.makeText(ActivityMoveActivity.this, "잘 되나", Toast.LENGTH_SHORT).show(); // (5)''끼지 결과 여기가 호출되어야. Toast로 확인
        }
    }

//    class MyClickListener2 implements View.OnClickListener { // (6)' 하나 더에 따름

//        @Override
//        public void onClick(View view) {
//            Toast.makeText(ActivityMoveActivity.this, "잘 된다", Toast.LENGTH_SHORT).show(); // B(3)
//        }
//    }
}

/*
OnClickListener commit push
 */


