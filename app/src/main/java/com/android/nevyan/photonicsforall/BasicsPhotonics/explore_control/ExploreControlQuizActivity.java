package com.android.nevyan.photonicsforall.BasicsPhotonics.explore_control;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.nevyan.photonicsforall.quiz_tools.DataLoader;
import com.android.nevyan.photonicsforall.quiz_tools.Question;
import com.android.nevyan.photonicsforall.quiz_tools.QuizDisplay;
import com.android.nevyan.photonicsforall.R;
import com.parse.ParseObject;

import java.util.ArrayList;
import java.util.List;


public class ExploreControlQuizActivity extends AppCompatActivity {
    List<Question> questList = new ArrayList<Question>();
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int i;
    TextView question;
    RadioButton radioA;
    RadioButton radioB;
    RadioButton radioC;
    RadioButton radioD;
    TextView btn;
    private int score;
    List<ParseObject> ob;
    Toast toast;
    View layoutToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        prepareUI();
        // Execute RemoteDataTask AsyncTask

        new RemoteDataTask().execute();

    }
    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, List<Question>> {

        @Override
        protected List<Question> doInBackground(Void... params) {

            ob = DataLoader.loadData("ExploreControl");
            questList =DataLoader.loadQuestionAnswer(questList,ob);


            return questList;
        }

        @Override
        protected void onPostExecute(List<Question> result) {

            displayQuestionAnswer();


        }
    }

    private void LoadColor(LinearLayout Ll) {
        Ll.setBackgroundColor(getResources().getColor(R.color.blue_l2));
    }

    private void displayQuestionAnswer() {


        //Load the next question with answers
        Question quest=questList.get(0);

        //Display the questions
        question.setText(quest.getQUESTION());
        radioA.setText(quest.getOPTA());
        radioB.setText(quest.getOPTB());
        if(quest.getOPTC()!="")
        {
            radioC.setVisibility(View.VISIBLE);
            radioC.setText(quest.getOPTC());
        }
        else
            radioC.setVisibility(View.GONE);
        if(quest.getOPTD()!="")
        {
            radioD.setVisibility(View.VISIBLE);
            radioD.setText(quest.getOPTD());
        }
        else
            radioD.setVisibility(View.GONE);


    }
    public void onRadioButtonClicked(View view) {

        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        // get selected radio button from radioGroup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);
        Question quest = questList.get(i);
        saveScore(quest, radioButton);
        radioA.setChecked(false);
        radioB.setChecked(false);
        radioC.setChecked(false);
        radioD.setChecked(false);
        QuizDisplay.toastAnswer(quest,toast,layoutToast,this);
        if(i == questList.size()-1) {

            DisplayScore();

        }

        else
            nextQuestion();

        /*Toast.makeText(ExploreControlQuizActivity.this,
                radioButton.getText(), Toast.LENGTH_SHORT).show();*/
    }


    public void saveScore(Question quest,RadioButton radioButton)
    {
        if(radioButton.getText().toString().equalsIgnoreCase(quest.getANSWER()))
        {
            score++;
        }

    }
    public void nextQuestion()
    {
        i++;
        //Load the next question with answers
        Question quest=questList.get(i);

        //Display the questions
        question.setText(quest.getQUESTION());
        radioA.setText(quest.getOPTA());
        radioB.setText(quest.getOPTB());
        if(quest.getOPTC()!="")
        {
            radioC.setVisibility(View.VISIBLE);
            radioC.setText(quest.getOPTC());
        }
        else
            radioC.setVisibility(View.GONE);
        if(quest.getOPTD()!="")
        {
            radioD.setVisibility(View.VISIBLE);
            radioD.setText(quest.getOPTD());
        }
        else
            radioD.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explore_control_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onCLKback(View view){
        finish();
    }
    public void DisplayScore()
    {
        radioA.setVisibility(View.GONE);
        radioB.setVisibility(View.GONE);
        radioC.setVisibility(View.GONE);
        radioD.setVisibility(View.GONE);
        question.setText(getString(R.string.your_score_is) + " " + score + "/" + (questList.size()));
        btn.setVisibility(View.VISIBLE);
    }
    public void prepareUI()
    {
        btn=(TextView)findViewById(R.id.btn_next_valid);
        btn.setText(getString(R.string.back_to_menu));
        btn.setVisibility(View.GONE);
        question =(TextView) findViewById(R.id.questionTV);
        radioA = (RadioButton) findViewById(R.id.radio_a);
        radioB = (RadioButton) findViewById(R.id.radio_b);
        radioC = (RadioButton) findViewById(R.id.radio_c);
        radioD = (RadioButton) findViewById(R.id.radio_d);
        getSupportActionBar().hide();
        LinearLayout Ll=(LinearLayout) findViewById(R.id.QuizLl);
        LoadColor(Ll);
        LayoutInflater inflater = getLayoutInflater();
        layoutToast = inflater.inflate(R.layout.toast_layout,(ViewGroup) findViewById(R.id.toast_layout_root));
    }


}
