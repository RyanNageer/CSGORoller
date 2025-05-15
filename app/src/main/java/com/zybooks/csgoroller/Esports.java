package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import android.widget.ImageView;
import pl.droidsonroids.gif.GifImageView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;
import java.util.Random;

public class Esports extends AppCompatActivity {

    private UserDAO userDAO;
    UserDatabase userDatabase;
    private long userID;
    double skinVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esports);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        Button SpinButton = findViewById(R.id.Esports);
        TextView name = findViewById(R.id.skinname);
        ImageView Case = (ImageView) findViewById(R.id.espcase);
        GifImageView gifImageView = findViewById(R.id.esportsanim);
        MediaPlayer mySound = MediaPlayer.create(Esports.this, R.raw.casesound);

        userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        userDAO = userDatabase.userDAO();

        // Initialize userID with the value from the intent
        userID = getIntent().getLongExtra("userID", -1);
        if (userID == -1) {
            // Handle invalid userID, perhaps show an error message or finish the activity
            // For now, just log an error message
            Log.e("Esports", "Invalid userID");
            finish(); // Close the activity
            return;
        }

        gifImageView.setVisibility(View.INVISIBLE);
        SpinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Case.setVisibility(View.INVISIBLE);
                name.setTextColor(Color.parseColor("#808080"));
                mySound.seekTo(0);
                mySound.start();
                constraintLayout.setBackgroundResource(0);
                new CountDownTimer(3600, 1000) {

                    public void onTick(long millisUntilFinished) {
                        name.setText("unboxing...");
                        gifImageView.setVisibility(View.VISIBLE);
                        SpinButton.setVisibility(View.INVISIBLE);
                    }

                    public void onFinish() {
                        SpinButton.setVisibility(View.VISIBLE);
                        gifImageView.setVisibility(View.INVISIBLE);
                        Case.setVisibility(View.VISIBLE);
                        name.setTextColor(Color.parseColor("#FFFFFF"));

                        Random r = new Random();
                        int i = r.nextInt(1000)+1; // raise the floor from 0 to 1, helps my logic

                        if(i >997){             // yellow
                            int j = r.nextInt(10); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.esp_yellow_case_hardened0); // $750
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bayonet | Case Hardened $750");
                                    skinVal = 750;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.esp_yellow_case_hardened1); // $450
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Flip Knife | Case Hardened $450");
                                    skinVal = 450;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.esp_yellow_fade0); // $1000
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Flip Knife | Fade $1000");
                                    skinVal = 1000;
                                    addToNetWorth();
                                    break;
                                case 3:
                                    Case.setImageResource(R.drawable.esp_yellow_fade1); // $1200
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bayonet | Fade $1200");
                                    skinVal = 1200;
                                    addToNetWorth();
                                    break;
                                case 4:
                                    Case.setImageResource(R.drawable.esp_yellow_night0); // $240
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Flip Knife | Night $240");
                                    skinVal = 240;
                                    addToNetWorth();
                                    break;
                                case 5:
                                    Case.setImageResource(R.drawable.esp_yellow_night1); // $400
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bayonet | Night $400");
                                    skinVal = 400;
                                    addToNetWorth();
                                    break;
                                case 6:
                                    Case.setImageResource(R.drawable.esp_yellow_slaughter0); // $600
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Flip Knife | Slaughter $600");
                                    skinVal = 600;
                                    addToNetWorth();
                                    break;
                                case 7:
                                    Case.setImageResource(R.drawable.esp_yellow_slaughter1); // $750
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bayonet | Slaughter $750");
                                    skinVal = 750;
                                    addToNetWorth();
                                    break;
                                case 8:
                                    Case.setImageResource(R.drawable.esp_yellow_vanilla_star0); // $440
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Flip Knife | Vanilla $440");
                                    skinVal = 440;
                                    addToNetWorth();
                                    break;
                                case 9:
                                    Case.setImageResource(R.drawable.esp_yellow_vanilla_star1); // $720
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bayonet | Vanilla $720");
                                    skinVal = 720;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_esports); // it broke
                                    break;
                            }

                        } else if (i > 991) {   // red
                            Case.setImageResource(R.drawable.esp_red_deathby_kitty); // $66
                            constraintLayout.setBackgroundResource(R.drawable.redsplash);
                            name.setText("P90 | Death By Kitty $66");
                            skinVal = 66;
                            addToNetWorth();

                        } else if (i > 959) {   // pink
                            int j = r.nextInt(2); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.esp_violet_boom);    // $444
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    name.setText("AWP | BOOM $444");
                                    skinVal = 444;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.esp_violet_red_laminate); // $800
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    name.setText("AK-47 | Red Laminate $76");
                                    skinVal = 76;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_esports); // it broke
                                    break;
                            }

                        } else if (i > 800) {   // purple
                            int j = r.nextInt(3); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.esp_purple_orange_ddpat0);   // $42
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("Sawed Off | Orange DDPAT $42");
                                    skinVal = 42;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.esp_purple_orange_ddpat1); // $52
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("Galil AR | Orange DDPAT $52");
                                    skinVal = 52;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.esp_purple_splash); // $50
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("P-250 | Splash $75");
                                    skinVal = 75;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_esports); // it broke
                                    break;
                            }
                        } else{                 // blue
                            int j = r.nextInt(3); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.esp_blue_doom_kitty); // $5
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("FAMAS | Doom Kitty $5");
                                    skinVal = 5;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.esp_blue_faded_zebra); // $43
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("M4A4 | Faded Zebra $43");
                                    skinVal = 43;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.esp_blue_memento); // $7.5
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("Mag-7 | Memento $7");
                                    skinVal = 7;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_esports); // it broke
                                    break;
                            }

                        }
                    }
                }.start();

                incrementRollCount();

            }
        });
    }

    private void incrementRollCount()   {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Retrieve the user from the database
                User user = userDAO.getUserById(userID);
                if (user != null) {
                    // Update the user's roll counts
                    user.setNumEsportsOpened(user.getNumEsportsOpened() + 1);
                    userDAO.updateUser(user);
                }
            }
        }).start();

    }

    private void addToNetWorth()   {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Retrieve the user from the database
                User user = userDAO.getUserById(userID);
                if (user != null) {
                    // Update the user's roll counts
                    double temp = user.getNetWorth() + skinVal;
                    DecimalFormat df = new DecimalFormat("#.##");
                    String temp2 = df.format(temp);
                    user.setNetWorth(Double.parseDouble(temp2));
                    userDAO.updateUser(user);
                }
            }
        }).start();

    }

    public void back3(View view){
        Intent intent = new Intent(this, CaseSelection.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

}