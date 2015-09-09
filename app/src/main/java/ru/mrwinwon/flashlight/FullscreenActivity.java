package ru.mrwinwon.flashlight;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FullscreenActivity extends MainActivity{

    private Button love_btn = null;
    private Button peace_btn = null;
    private Button sos_btn = null;

    private long dot = 500;
    private long dash = 1000;
    private long space = 3500;

    private void SOS(){
            try {
                turnOn();               //  S
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(dash);

                turnOn();               // O
                Thread.sleep(dash);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dash);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dash);
                turnOff();
                Thread.sleep(dash);

                turnOn();               // S
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(dot);
                turnOn();
                Thread.sleep(dot);
                turnOff();
                Thread.sleep(space);

            } catch (Exception e) {
            }
    }

    private void LOVE(){
        try {
            turnOn();               // L
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // O
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dash);

            turnOn();               //  V
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // E
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(space);

        }catch (Exception e){}
    }

    private void PEACE(){
        try{
            turnOn();               // P
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // E
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // A
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // C
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dash);
            turnOff();
            Thread.sleep(dot);
            turnOn();
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(dash);

            turnOn();               // E
            Thread.sleep(dot);
            turnOff();
            Thread.sleep(space);

        }catch (Exception e) {}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        sos_btn = (Button) findViewById(R.id.sos_btn);
        love_btn = (Button) findViewById(R.id.love_btn);
        peace_btn = (Button) findViewById(R.id.peace_btn);

        getCamera();

        sos_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    SOS();
            }
        });

        love_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    LOVE();
            }
        });

        peace_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PEACE();
            }
        });
    }



}
