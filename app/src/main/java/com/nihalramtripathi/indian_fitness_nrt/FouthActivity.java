package com.nihalramtripathi.indian_fitness_nrt;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;

import com.nihalramtripathi.indian_fitness_nrt.databinding.ActivityFouthBinding;


public class FouthActivity extends AppCompatActivity {



    ActivityFouthBinding binding;
 CountDownTimer countDownTimer;
 Boolean counterIsActive= false;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding=ActivityFouthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());










        String from = getIntent().getStringExtra("type");
            // for Second activity
if ("first".equals(from)) {
    int womenImage = getIntent().getIntExtra("yogaImage", 0);
    String womenName = getIntent().getStringExtra("yogaName");

    binding.reImageView.setImageResource(womenImage);
    binding.reTextView.setText(womenName);

}
       // for Third Activity
else {
    int menImage = getIntent().getIntExtra("menImage", 0);
    String menName = getIntent().getStringExtra("menName");

    binding.reTextView.setText(menName);
    binding.reImageView.setImageResource(menImage);
}


mediaPlayer =MediaPlayer.create(getApplicationContext(),R.raw.alarm);
binding.timerSb.setMax(300);
binding.timerSb.setProgress(60);
binding.timerSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        update(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
});
}

private void update(int progress) {
int minutes= progress/60;
int seconds = progress%60;
String secondsFinal ="";
if(seconds <=9) {
    secondsFinal = "0" + seconds;
}
else{
    secondsFinal =""+ seconds;
}
binding.timerSb.setProgress(progress);
binding.timerTv.setText(""+ minutes + ":"  + secondsFinal);
}

    public void start_timer(View view) {
if (counterIsActive == false){
    counterIsActive= true;
    binding.timerSb.setEnabled(false);
    binding.startBtn.setText("STOP");
    countDownTimer= new CountDownTimer(binding.timerSb.getProgress()*1000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            update((int) millisUntilFinished / 1000);
        }

        @Override
        public void onFinish() {
            reset();

            if (mediaPlayer != null)
                mediaPlayer.start();

        }
    }.start();
} else{
    reset();
}
    }
private void reset() {
        binding.timerTv.setText("1:00");
        binding.timerSb.setProgress(60);
        countDownTimer.cancel();
        binding.startBtn.setText("START");
        binding.timerSb.setEnabled(true);
        counterIsActive=false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (counterIsActive) {
            countDownTimer.cancel();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (counterIsActive) {
            countDownTimer.cancel();
        }
    }
}