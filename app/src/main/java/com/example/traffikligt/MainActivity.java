package com.example.traffikligt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
private LinearLayout B_1,B_2,B_3;
private Button Button_1;
private boolean Start_stop=false;
private int contr=0;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B_1=findViewById(R.id.bulb1);
        B_2=findViewById(R.id.bulb2);
        B_2=findViewById(R.id.bulb3); 
        Button_1=findViewById(R.id.button2);
    }
    public void onClikStart(View View) {
        if (!Start_stop) {
            Start_stop = true;
            Button_1.setText("Старт");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (Start_stop) {
                        contr++;
                        switch (contr)
                        {
                            case 1:
                                B_1.setBackgroundColor(getResources().getColor(R.color.green));
                                B_2.setBackgroundColor(getResources().getColor(R.color.purple_200));
                                B_3.setBackgroundColor(getResources().getColor(R.color.purple_200));

                               break;

                            case 2:
                                B_1.setBackgroundColor(getResources().getColor(R.color.purple_200));
                                B_2.setBackgroundColor(getResources().getColor(R.color.yelou));
                                B_3.setBackgroundColor(getResources().getColor(R.color.purple_200));
                                    break;

                            case 3:
                                B_1.setBackgroundColor(getResources().getColor(R.color.purple_200));
                                B_2.setBackgroundColor(getResources().getColor(R.color.purple_200));
                                B_3.setBackgroundColor(getResources().getColor(R.color.red));
                                contr=0;
                                    break;

                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }
        else
            {
            Start_stop=false;
            Button_1.setText("Стопp");

        }

    }
    public void onDestroy() {
        super.onDestroy();
        Start_stop = false;

    }
    }
