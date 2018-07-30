package zqd.com.fastclick;

import android.app.Application;

/**
 * <p>Title: zqd.com.fastclick </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: v_xue </p>
 *
 * @author zqd
 * @version 1.0
 * @date 2018/7/30 15:36
 */
public class MyApplication extends Application {

    public static MyApplication myApplication = new MyApplication();

    public static MyApplication getInstance() {
        return myApplication;
    }

    @Override

    public void onCreate() {
        super.onCreate();
    }

}
