package com.xinzy.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import java.io.File;

public class VideoActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener
{
	private static final String TAG = "VideoActivity";

	private VideoView mVideoView;

	private String  mp4Path;

	public static void start(Context context)
	{
	    Intent starter = new Intent(context, VideoActivity.class);
	    context.startActivity(starter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);

		mVideoView = (VideoView) findViewById(R.id.videoView);
		mVideoView.setOnPreparedListener(this);
		File file = new File(Environment.getExternalStorageDirectory(), "Movies/jinganglang01.mp4");
		mp4Path = file.getAbsolutePath();
		Log.d(TAG, "onCreate: " + file.exists() + "; " + mp4Path);
	}

	public void startClick(View view)
	{
		Log.d(TAG, "startClick: ");
		mVideoView.setVideoPath(mp4Path);
		mVideoView.start();
	}

	public void pauseClick(View view)
	{

	}

	@Override
	public void onPrepared(MediaPlayer mp)
	{
		Log.d(TAG, "onPrepared: ");
	}
}
