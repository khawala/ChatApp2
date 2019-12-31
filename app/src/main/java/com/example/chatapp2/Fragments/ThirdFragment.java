package com.example.chatapp2.Fragments;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.chatapp2.GalleryActivity;
import com.example.chatapp2.R;

public class ThirdFragment extends Fragment implements View.OnClickListener{  // Create a VideoView variable, a MediaPlayer variable, and an int to hold the current
    // Create a VideoView variable, a MediaPlayer variable, and an int to hold the current
    // video position.
    private VideoView view;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;
    Button galleryButton;
    MediaController mc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        mc= new MediaController(getActivity());
        galleryButton = (Button) rootView.findViewById(R.id.galleryButton);
        view = (VideoView)rootView.findViewById(R.id.videoView);
        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.plexus_bg;
        view.setVideoURI(Uri.parse(path));
        //hide the visibility of video controller
        mc.setVisibility(View.INVISIBLE);
        view.setMediaController(mc);

        view.start();

        view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });
        galleryButton.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onPause() {
        super.onPause();
        // Capture the current video position and pause the video.
        mCurrentVideoPosition = view.getCurrentPosition();
        view.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Restart the video when resuming the Activity
        view.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // When the Activity is destroyed, release our MediaPlayer and set it to null.
        mMediaPlayer = null;
    }

    @Override
    public void onClick(View v) {
        Intent numbersIntent = new Intent(getActivity(), GalleryActivity.class);
        startActivity(numbersIntent);
    }
}