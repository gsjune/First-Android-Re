package com.hckim.myapplicationre.fragment.basketball;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hckim.myapplicationre.R;

/**
 * Created by K on 2017-08-01.
 */

public class BasketballScoreFragment extends Fragment implements View.OnClickListener {
    private TextView mScoreTextView;
    private TextView mTeamNameTextView; // (8)''' (8)"의 결과
    private int mScore; // (5)

//    // 방법 1: 뷰를 만드는 곳
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
////        return inflater.inflate(R.layout.fragment_score, container, false); // (1) inflater~false) 드래그 Find Action variable Enter
//        View view = inflater.inflate(R.layout.fragment_score, container, false); // (1)' (1)의 결과
//        mScoreTextView = (TextView) view.findViewById(R.id.score_text); // (2)
//        return view; // (1)'' (1)의 결과
//    }

    // 방법 2: 뷰가 다 만들어진 다음 호출되는 곳
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_score, container, false); // (1) inflater~false) 드래그 Find Action variable Enter
//        View view = inflater.inflate(R.layout.fragment_score, container, false); // (1)' (1)의 결과
//        mScoreTextView = (TextView) view.findViewById(R.id.score_text); // (2)
//        return view; // (1)'' (1)의 결과
    }

    @Override // 방법 2
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mScoreTextView = (TextView) view.findViewById(R.id.score_text); // (2)
        mTeamNameTextView = (TextView) view.findViewById(R.id.team_name_text); // (8)'와 (8)''(Alt Enter Create field...)
        view.findViewById(R.id.button_1).setOnClickListener(this); // (3) this Alt Enter ...implement... Enter
        view.findViewById(R.id.button_2).setOnClickListener(this); // (3)' this Alt Enter ...implement... Enter
        view.findViewById(R.id.button_3).setOnClickListener(this); // (3)" this Alt Enter ...implement... Enter

        if (savedInstanceState != null) { // B(2)
            mScore = savedInstanceState.getInt("score");
            mScoreTextView.setText("" + mScore);
        }
    }

    @Override // B(1)
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("score", mScore);
        super.onSaveInstanceState(outState);
    }

    @Override // (4) (3)의 결과
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                mScore++; // (6)
                break;
            case R.id.button_2:
                mScore += 2; // (6)'
                break;
            case R.id.button_3:
                mScore += 3; // (6)"
                break;
        }
        mScoreTextView.setText("" + mScore);
    }

    public void reset() { // (7)
        mScore = 0;
        mScoreTextView.setText("" + mScore);
    }

    public void setTeamName(String name) { // (8)
        mTeamNameTextView.setText(name);
    }
}
