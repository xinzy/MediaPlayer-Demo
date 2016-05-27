package com.xinzy.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class CodecActivity extends AppCompatActivity implements SurfaceHolder.Callback
{

	private static final String TAG = "CodecActivity";

	private SurfaceView mSurfaceView;
	private SurfaceHolder mHolder;

	private boolean isSurfaceCreated;

	public static void start(Context context) {
	    Intent starter = new Intent(context, CodecActivity.class);
	    context.startActivity(starter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_codec);

		mSurfaceView = (SurfaceView) findViewById(R.id.surface);
		mHolder = mSurfaceView.getHolder();
		mHolder.addCallback(this);
	}

	public void start(View v)
	{

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		Log.d(TAG, "surfaceCreated: ");
		isSurfaceCreated = true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		Log.d(TAG, "surfaceChanged: ");
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		Log.d(TAG, "surfaceDestroyed: ");
		isSurfaceCreated = false;
	}

	class CodecThread extends Thread
	{

	}
}
