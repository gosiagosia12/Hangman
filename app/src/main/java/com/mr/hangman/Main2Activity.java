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
    private static final int ID = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button3 = (Button) findViewById(R.id.button3);//CANCEL
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);//OK
        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Spinner spinner = (Spinner)findViewById(R.id.spinner);
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
                Intent intent =  new Intent();
                intent.putExtra("MESSAGE", contact);
                intent.putExtra("ID", 2);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}