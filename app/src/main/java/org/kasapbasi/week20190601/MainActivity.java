package org.kasapbasi.week20190601;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar sb;
    private TextView timerTv;

    public void ControlClick(View v){


        CountDownTimer ct=new CountDownTimer(sb.getProgress()*1000,1000){

             @Override
             public void onTick(long l) {
                 sb.setProgress(sb.getProgress()-1);
                 UpdateTimer();
             }

             @Override
             public void onFinish() {
                 MediaPlayer mp= MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
                 mp.start();

             }
         };

        ct.start();
        Log.i("Test","clicked");
    }

    public void UpdateTimer(){

        int minutes=sb.getProgress()/60;
        int seconds=sb.getProgress()%60;
        if(seconds<=9)
            timerTv.setText(minutes +":0" +seconds);
        else
            timerTv.setText(minutes +":" +seconds);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb= (SeekBar) findViewById(R.id.seekBar);
        timerTv=(TextView) findViewById(R.id.timerTextView);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               UpdateTimer();
                Log.i("Test","clicked " + sb.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
