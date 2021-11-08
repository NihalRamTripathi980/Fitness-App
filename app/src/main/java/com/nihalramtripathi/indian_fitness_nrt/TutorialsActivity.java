package com.nihalramtripathi.indian_fitness_nrt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.nihalramtripathi.indian_fitness_nrt.databinding.ActivityTutorialsBinding;

public class TutorialsActivity extends AppCompatActivity {

    ActivityTutorialsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityTutorialsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

binding.absBTn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AbsFragment absFragment = new AbsFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.linearLayoutFrag,absFragment);
        transaction.commit();
    }
});
        binding.chestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChestFragment chestFragment = new ChestFragment ();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayoutFrag,chestFragment);
                transaction.commit();
            }
        });
        binding.legsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LegFragment legFragment = new LegFragment ();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayoutFrag,legFragment);
                transaction.commit();
            }
        });
        binding.bicepsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BicepsFragment bicepsFragment = new BicepsFragment ();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayoutFrag,bicepsFragment);
                transaction.commit();
            }
        });
        binding.tricepsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TricepsFragment tricepsFragment = new TricepsFragment ();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayoutFrag,tricepsFragment);
                transaction.commit();
            }
        });
        binding.obliqueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WeightLoseFragment fragment = new WeightLoseFragment ();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.linearLayoutFrag,fragment);
                transaction.commit();
            }
        });
    }
}