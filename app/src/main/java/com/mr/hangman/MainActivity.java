package com.mr.hangman;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int current_sound = 0;
    private MediaPlayer buttonPlayer;
    private int pom = 0;
    private static String current_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //losowanie obrazka
        Random rand = new Random();
        int a = rand.nextInt(16);
        final ImageView obraz = findViewById(R.id.image_v);
        switch(a){
            case 0: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_1));break;
            case 1: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_2));break;
            case 2: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_3));break;
            case 3: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_4));break;
            case 4: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_5));break;
            case 5: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_6));break;
            case 6: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_7));break;
            case 7: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_8));break;
            case 8: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_9));break;
            case 9: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_10));break;
            case 10: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_11));break;
            case 11: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_12));break;
            case 12: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_13));break;
            case 13: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_14));break;
            case 14: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_15));break;
            case 15: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_16));break;
            default: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_1));break;
        }
        //losowanie obrazka
    //wyświetlenie imienia
        TextView name = findViewById(R.id.text_v);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(intent.getStringExtra("MESSAGE")==null){
            name.setText(getResources().getString(R.string.name));
        }
        else{
            String getName = (String) bd.get("MESSAGE");
            name.setText(getName);
            current_name = getName;
        }
    //wyświetlenie imienia
        //pause/start music
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pom==1){
                    onPause();
                }
                else
                    onResume();
            }
        });
        //pause/start music

//obsługa buttonów i nowe intencje
       Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent2 = new Intent(getApplicationContext(), Main2Activity.class);
                buttonPlayer.stop();
                startIntent2.putExtra("MESSAGE", current_name);
                startIntent2.putExtra("sound", current_sound);
                startActivity(startIntent2);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent startIntent3 = new Intent(getApplicationContext(), Main3Activity.class);
                buttonPlayer.stop();
                startIntent3.putExtra("MESSAGE", current_name);
                startIntent3.putExtra("sound", current_sound);
                startActivity(startIntent3);
            }
        });
        //obsługa buttonów i nowe intencje
    }


//funkcje mediaplayer
    //@Override
    protected void onPause(){
        super.onPause();
        buttonPlayer.pause();
        pom=0;
    }

  //  @Override
    protected void onResume(){

        super.onResume();
        //zwracanie wybranej piosenki z Intent 3
        Intent intent3 = getIntent();
        Bundle bd = intent3.getExtras();
        if(bd==null){
            switch(current_sound){
                case 0: buttonPlayer = MediaPlayer.create(this, R.raw.ring01); break;
                case 1: buttonPlayer = MediaPlayer.create(this, R.raw.ring02); break;
                case 2: buttonPlayer = MediaPlayer.create(this, R.raw.ring03); break;
                case 3: buttonPlayer = MediaPlayer.create(this, R.raw.ring04); break;
                default: buttonPlayer = MediaPlayer.create(this, R.raw.mario); break;
            }
        }
        else{
            current_sound = intent3.getIntExtra("sound", current_sound);

            switch(current_sound){
                case 0: buttonPlayer = MediaPlayer.create(this, R.raw.ring01); break;
                case 1: buttonPlayer = MediaPlayer.create(this, R.raw.ring02); break;
                case 2: buttonPlayer = MediaPlayer.create(this, R.raw.ring03); break;
                case 3: buttonPlayer = MediaPlayer.create(this, R.raw.ring04); break;
                default: buttonPlayer = MediaPlayer.create(this, R.raw.mario); break;
            }
        }
        buttonPlayer.start();
        buttonPlayer.setLooping(true);
        pom=1;
        //zwracanie wybranej piosenki z Intent 3

    }

  //  @Override
    protected void onStop(){
        super.onStop();
        buttonPlayer.release();
    }

    //funkcje mediaplayer
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
