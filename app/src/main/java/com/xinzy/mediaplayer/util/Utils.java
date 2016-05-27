package com.xinzy.mediaplayer.util;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;

/**
 * Created by gaodun on 2016/5/26.
 */
public class Utils
{
	public static final String formatTime(int ms)
	{
		int sec = ms / 1000;
		int second = sec % 60;
		int min = sec / 60;
		int minute = min % 60;
		int hor = min / 60;

		return hor + ":" + (minute < 10 ? "0" + minute : minute) + ":" + (second < 10 ? "0" + second : second);
	}

	public static final int dp2px(Context context, int dp)
	{
		float density = context.getResources().getDisplayMetrics().density;

		return (int) (density * dp + 0.5f);
	}

	public static final void setFullScreen(Activity activity, boolean isFull)
	{
		if (isFull)
		{
			activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else
		{
			final WindowManager.LayoutParams attrs = activity.getWindow().getAttributes();
			attrs.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
			activity.getWindow().setAttributes(attrs);
		}
	}
}
