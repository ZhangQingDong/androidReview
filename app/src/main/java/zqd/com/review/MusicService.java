package zqd.com.review;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * <p>Title: zqd.com.review </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: v_xue </p>
 *
 * @author zqd
 * @version 1.0
 * @date 2018/7/19 20:47
 */
public class MusicService extends Service {

    private SoundPool mSoundPoll;
    private int musicId = -1;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Service", "onBind");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        Log.e("Service", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("Service", "onStartCommand");
        try {
            if (mSoundPoll != null) {
                if (musicId != -1) {
                    mSoundPoll.stop(musicId);
                }
                mSoundPoll.release();
            }
            mSoundPoll = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
            mSoundPoll.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                    musicId = i;
                    soundPool.play(i, 1f, 1f, 100, -1, 1.0f);
                }
            });
            mSoundPoll.load(getAssets().openFd("K-391 - Summertime.mp3"), 100);
        } catch (Exception e) {

        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("Service", "onDestroy");
        if (mSoundPoll != null) {
            if (musicId != -1) {
                mSoundPoll.stop(musicId);
            }
            mSoundPoll.release();
        }
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    class MyBinder extends Binder {

    }
}
