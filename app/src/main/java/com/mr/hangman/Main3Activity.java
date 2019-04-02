package com.mr.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity {

    private int selected_sound = 0;
    private static final int ID = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Button button6 = (Button) findViewById(R.id.button6);//OK
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =  new Intent();
                intent.putExtra("sound", selected_sound);
                intent.putExtra("ID", 3);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button5 = (Button) findViewById(R.id.button5);//CANCEL
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view)
    {
        boolean checked = ((RadioButton) view).isChecked();

        if(checked){
            switch(view.getId()){
                case R.id.sound1: selected_sound = 0; break;
                case R.id.sound2: selected_sound = 1; break;
                case R.id.sound3: selected_sound = 2; break;
                case R.id.sound4: selected_sound = 3; break;
                case R.id.sound5: selected_sound = 4; break;
                default: selected_sound = 0;
            }
        }
    }
}