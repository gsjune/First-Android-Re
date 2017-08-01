package com.hckim.myapplicationre.fragment.basketball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hckim.myapplicationre.R;

public class BasketballActivity extends AppCompatActivity {

    private BasketballScoreFragment mATeamFragment;
    private BasketballScoreFragment mBTeamFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);


        mATeamFragment = (BasketballScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_a); // Cast...

        mBTeamFragment = (BasketballScoreFragment) getSupportFragmentManager().findFragmentById(R.id.frag_team_b);

        mBTeamFragment.setTeamName("Team B");
    }

    public void onResetButtonClicked(View view) { // xml onClick으로부터
        mATeamFragment.reset();
        mBTeamFragment.reset();
    }
}
