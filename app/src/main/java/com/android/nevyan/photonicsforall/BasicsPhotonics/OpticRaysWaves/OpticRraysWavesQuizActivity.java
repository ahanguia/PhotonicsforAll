package com.android.nevyan.photonicsforall.BasicsPhotonics.OpticRaysWaves;

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


public class OpticRraysWavesQuizActivity extends AppCompatActivity {
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
        loadQuestionAnswer();
        prepareUI();
    }

    private void LoadColor(LinearLayout Ll) {
        Ll.setBackgroundColor(getResources().getColor(R.color.blue_l2));
    }

    private void loadQuestionAnswer() {
        question=(TextView)findViewById(R.id.questionTV);
        btn=(TextView)findViewById(R.id.btn_next_valid);
        btn.setVisibility(View.GONE);
        Question Q1;
        Question Q2;
        Question Q3;

        if(DataLoader.getLanguage()=="fr"){
            Q1= new Question("Lequel caractérise le modèle de la lumière?","La lumière est une particule."
                    ,"Lumière est une onde.","Lumière est une onde et une particule.",
                    "Lumière est une onde.");
            Q2= new Question("Quelles sont les caractéristiques de la lumière blanche? ","Elle contient les couleurs primaires et secondaires qui composent le domaine visible"
                    ,"Elle contient seulement les couleurs primaires qui ne composent pas le domaine visible","Elle contient les couleurs primaires et secondaires qui  ne composent pas le domaine visible",
                    "Elle contient les couleurs primaires et secondaires qui composent le domaine visible");
            Q3= new Question("Que ce passe t’il lorsqu’un atome passe de l’état supérieur n = 2 à l'état fondamental n = 1 ?","L'atome a de l'énergie plus élevée et un photon est absorbé"
                    ,"L'atome a une énergie inférieure et un photon est émis.","L'atome ne change pas et un photon est émis.","L'atome a une énergie inférieure et un photon est émis.");
        }
        else
        {
            Q1= new Question("Which characterizes the model of light?","The light is a particle."
                    ,"Light is a wave.","Light is a wave and a particle.",
                    "Light is a wave.");
            Q2= new Question("What are the characteristics of white light? ","It contains the primary and secondary colors that make up the visible range"
                    ,"Beautiful contains only the primary colors that do not compensate the visible range","It contains the primary and secondary colors that do not make up the visible range",
                    "It contains the primary and secondary colors that do not make up the visible range");
            Q3= new Question("What happens  when an atom of higher state n = 2 ground state n = 1?","The atom has the highest energy and a photon is absorbed"
                    ,"The atom has a lower energy and a photon is emitted.","The atom does not change and a photon is emitted.","The atom does not change and a photon is emitted.");

        }
        score=0;
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