package com.mr.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Main3Activity extends AppCompatActivity {

    private int selected_sound = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    //obsługa buttonów
        Button button6 = (Button) findViewById(R.id.button6);//OK
        button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = getIntent();
                Bundle bd = intent.getExtras();
                String current_name = (String)bd.get("MESSAGE");
                Intent startIntent1 = new Intent(getApplicationContext(), MainActivity.class);
                startIntent1.putExtra("sound", selected_sound);
                startIntent1.putExtra("MESSAGE", current_name);
                startActivity(startIntent1);
            }
        });

        Button button5 = (Button) findViewById(R.id.button5);//CANCEL
        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = getIntent();
                Bundle bd = intent.getExtras();
                int current_sound = (int)bd.get("sound");
                String current_name = (String)bd.get("MESSAGE");
                Intent startIntent1 = new Intent(getApplicationContext(), MainActivity.class);
                startIntent1.putExtra("sound", current_sound);
                startIntent1.putExtra("MESSAGE", current_name);
                startActivity(startIntent1);
            }
        });
    }
    //obsługa buttonów
    //wybór dźwięku - RadioButton
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
    }//wybór dźwięku - RadioButton
}
