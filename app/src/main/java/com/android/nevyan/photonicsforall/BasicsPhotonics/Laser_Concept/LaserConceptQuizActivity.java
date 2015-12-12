package com.android.nevyan.photonicsforall.BasicsPhotonics.Laser_Concept;

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

import java.util.ArrayList;
import java.util.List;

public class LaserConceptQuizActivity extends AppCompatActivity {
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
    Toast toast;
    View layoutToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        prepareUI();
        loadQuestionAnswer();
    }

    private void LoadColor(LinearLayout Ll) {
        Ll.setBackgroundColor(getResources().getColor(R.color.blue_l2));
    }

    private void loadQuestionAnswer() {
        question=(TextView)findViewById(R.id.questionTV);
        btn=(TextView)findViewById(R.id.btn_next_valid);
        btn.setVisibility(View.GONE);

        score=0;
        Question Q1;
        Question Q2;
        Question Q3;

        if (DataLoader.getLanguage() == "fr") {
            Q1= new Question("Quelle émission permet la création d’un laser? ","Émission spontanée"
                    ,"Absorption","Émission stimulée","Émission stimulée");
            Q2= new Question("Comment se propage la lumière d’un laser ? ","Parallèle et rectiligne","Perpendiculaire à la source"
                    ,"Parallèle et rectiligne");
            Q3= new Question("Qu’est-ce que l’effet laser ?","La fusion de plusieurs faisceaux laser"
                    ,"Une cascade d’émission stimulée","Une cascade d’émission stimulée");
        } else {
            Q1= new Question("What is the emission for creating a laser? ","spontaneous emission"
                    ,"Absorption","stimulated emission","stimulated emission");
            Q2= new Question("How spreads the light from a laser? ","Parallel and straight","Perpendicular to the source"
                    ,"Parallel and straight");
            Q3= new Question("What is the laser effect?","Merging multiple laser beams"
                    ,"Stimulated emission of waterfall","Stimulated emission of waterfall");
        }

        questList.add(Q1);
        questList.add(Q2);
        questList.add(Q3);
        radioA = (RadioButton) findViewById(R.id.radio_a);
        radioB = (RadioButton) findViewById(R.id.radio_b);
        radioC = (RadioButton) findViewById(R.id.radio_c);
        radioD = (RadioButton) findViewById(R.id.radio_d);
        radioD.setVisibility(View.GONE);

        question.setText(Q1.getQUESTION());
        radioA.setText(Q1.getOPTA());
        radioB.setText(Q1.getOPTB());
        radioC.setText(Q1.getOPTC());
        i=0;
        btn.setText("Back");

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
        QuizDisplay.toastAnswer(quest, toast, layoutToast, this);
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
        radioC.setText(quest.getOPTC());
        if(quest.getOPTC()!="") {
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
    public void DisplayScore()
    {
        radioA.setVisibility(View.GONE);
        radioB.setVisibility(View.GONE);
        radioC.setVisibility(View.GONE);
        radioD.setVisibility(View.GONE);
        question.setText("Votre Score est de "+score+"/"+(questList.size()));
        btn.setVisibility(View.VISIBLE);
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