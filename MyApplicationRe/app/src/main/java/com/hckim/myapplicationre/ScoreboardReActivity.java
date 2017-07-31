package com.hckim.myapplicationre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreboardReActivity extends AppCompatActivity {

    private TextView mScoreATextView;
    private TextView mScoreBTextView;
    private int mScoreA = 0;
    private int mScoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_re2);

        mScoreATextView = (TextView) findViewById(R.id.score_a_text); // mScoreATextView Alt Enter
        mScoreBTextView = (TextView) findViewById(R.id.score_b_text); // mScoreATextView 필드에 추가
    }

    public void threePointsAButtonClicked(View view) {
        mScoreA += 3;
        mScoreATextView.setText("" + mScoreA);
    }

    public void twoPointsAButtonClicked(View view) {
        mScoreA += 2;
        mScoreATextView.setText("" + mScoreA);
    }

    public void freeThrowAButtonClicked(View view) {
        mScoreA += 1;
        mScoreATextView.setText("" + mScoreA);
    }

    public void threePointsBButtonClicked(View view) {
        mScoreB += 3;
        mScoreBTextView.setText("" + mScoreB);
    }

    public void twoPointsBButtonClicked(View view) {
        mScoreB += 2;
        mScoreBTextView.setText("" + mScoreB);
    }

    public void freeThrowBButtonClicked(View view) {
        mScoreB += 1;
        mScoreBTextView.setText("" + mScoreB);
    }

    public void resetButtonClicked(View view) {
        mScoreA = 0;
        mScoreB = 0;
        mScoreATextView.setText("" + mScoreA);
        mScoreBTextView.setText("" + mScoreB);
    }

    @Override // D(1) cf. LifeCycleActivity.java
    protected void onSaveInstanceState(Bundle outState) {
        // 저장
        outState.putInt("a", mScoreA);
        outState.putInt("b", mScoreB);

        super.onSaveInstanceState(outState);
    }

    @Override // D(2)
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // 복원
        mScoreA = savedInstanceState.getInt("a");
        mScoreB = savedInstanceState.getInt("b");

        mScoreATextView.setText("" + mScoreA); // D(2)' 위에서 복사 붙여넣기
        mScoreBTextView.setText("" + mScoreB);
    }
}
