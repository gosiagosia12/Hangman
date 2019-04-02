package com.mr.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private String contact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //obsługa buttonów i nowa intencja (1 - MainActivity)
        Button button3 = (Button) findViewById(R.id.button3);//CANCEL
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = getIntent();
                Bundle bd = intent.getExtras();
                int sound_id = (int)bd.get("sound");
                String current_name = (String)bd.get("MESSAGE");
                Intent startIntent1 = new Intent(getApplicationContext(), MainActivity.class);
                startIntent1.putExtra("sound", sound_id);
                startIntent1.putExtra("MESSAGE", current_name);
                startActivity(startIntent1);
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);//OK
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
                Intent startIntent1 = new Intent(getApplicationContext(), MainActivity.class);
                String text = spinner.getSelectedItem().toString();
                    switch(text){
                        case "Krystian":
                            contact = "Krystian"; break;
                        case "Marta":
                            contact = "Marta"; break;
                        case "Dominika":
                            contact = "Dominika"; break;
                        case "Wojciech":
                            contact = "Wojciech"; break;
                        case "Stanislaw":
                            contact = "Stanislaw"; break;
                }
                Intent intent = getIntent();
                Bundle bd = intent.getExtras();
                int sound_id = (int)bd.get("sound");
                startIntent1.putExtra("sound", sound_id);
                startIntent1.putExtra("MESSAGE", contact);
                startActivity(startIntent1);
            }
        });//obsługa buttonów i nowa intencja (1 - MainActivity)
    }
}
