package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Kilowatt extends AppCompatActivity {

    private UserDAO userDAO;
    UserDatabase userDatabase;
    private long userID;
    double skinVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilowatt);
        ConstraintLayout constraintLayout = findViewById(R.id.constraintLayout);
        TextView name = findViewById(R.id.skinname);
        Button SpinButton = findViewById(R.id.kilowatt);
        GifImageView gifImageView = findViewById(R.id.kilowattanim);
        ImageView Case = (ImageView) findViewById(R.id.kwcase);
        MediaPlayer mySound = MediaPlayer.create(Kilowatt.this, R.raw.casesound);

        userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        userDAO = userDatabase.userDAO();

        // Initialize userID with the value from the intent
        userID = getIntent().getLongExtra("userID", -1);
        if (userID == -1) {
            // Handle invalid userID, perhaps show an error message or finish the activity
            // For now, just log an error message
            Log.e("Kilowatt", "Invalid userID");
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
                        int i = r.nextInt(1000) + 1; // raise the floor from 0 to 1, helps my logic

                        if (i > 997) {             // yellow
                            int j = r.nextInt(7); // pick the knifes
                            switch (j) {
                                case 0:
                                    Case.setImageResource(R.drawable.kw_blue_steel_yellow); // $900
                                    name.setText("★ Kukri Knife | Blue Steel $900");
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    skinVal = 900;
                                    addToNetWorth();
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.kw_case_hardened_yellow); // $1300
                                    name.setText("★ Kukri Knife | Case Hardened $1300");
                                    skinVal = 1300;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.kw_crimson_web_yellow); // $650
                                    name.setText("★ Kukri Knife | Web $650");
                                    skinVal = 650;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    break;
                                case 3:
                                    Case.setImageResource(R.drawable.kw_fadeknife_yellow); // $1572
                                    name.setText("★ Kukri Knife | Fade $1572");
                                    skinVal = 1572;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);

                                    break;
                                case 4:
                                    Case.setImageResource(R.drawable.kw_night_stripe_yellow); // $425
                                    name.setText("★ Kukri Knife | Night Stripe $425");
                                    skinVal = 425;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    break;
                                case 5:
                                    Case.setImageResource(R.drawable.kw_slaughterknife_yellow); // $989
                                    name.setText("★ Kukri Knife | Slaughter $989");
                                    skinVal = 989;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    break;
                                case 6:
                                    Case.setImageResource(R.drawable.kw_stained_yellow); // $550
                                    name.setText("★ Kukri Knife | Stained $550");
                                    skinVal = 550;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.goldsplash);
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_kilowatt); // it broke
                                    break;
                            }

                        } else if (i > 991) {   // red
                            int j = r.nextInt(2); // pick the knifes
                            switch (j) {
                                case 0:
                                    Case.setImageResource(R.drawable.kw_chrome_cannon_red); // $450
                                    name.setText("AWP | Chrome Cannon $450");
                                    skinVal = 450;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.redsplash);
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.kw_inheritance_red); // $400
                                    name.setText("AK-47 | Inheritance $400");
                                    skinVal = 400;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.redsplash);
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_kilowatt); // it broke
                                    break;
                            }

                        } else if (i > 959) {   // pink
                            int j = r.nextInt(3); // pick the knifes
                            switch (j) {
                                case 0:
                                    Case.setImageResource(R.drawable.kw_olympus_violet);    // $50
                                    name.setText("Zeus x27 | Olympus $50");
                                    skinVal = 50;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.kw_jawbreaker_violet); // $45
                                    name.setText("USP-S | Jawbreaker $45");
                                    skinVal = 45;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.kw_black_lotus_violet); // $75
                                    name.setText("M4A1-S | Black Lotus $75");
                                    skinVal = 75;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.pinksplash);
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_kilowatt); // it broke
                                    break;
                            }

                        } else if (i > 800) {   // purple
                            int j = r.nextInt(5); // pick the knifes
                            switch (j) {
                                case 0:
                                    Case.setImageResource(R.drawable.kw_block_18_purple);   // $7
                                    name.setText("Glock-18 | Block-18 $7");
                                    skinVal = 7;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.kw_analog_input_purple); // $6
                                    name.setText("Sawed-Off | Analog Input $6");
                                    skinVal = 6;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.kw_hybrid_purple); // $7.5
                                    name.setText("Five-SeveN | Hybrid $7");
                                    skinVal = 7;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    break;
                                case 3:
                                    Case.setImageResource(R.drawable.kw_etch_lord_purple); // $7.5
                                    name.setText("M4A4 | Etch Lord $7");
                                    skinVal = 7;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    break;
                                case 4:
                                    Case.setImageResource(R.drawable.kw_just_smile_purple); // $7.5
                                    name.setText("MP7 | Just Smile $7");
                                    skinVal = 7;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.purplesplash);
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_kilowatt); // it broke
                                    break;
                            }
                        } else {                 // blue
                            int j = r.nextInt(7); // pick the knifes
                            switch (j) {
                                case 0:
                                    Case.setImageResource(R.drawable.kw_dezastre_blue); // $1.5
                                    name.setText("SSG 08 | Dezastre $2");
                                    skinVal = 2;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 1:
                                    Case.setImageResource(R.drawable.kw_dark_sigil_blue); // $.6
                                    name.setText("Nova | Dark Sigil $0.60");
                                    skinVal = .6;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 2:
                                    Case.setImageResource(R.drawable.kw_hideout_blue); // $.75
                                    name.setText("Dual Berettas| Hideout $0.75");
                                    skinVal = .75;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 3:
                                    Case.setImageResource(R.drawable.kw_irezumi_blue); // $1
                                    name.setText("XM1014 | Irezumi $1");
                                    skinVal = 1;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 4:
                                    Case.setImageResource(R.drawable.kw_lightbox_blue); // $2.5
                                    name.setText("MAC-10 | Light Box $3");
                                    skinVal = 3;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 5:
                                    Case.setImageResource(R.drawable.kw_motorized_blue); // $7.5
                                    name.setText("UMP-45 | Motorized $8");
                                    skinVal = 8;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                case 6:
                                    Case.setImageResource(R.drawable.kw_slag_blue); // $.75
                                    name.setText("Tec-9 | Slag $0.75");
                                    skinVal = .75;
                                    addToNetWorth();
                                    constraintLayout.setBackgroundResource(R.drawable.bluesplash);
                                    break;
                                default:
                                    Case.setImageResource(R.drawable.case_kilowatt); // it broke
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
                    user.setNumKilowattsOpened(user.getNumKilowattsOpened() + 1);
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

    public void back2(View view){
        Intent intent = new Intent(this, CaseSelection.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }
}
