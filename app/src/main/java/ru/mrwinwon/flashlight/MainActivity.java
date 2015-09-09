package ru.mrwinwon.flashlight;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button switch_btn = null;
    private Button special_btn = null;
    private RelativeLayout firstBackground;
    private RelativeLayout secondBackgroud;

    static Camera camera = null;
    protected boolean isFlashOn;
    protected boolean hasFlash;
    static Camera.Parameters params;


    private void errorDialog(){
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
        dialog.setTitle("Error");
        dialog.setMessage("Sorry, our device doesn't support flashlight");
        dialog.setButton("Ok", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                finish(); // если мы находимся в одном активити, то он его закрывает
            }
        });

        dialog.show();
        return;
    }

    protected void getCamera(){
        if(camera == null){
            try {
                camera = Camera.open();
                params = camera.getParameters();
            } catch (RuntimeException e){
                e.printStackTrace();
            }
        }
    }

    protected void turnOn(){
        if(!isFlashOn){
            if(camera == null || params == null)
                return;
        }
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
        camera.setParameters(params);
        camera.startPreview();
        isFlashOn = true;
        firstBackground.setBackgroundResource(R.drawable.radial_second);

    }

    protected void turnOff(){
        if(isFlashOn){
            if(camera == null || params == null)
                return;
        }
        params = camera.getParameters();
        params.setFlashMode(Parameters.FLASH_MODE_OFF);
        camera.setParameters(params);
        camera.startPreview();
        isFlashOn = false;
        secondBackgroud.setBackgroundResource(R.drawable.radial);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch_btn = (Button) findViewById(R.id.switch_btn);
        special_btn = (Button) findViewById(R.id.special_btn);
        special_btn.setOnClickListener(this);
        firstBackground = (RelativeLayout) findViewById(R.id.background);
        secondBackgroud = (RelativeLayout) findViewById(R.id.background);

        hasFlash = getApplicationContext()
                .getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if(!hasFlash){
            errorDialog();
        }

        getCamera();

        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFlashOn){
                    turnOff();
                } else {
                    turnOn();
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        getCamera();

        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    turnOff();
                } else {
                    turnOn();
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();

        getCamera();

        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    turnOff();
                } else {
                    turnOn();
                }
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();

        getCamera();

        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    turnOff();
                } else {
                    turnOn();
                }
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();

        getCamera();

        switch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFlashOn) {
                    turnOff();
                } else {
                    turnOn();
                }
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.special_btn:
                Intent intent = new Intent(this, FullscreenActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }






}
