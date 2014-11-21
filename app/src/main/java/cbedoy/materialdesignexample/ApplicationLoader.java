package cbedoy.materialdesignexample;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by admin on 11/21/14.
 */
public class ApplicationLoader extends Application
{
    public static volatile Context mainContext = null;
    public static volatile Handler mainHandler = null;
    public static volatile LayoutInflater mainLayoutInflater;
    public static volatile Typeface boldFont;
    public static volatile Typeface regularFont;
    public static volatile Typeface thinFont;
    public static volatile Typeface lightFont;
    public static volatile Typeface cardFont;
    public static volatile DisplayImageOptions options;

    @Override
    public void onCreate() {
        super.onCreate();
        mainContext = getApplicationContext();
        mainHandler = new Handler(mainContext.getMainLooper());
        mainLayoutInflater = (LayoutInflater) mainContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        boldFont 	= Typeface.createFromAsset(mainContext.getAssets(), "fonts/Roboto-Bold.ttf");
        regularFont = Typeface.createFromAsset(mainContext.getAssets(), "fonts/Roboto-Regular.ttf");
        thinFont 	= Typeface.createFromAsset(mainContext.getAssets(), "fonts/Roboto-Thin.ttf");
        lightFont 	= Typeface.createFromAsset(mainContext.getAssets(), "fonts/Roboto-Light.ttf");
        cardFont 	= Typeface.createFromAsset(mainContext.getAssets(), "fonts/CardType.ttf");


        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_ab_drawer)
                .showImageForEmptyUri(R.drawable.ic_ab_drawer)
                .showImageOnFail(R.drawable.ic_ab_drawer)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .diskCacheSize(5 * 1024 * 1024) // 50 Mb
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static int getAppVersion() {
        try {
            PackageInfo packageInfo = mainContext.getPackageManager().getPackageInfo(mainContext.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get package name: " + e);
        }
    }



}
