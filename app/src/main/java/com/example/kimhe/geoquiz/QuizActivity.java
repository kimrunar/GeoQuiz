package com.example.kimhe.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans,true),
            new TrueFalse(R.string.question_africa,false),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_americas,true),
            new TrueFalse(R.string.question_asia,true),
    };

    private int mCurrentIndex = 0;

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getmQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismTrueQuestion();
        int messageResId = 0;

        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"OnCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view);


        mTrueButton = (Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true);
            }
        });
        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
            }
        });

        mNextButton = (Button)findViewById(R.id.next_button);
            mNextButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mCurrentIndex = (mCurrentIndex +1) % mQuestionBank.length;
                    updateQuestion();
                }
            });
            updateQuestion();
        }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"OnStart() called");
    }

    @Override
    public void onPause(){
        super.onStart();
        Log.d(TAG,"OnPause() called");
    }

    @Override
    public void onResume(){
        super.onStart();
        Log.d(TAG,"OnResume() called");
    }


    @Override
    public void onStop(){
        super.onStart();
        Log.d(TAG,"OnStop() called");
    }


    @Override
    public void onDestroy(){
        super.onStart();
        Log.d(TAG,"OnDestroy() called");
    }
    //TODO
    //Page 45 "Adding ikon"


    }

