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
import pl.droidsonroids.gif.GifImageView;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.text.DecimalFormat;
import java.util.Random;

public class DreamsAndNightmares extends AppCompatActivity {

    private UserDAO userDAO;
    UserDatabase userDatabase;
    private long userID;
    double skinVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreams_and_nightmares);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        Button SpinButton = findViewById(R.id.dreamsandnightmaresbutton);
        TextView name = findViewById(R.id.skinname);
        ImageView Case = (ImageView) findViewById(R.id.dreamsandnightmarescase);
        GifImageView gifImageView = findViewById(R.id.dreamsnightmaresanim);
        MediaPlayer mySound = MediaPlayer.create(DreamsAndNightmares.this, R.raw.casesound);

        userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        userDAO = userDatabase.userDAO();

        // Initialize userID with the value from the intent
        userID = getIntent().getLongExtra("userID", -1);
        if (userID == -1) {
            // Handle invalid userID, perhaps show an error message or finish the activity
            // For now, just log an error message
            Log.e("DreamsAndNightmares", "Invalid userID");
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
                            int j = r.nextInt(3); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.dn__adopplerbutterflyknife3000); //
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Butterfly Knife | Gamma Doppler $2500");
                                    skinVal = 2500;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.dn__klaminatefalchionknife155); //
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Falchion Knife | Black Laminate $211");
                                    skinVal = 211;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.dn__tronicbowieknife221); //
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    name.setText("★ Bowie Knife | Autotronic $483");
                                    skinVal = 483;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_dreams_and_nightmares); // it broke
                                    break;
                            }

                        } else if (i > 991) {   // red
                            int j = r.nextInt(2); // pick the knifes
                            switch(j) {
                                case 0:
                                    Case.setImageResource(R.drawable.dn__7nightwish50);    //
                                    constraintLayout.setBackgroundResource(R.drawable.redsplash);
                                    name.setText("AK-47 | Nightwish $88");
                                    skinVal = 88;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.dn__lightprotector50); //
                                    constraintLayout.setBackgroundResource(R.drawable.redsplash);
                                    name.setText("MP9 | Starlight Protector $23");
                                    skinVal = 23;
                                    addToNetWorth();
                                    break;
                            }

                        } else if (i > 959) {   // pink
                            int j = r.nextInt(2); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.dn__deyemovement10);    //
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    name.setText("FAMAS | Rapid Eye Movement $9");
                                    skinVal = 9;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.dn__ndrama10); //
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    name.setText("Dual Berettas | Melondrama $9");
                                    skinVal = 9;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_dreams_and_nightmares); // it broke
                                    break;
                            }

                        } else if (i > 800) {   // purple
                            int j = r.nextInt(3); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.dn__tterror3);   //
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("M4A1-S | Night Terror $2");
                                    skinVal = 2;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.dn__ettohell3_5); //
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("USP-S | Ticket to Hell $2");
                                    skinVal = 2;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.dn__ecat1_5); // $
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    name.setText("PP-Bizon | Space Cat $1");
                                    skinVal = 1;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_dreams_and_nightmares); // it broke
                                    break;
                            }
                        } else{                 // blue
                            int j = r.nextInt(3); // pick the knifes
                            switch(j){
                                case 0:
                                    Case.setImageResource(R.drawable.dn__itboard4_5); //
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("Sawed-Off | Spirit Board $0.25");
                                    skinVal = 0.25;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.dn__sight35); // $0.20
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("MAG-7 | Foresight $0.20");
                                    skinVal = 0.2;
                                    addToNetWorth();
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.scar20_poultrygeist_35); //
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    name.setText("SCAR-20 | Poultrygeist $0.20");
                                    skinVal = 0.2;
                                    addToNetWorth();
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_dreams_and_nightmares); // it broke
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
                    user.setNumDreamsAndNightmaresOpened(user.getNumDreamsAndNightmaresOpened() + 1);
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

    public void back3(View view)    {
        Intent intent = new Intent(this, CaseSelection.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

}