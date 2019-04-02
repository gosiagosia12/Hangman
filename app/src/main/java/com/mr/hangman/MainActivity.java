package com.mr.hangman;

import android.content.Intent;
import android.media.AudioManager;
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

    private int current_sound = 1;
    private MediaPlayer buttonPlayer;
    private int pom = 0;
    public String current_name = "";
    public static final int CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        buttonPlayer = new MediaPlayer();
        buttonPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
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
            case 13: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_15));break;
            case 14: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_16));break;
            default: obraz.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.avatar_1));break;
        }

        buttonPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mp){
                mp.start();
            }
        });

        buttonPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                mp.start();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(pom){
                    case 0:
                        buttonPlayer.stop();
                        pom=1;
                        break;
                    case 1:
                        onResume();
                        pom=0;
                }
            }
        });

       Button button1 = (Button) findViewById(R.id.button1);//contact
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonPlayer.stop();
                Intent startIntent2 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivityForResult(startIntent2, CONTACT_REQUEST);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);//sound
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                buttonPlayer.stop();
                Intent startIntent3 = new Intent(getApplicationContext(), Main3Activity.class);
                startActivityForResult(startIntent3, CONTACT_REQUEST);
            }
        });
    }

    protected void onResume(){

        super.onResume();
        switch(current_sound){
            case 0: buttonPlayer = MediaPlayer.create(this, R.raw.ring01); break;
            case 1: buttonPlayer = MediaPlayer.create(this, R.raw.ring02); break;
            case 2: buttonPlayer = MediaPlayer.create(this, R.raw.ring03); break;
            case 3: buttonPlayer = MediaPlayer.create(this, R.raw.ring04); break;
            default: buttonPlayer = MediaPlayer.create(this, R.raw.mario); break;
        }
        buttonPlayer.start();
        buttonPlayer.setLooping(true);
        pom=0;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            int id = (int) data.getIntExtra("ID", 0);
            switch(id){
                case 2:
                    current_name = data.getStringExtra("MESSAGE");
                    TextView name = findViewById(R.id.text_v);
                    if(current_name == null){
                        name.setText(getResources().getString(R.string.name));
                    }
                    else{
                        name.setText(current_name);
                    }
                    break;
                case 3:
                    current_sound = data.getIntExtra("sound", 0);
                    break;
            }
        }
        else if(resultCode == RESULT_CANCELED) {}
    }

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