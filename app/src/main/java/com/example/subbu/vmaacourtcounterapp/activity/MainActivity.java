package com.example.subbu.vmaacourtcounterapp.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.subbu.vmaacourtcounterapp.model.AACountViewModel;
import com.example.subbu.vmaacourtcounterapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Tracks the score for Team A
    int scoreTeamA = 0;

    // Tracks the score for Team B
    int scoreTeamB = 0;

    @BindView(R.id.btnAthreeponts)
    Button btnAthreeponts;
    @BindView(R.id.btnAtwoponts)
    Button btnAtwoponts;
    @BindView(R.id.btnAfreeponts)
    Button btnAfreeponts;

    @BindView(R.id.btnBthreeponts)
    Button btnBthreeponts;
    @BindView(R.id.btnBtwoponts)
    Button btnBtwoponts;
    @BindView(R.id.btnBfreeponts)
    Button btnBfreeponts;

    @BindView(R.id.btnreset)
    Button btnreset;

    @BindView(R.id.teamA)
    TextView teamA;
    @BindView(R.id.teamB)
    TextView teamB;

    @BindView(R.id.team_a_score)
    TextView team_a_score;
    @BindView(R.id.team_b_score)
    TextView team_b_score;

    AACountViewModel viewModel;


    //Button btnAtwoponts,btnAfreeponts,btnBthreeponts,btnBtwoponts,btnBfreeponts,btnreset;
    // TextView teamA,teamB,team_a_score,team_b_score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(AACountViewModel.class);

        displayForTeamA(viewModel.getScoreTeamA());
        displayForTeamB(viewModel.getScoreTeamB());


    }

    /**
     * Increase the score for Team A by 1 point.
     */

  /*  @OnClick(R.id.increment_button)
    public void incrementClickCount(View button) {
        viewModel.setCount(viewModel.getCount() + 1);
        displayClickCount(viewModel.getCount());
    }*/
    @OnClick(R.id.btnAthreeponts)
    public void addThreeForTeamA(View v) {
        scoreTeamA = viewModel.getScoreTeamA() + 3;
        viewModel.setScoreTeamA(scoreTeamA);
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */

    @OnClick(R.id.btnAtwoponts)
    public void addTwoForTeamA(View v) {
        scoreTeamA = viewModel.getScoreTeamA() + 2;
        viewModel.setScoreTeamA(scoreTeamA);
        //scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    @OnClick(R.id.btnAfreeponts)
    public void addOneForTeamA(View v) {
        scoreTeamA = viewModel.getScoreTeamA() + 1;
        viewModel.setScoreTeamA(scoreTeamA);
        //scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

   /* public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }*/


    /**
     * Increase the score for Team B by 3 point.
     */
    @OnClick(R.id.btnBthreeponts)
    public void addThreeForTeamB(View v) {
        scoreTeamB = viewModel.getScoreTeamB() + 3;
        viewModel.setScoreTeamB(scoreTeamB);
        displayForTeamB(scoreTeamB);
    }


    /**
     * Increase the score for Team B by 2 points.
     */
    @OnClick(R.id.btnBtwoponts)
    public void addTwoForTeamB(View v) {
        scoreTeamB = viewModel.getScoreTeamB() + 2;
        viewModel.setScoreTeamB(scoreTeamB);
        displayForTeamB(scoreTeamB);
    }
    /**
     * Increase the score for Team B by 1 points.
     */
    @OnClick(R.id.btnBfreeponts)
    public void addOneForTeamB(View v) {
        scoreTeamB = viewModel.getScoreTeamB() + 1;
        viewModel.setScoreTeamB(scoreTeamB);
        displayForTeamB(scoreTeamB);
    }


    /**
     * Resets the score for both teams back to 0.
     */
    @OnClick(R.id.btnreset)
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}
