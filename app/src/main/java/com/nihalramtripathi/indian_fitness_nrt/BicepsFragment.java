package com.nihalramtripathi.indian_fitness_nrt;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public  class BicepsFragment extends Fragment {

    public BicepsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biceps, container, false);


        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view_biceps);
        getLifecycle().addObserver(youTubePlayerView);

        YouTubePlayerView youTubePlayerView2 = view.findViewById(R.id.youtube_player_view_biceps2);
        getLifecycle().addObserver(youTubePlayerView2);

        return  view;
    }
}