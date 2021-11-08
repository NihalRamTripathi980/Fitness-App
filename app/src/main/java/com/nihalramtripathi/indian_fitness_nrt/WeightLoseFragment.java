package com.nihalramtripathi.indian_fitness_nrt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public class WeightLoseFragment extends Fragment {



    public WeightLoseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weight_lose, container, false);
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view_weight_lose);
        getLifecycle().addObserver(youTubePlayerView);

        YouTubePlayerView youTubePlayerView2 = view.findViewById(R.id.youtube_player_view_weight_lose2);
        getLifecycle().addObserver(youTubePlayerView2);
        return view;
    }
}