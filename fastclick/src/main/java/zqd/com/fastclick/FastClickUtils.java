package zqd.com.fastclick;

import android.widget.Toast;

/**
 * <p>Title: zqd.com.fastclick </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: v_xue </p>
 *
 * @author zqd
 * @version 1.0
 * @date 2018/7/30 15:23
 */
public class FastClickUtils {

    public static final long midTime = 500;

    private static long firstClickTime = 0;
    private static long firstOutClickTime = 0;

    /**
     * 在点击事件外添加此判断有效防止双击误触
     *
     * @return
     */
    public static boolean isClickValidate() {
        if (System.currentTimeMillis() - firstClickTime > midTime) {
            firstClickTime = getTimeLong();
            return true;
        } else {
            firstClickTime = getTimeLong();
            return false;
        }
    }

    /**
     * 双击退出程序
     *
     * @return
     */
    public static boolean isDoubleClickOut() {
        if (getTimeLong() - firstOutClickTime < midTime * 3) {
            firstOutClickTime = getTimeLong();
            return true;
        } else {
            firstOutClickTime = getTimeLong();
            return false;
        }
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static long getTimeLong() {
        return System.currentTimeMillis();
    }


}
