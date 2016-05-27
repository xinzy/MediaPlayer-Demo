package com.xinzy.mediaplayer.util;

import android.os.Environment;

import java.io.File;

/**
 * Created by gaodun on 2016/5/26.
 */
public class Urls
{

	public static final String FILE_LOCAL = new File(Environment.getExternalStorageDirectory(), "Movies/jinganglang01.mp4").getAbsolutePath();

	public static final String FILE_REMOTE1 = "http://qiubai-video.qiushibaike.com/N17WMY8KKBB15YRD.mp4";

}
