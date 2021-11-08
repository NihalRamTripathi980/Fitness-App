package com.nihalramtripathi.indian_fitness_nrt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.multidex.BuildConfig;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nihalramtripathi.indian_fitness_nrt.Adapters.YogaAdapter;
import com.nihalramtripathi.indian_fitness_nrt.Models.YogaModel;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= findViewById(R.id.yogaRecyclerView);

        ArrayList<YogaModel> list = new ArrayList<>();
        list.add(new YogaModel(R.drawable.push_up,"Push Up"));
        list.add(new YogaModel(R.drawable.sumo_squat,"Sumo Squat"));
        list.add(new YogaModel(R.drawable.advanced_bridge,"Advanced Bridge"));
        list.add(new YogaModel(R.drawable.alternate_heel_touchers," Heel Touch"));
        list.add(new YogaModel(R.drawable.bear_squat,"Bear Squat"));
        list.add(new YogaModel(R.drawable.bicycle_crunches,"Bicycle Crunch"));
        list.add(new YogaModel(R.drawable.calf_raises,"Calf Raise"));
        list.add(new YogaModel(R.drawable.cobra_lat_pulldown,"Cobra Lat PullDown"));
        list.add(new YogaModel(R.drawable.cossack_squat,"Cossack Squat"));
        list.add(new YogaModel(R.drawable.crunches,"Crunch"));
        list.add(new YogaModel(R.drawable.downward_dog_crunch,"Downward Dog Crunch"));
// 10
        list.add(new YogaModel(R.drawable.fingertip_to_toe_jack,"Fingertip to Toe Jack"));
        list.add(new YogaModel(R.drawable.in_and_out_jack,"In Out Jack"));
        list.add(new YogaModel(R.drawable.knee_to_elbow_kickback,"knee To Elbow"));
        list.add(new YogaModel(R.drawable.lying_hamstring_curls,"Lying Hamstring"));
        list.add(new YogaModel(R.drawable.mountain_climber_twist,"Mountain Climbing"));
        list.add(new YogaModel(R.drawable.pike_push_up,"Pike Push Up"));
        list.add(new YogaModel(R.drawable.plank_jacks,"Plank Jack"));
        list.add(new YogaModel(R.drawable.russian_twist,"Russian Twist"));
        list.add(new YogaModel(R.drawable.spiderman_plank,"Spiderman Plank"));
        list.add(new YogaModel(R.drawable.ski_abs,"Ski ABS"));



        YogaAdapter adapter = new YogaAdapter(list,this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

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
                Intent i= new Intent(SecondActivity.this,TutorialsActivity.class);
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