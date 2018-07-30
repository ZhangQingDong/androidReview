package zqd.com.tablayoutviewpager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: zqd.com.tablayoutviewpager </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>Company: v_xue </p>
 *
 * @author zqd
 * @version 1.0
 * @date 2018/7/30 10:13
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> stringArrayList = new ArrayList<>();

    {
        fragmentList.add(BlankFragment.newInstance("1", "1"));
        fragmentList.add(BlankFragment.newInstance("1", "1"));
        fragmentList.add(BlankFragment.newInstance("1", "1"));
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringArrayList.get(position);
    }
}
