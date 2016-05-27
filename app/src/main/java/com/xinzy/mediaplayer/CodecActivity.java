package com.xinzy.mediaplayer;

import android.content.Context;
import android.content.Intent;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.IOException;

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
		new CodecThread(mHolder.getSurface()).start();
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
		private MediaCodec mMediaCodec;
		private MediaExtractor mExtractor;

		private Surface mSurface;
		private String filePath;

		public CodecThread(Surface surface)
		{
			mSurface = surface;
			filePath = Environment.getExternalStorageDirectory() + "/Movies/jinganglang01.mp4";
		}

		@Override
		public void run()
		{
			mExtractor = new MediaExtractor();
			try
			{
				mExtractor.setDataSource(filePath);
				final int nTracks = mExtractor.getTrackCount();
				Log.d(TAG, "track count = " + nTracks);

				for (int i = 0; i < nTracks; i++)
				{
					MediaFormat format = mExtractor.getTrackFormat(i);
					String mine = format.getString(MediaFormat.KEY_MIME);
					Log.d(TAG, "mine type = " + mine);

					if (mine.startsWith("video/"))
					{
						mExtractor.selectTrack(i);
						mMediaCodec = MediaCodec.createDecoderByType(mine);
						mMediaCodec.configure(format, mSurface, null, 0);
					}
				}

				if (mMediaCodec == null) return ;
				mMediaCodec.start();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
