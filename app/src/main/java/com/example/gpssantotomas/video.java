package com.example.gpssantotomas;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.videoView);
        TextView institutionNameTextView = findViewById(R.id.InstitutionName);


        int videoResource = getIntent().getIntExtra("videoResource", 0);
        String institutionName = getIntent().getStringExtra("institutionName");


        institutionNameTextView.setText(institutionName);

        if (videoResource != 0) {
            String videoPath = "android.resource://" + getPackageName() + "/" + videoResource;
            Uri videoUri = Uri.parse(videoPath);
            videoView.setVideoURI(videoUri);
            videoView.requestFocus();
            videoView.start();
        }
    }
}