package com.nihalramtripathi.indian_fitness_nrt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.multidex.BuildConfig;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nihalramtripathi.indian_fitness_nrt.Adapters.MenAdapter;
import com.nihalramtripathi.indian_fitness_nrt.Models.MenModel;
import com.nihalramtripathi.indian_fitness_nrt.databinding.ActivityThirdBinding;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {
ActivityThirdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<MenModel> list= new ArrayList<>();


        list.add(new MenModel(R.drawable.pushups,"Push Up"));
        list.add(new MenModel(R.drawable.kneepushs,"Knee Push"));
        list.add(new MenModel(R.drawable.pike_push_up,"Pike Push Up"));
        list.add(new MenModel(R.drawable.sumo_squat,"Sumo Squat"));
        list.add(new MenModel(R.drawable.spiderman_plank,"Spiderman Plank"));
        list.add(new MenModel(R.drawable.russian_twist,"Russian Twist"));
        list.add(new MenModel(R.drawable.mountain_climbing,"Mountain Climbing"));
        list.add(new MenModel(R.drawable.knee_to_elbow_kickback,"knee To Elbow"));
        list.add(new MenModel(R.drawable.alternate_heel_touchers," Heel Touch"));
        list.add(new MenModel(R.drawable.bear_squat,"Bear Squat"));
        list.add(new MenModel(R.drawable.bicycle_crunches,"Bicycle Crunch"));
        list.add(new MenModel(R.drawable.calf_raises,"Calf Raise"));
        list.add(new MenModel(R.drawable.cobra_lat_pulldown,"Cobra Lat PullDown"));
        list.add(new MenModel(R.drawable.cossack_squat,"Cossack Squat"));
        list.add(new MenModel(R.drawable.crunches,"Crunch"));
        list.add(new MenModel(R.drawable.downward_dog_crunch,"Downward Dog Crunch"));
// 10

        list.add(new MenModel(R.drawable.in_and_out_jack,"In Out Jack"));
        list.add(new MenModel(R.drawable.lying_hamstring_curls,"Lying Hamstring"));
        list.add(new MenModel(R.drawable.mountain_climber_twist,"Mountain Climbing"));
        list.add(new MenModel(R.drawable.plank_jacks,"Plank Jack"));
        list.add(new MenModel(R.drawable.ski_abs,"Ski ABS"));



        MenAdapter adapter = new MenAdapter(list,this);
        binding.menRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.menRecyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case
                    R.id.tips:
                Intent i= new Intent(ThirdActivity.this,TutorialsActivity.class);
                startActivity(i);
                break;
            case
                    R.id.rate:
                Uri uri= Uri.parse("https://play.google.com/store/apps/details?id="+getApplicationContext().getPackageName());
                Intent intent= new Intent(Intent.ACTION_VIEW,uri);
                try {
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open" +e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                break;
            case
                    R.id.share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Aadi Yogi");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    Toast.makeText(this, "Unable to Choose", Toast.LENGTH_SHORT).show();
                }

                break;
            case
                    R.id.exit:
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
            default:
                break;
        }
        return true;
    }
}