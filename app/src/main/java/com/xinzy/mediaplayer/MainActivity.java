package com.xinzy.mediaplayer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	private static final int PERMISSION_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
		{
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_CODE);
		}
	}

	public void sufaceClick(View view)
	{
		SurfaceActivity.start(this);
	}

	public void videoClick(View view)
	{
		VideoActivity.start(this);
	}

	public void codecClick(View view)
	{
		CodecActivity.start(this);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
	{
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		if (PERMISSION_CODE == requestCode)
		{
			if (grantResults[0] != PackageManager.PERMISSION_GRANTED)
			{
				finish();
			}
		}
	}
}
